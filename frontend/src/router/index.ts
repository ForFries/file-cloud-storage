import { createRouter, createWebHistory } from 'vue-router'
import UploadVue from "@/views/UploadVue.vue";
import LoginVue from "@/views/LoginVue.vue";
import MainVue from "@/views/MainVue.vue";

//定义路由关系
const routes = [
  { path: '/login', component: LoginVue },
  { path: '/upload',component: UploadVue},
  {
    path: '/', component: MainVue, children: [
      // { path: '/upload', component: UploadVue}
    ]
  }
]

//创建路由器
const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

export default router
