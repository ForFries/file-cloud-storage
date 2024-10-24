<template>
  <div>
    <el-table :data="fileDirectoryData" style="width: 100%" @row-dblclick="onRowDblClick">
      <el-table-column prop="name" label="Name" width="">
        <template #default="scope">
          <!-- 检查 scope.row 是否存在 -->
          <span v-if="scope.row && scope.row.type === 'directory'">
            📁 {{ scope.row.directoryName }} <!-- 文件夹 -->
          </span>
          <span v-else-if="scope.row">
            📄 {{ scope.row.originalFileName }} <!-- 文件 -->
          </span>
        </template>
      </el-table-column>

      <el-table-column prop="fileSize" label="Size (KB)" width="120">
        <template #default="scope">
          <!-- 检查 scope.row 是否存在且是文件 -->
          <span v-if="scope.row && scope.row.type === 'file'">
            {{ scope.row.fileSize }}
          </span>
        </template>
      </el-table-column>

      <el-table-column prop="createdAt" label="Created/Uploaded At" width="300">
        <template #default="scope">
          <!-- 检查 scope.row 是否存在 -->
          <span v-if="scope.row&& scope.row.type === 'directory'">{{ scope.row.createdAt }}</span>
          <span v-if="scope.row&& scope.row.type === 'file'">{{ scope.row.uploadTime }}</span>
        </template>
      </el-table-column>

      <el-table-column label="Actions" width="120">
        <template #default="scope">
          <!-- 检查 scope.row 是否存在且是文件 -->
          <el-button v-if="scope.row && scope.row.type === 'file'" size="mini" type="primary" @click="downloadFile(scope.row)">
            Download
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';

// 初始化文件和文件夹数据
const fileDirectoryData = ref<any[]>([]);

// 文件下载方法
const downloadFile = (file: { fileUrl: string }) => {
  window.open(file.fileUrl);
};

// 双击行的处理函数
const onRowDblClick = (row: { type: string, id: number }) => {
  if (row.type === 'directory') {
    fetchDirectoryContent(row.id); // 双击文件夹时获取该文件夹的内容
  }
};

// 获取文件夹下的文件和目录
const fetchDirectoryContent = async (directoryId: number) => {
  try {
    const response = await axios.get(`/api/directory/${directoryId}`);
    if (response.data.code === 0) {
      const directories = response.data.data.directories.map((dir: any) => ({
        ...dir,
        type: 'directory',
      }));
      const files = response.data.data.files.map((file: any) => ({
        ...file,
        type: 'file',
      }));

      // 将目录和文件合并，更新表格数据
      fileDirectoryData.value = [...directories, ...files];
    } else {
      ElMessage.error('Failed to fetch directory contents');
    }
  } catch (error) {
    ElMessage.error('Error occurred while fetching directory contents');
  }
};

// 初始化时加载根目录
fetchDirectoryContent(1);
</script>

<style scoped>
.el-table {
  margin-bottom: 20px;
}
</style>
