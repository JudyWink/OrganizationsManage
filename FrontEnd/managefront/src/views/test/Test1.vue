<template>
  <div id="test">
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
            this.$router.replace("/havaOrgUsers");
        }
    }
</script>
