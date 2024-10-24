<script setup lang="ts">

import FileUpload from "@/components/FileUpload.vue";
</script>

<template>
  <div class="file-upload-container">
    <FileUpload/>
  </div>

</template>

<style scoped>
.file-upload-container {
  width: 500px; /* 固定宽度 */
  height: 300px; /* 固定高度 */
  padding: 10px;
  box-sizing: border-box; /* 确保padding和border不影响宽高 */
}
</style>