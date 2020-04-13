<template>
  <div id="test">
    <h3><router-link to="/test">test画面</router-link></h3>
    <router-view/>
  </div>
</template>

<script>
    export default {
        name: 'Test',
        data(){
            return{

            }
        },
        //实现跨域
        created() {
            // 请求接口 后台的接口为5001 我们本地的接口为8080,所以我们需要去到vue.config.js配置跨域 http://localhost:5001/api/
            this.$axios.post('/testResAndReq')
                .then(res =>{
                    console.log(res)
                })
        }
    }
</script>
