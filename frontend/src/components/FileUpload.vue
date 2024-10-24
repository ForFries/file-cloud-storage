<template>
  <el-row justify="center">
    <el-col :span="24">
      <div class="button-container">
        <el-button type="primary" @click="uploadFiles">确认上传</el-button>
        <el-button type="danger" @click="clearFiles">取消</el-button>
      </div>
    </el-col>
  </el-row>
<el-row justify="space-around">
  <el-col :span="24">
    <div>
      <el-upload
          class="upload-demo"
          ref="uploadRef"
          drag
          action="/api/file/upload"
          multiple
          :data="uploadParams"
          :auto-upload="false"
          :before-upload="beforeUpload"
      >
        <el-icon class="el-icon--upload"><upload-filled /></el-icon>
        <div class="el-upload__text">
          Drop file here or <em>click to upload</em>
        </div>
        <template #tip>
          <div class="el-upload__tip">
            可以上传任意文件
          </div>
        </template>
      </el-upload>
    </div>
  </el-col>
</el-row>

</template>

<style scoped>
.el-row {
  margin-bottom: 10px;
}
.button-container {
  display: flex;
  justify-content: center; /* 水平居中 */
  gap: 10px; /* 按钮之间的间距 */
}
</style>

<script setup lang="ts">
import { UploadFilled } from '@element-plus/icons-vue'
import {ElMessage} from "element-plus";
import {ref} from "vue";

// 获取 el-upload 的 ref
const uploadRef = ref(null)

// const uploadParams = ref({
//   directoryId: '1',  // 附加的数据，例如文件存储目录
//   userId: admin,  // 附加数据：用户 ID
// });
// 提交上传
const uploadFiles = () => {
  uploadRef.value.submit()  // 调用 el-upload 的 submit 方法手动上传文件
}

// 清空文件列表
const clearFiles = () => {
  ElMessage.info("已清空上传列表");
  uploadRef.value.clearFiles()  // 调用 el-upload 的 clearFiles 方法清空已上传文件
}

const beforeUpload = (file) => {
  if (!file.type) {
    // type为空，表示这是一个文件夹，阻止上传
    ElMessage.error("不能上传文件夹！");
    return false
  }else {
    ElMessage.success("已提交上传");
    return true // 允许文件上传
  }


}
</script>