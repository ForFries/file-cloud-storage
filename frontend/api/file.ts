// src/api/file.ts
import request from '@/utils/request.ts';  // 导入封装好的axios实例

// 文件上传 API
export const uploadFile = (formData: FormData) => {
    return request.post('/file/upload', formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    });
};
