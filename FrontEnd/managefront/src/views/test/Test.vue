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
            this.$axios.post('/testResAndReq')
                .then(res =>{
                    console.log(res)
                })
        }
    }
</script>
