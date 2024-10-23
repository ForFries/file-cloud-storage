// src/utils/axios.ts
import axios from 'axios';
import { ElMessage } from 'element-plus';
import router from '@/router';
import { useTokenStore } from '@/stores/token';

const baseURL = '/api';
const instance = axios.create({ baseURL });

// 请求拦截器
instance.interceptors.request.use(
    (config) => {
        // const tokenStore = useTokenStore();
        // if (tokenStore.token) {
        //     config.headers.Authorization = `${tokenStore.token}`;
        // }
        return config;
    },
    (err) => {
        return Promise.reject(err);
    }
);

// 响应拦截器
instance.interceptors.response.use(
    (response) => {
        if (response.data.code === 0) {
            return response.data;
        }
        ElMessage.error(response.data.msg || '服务异常');
        return Promise.reject(response.data);
    },
    (error) => {
        if (error.response && error.response.status === 401) {
            ElMessage.error('请先登录');
            router.push('/login');
        } else {
            ElMessage.error('服务异常');
        }
        return Promise.reject(error);
    }
);

export default instance;
