import Vue from 'vue'
import App from './App'
import router from "./router";
import ElementUI from 'element-ui';
import {Loading,Message} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';

// 配置axios
Vue.prototype.$axios = axios;
axios.defaults.baseURL = 'http://127.0.0.1:8021';//全局配置跨域url地址
axios.defaults.timeout = 5000;
axios.defaults.headers.post['Content-Type'] = 'application/json';
// http request 拦截器
var loadingInstace;
axios.interceptors.request.use(
  config => {
    loadingInstace = Loading.service({fullscreen: true});
    // const token = sessionStorage.getItem('token')
    // if (token ) { // 判断是否存在token，如果存在的话，则每个http header都加上token
    //   config.headers.authorization = token  //请求头加上token
    // }
    return config
  },
  error => {
    loadingInstace.close();
    Message.error({
      message:"加载超时"
    })
    return Promise.reject(error)
  });

//http response 拦截器
axios.interceptors.response.use(date => {
  loadingInstace.close();
  return date;
},error => {
  Message.error({
    message:"加载失败"
  })
  return Promise.reject(error)
});
//

Vue.use(ElementUI);
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router, // 在vue中使用router
  render: h => h(App)
})
