<template>
  <el-button type="primary" @click="uploadFiles">确认上传</el-button>
  <el-button type="danger" @click="clearFiles">取消</el-button>
  <el-upload
      class="upload-demo"
      ref="uploadRef"
      drag
      action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
      multiple
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

</template>

<script setup lang="ts">
import { UploadFilled } from '@element-plus/icons-vue'
import {ElMessage} from "element-plus";
import {ref} from "vue";

// 获取 el-upload 的 ref
const uploadRef = ref(null)

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