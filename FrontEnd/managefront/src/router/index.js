import Vue from 'vue'
import VueRouter from 'vue-router'  // 引入vue-router

// 引入要跳转的vue组件
import Login from "../views/login/Login";
import Index from "../views/index/Index";
import Menu from "../components/content/menu/Menu"

// 在vue中注入Router
Vue.use(VueRouter)

// 配置路由路径
const routes =[
  {
    path: '/',
    redirect: '/login' //域名重定向
  },
  {
    path: '/login',
    component: Login,
    meta:{
      keepalive:false
    }
  },
  {
    path: '/index',
    component: Index,
    meta:{
      keepalive:true
    }
  },{
    path: '/menu',
    component: Menu,
  },
  ]

// 将路径注入到Router中
var router = new VueRouter({
  'mode': 'history',
  routes
})

// 导出路由
export default router;
