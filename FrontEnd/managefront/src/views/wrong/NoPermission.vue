<template>
  <div id="noPermission_box">
    <div>
      <div id="noPermission">

        <img style="width: 150px;height: 150px" src="../../assets/img/noPermission.png">
        <h1>
          嘿嘿...同学以你的权限不能访问
        </h1>
        <el-button type="success"  @click="login">已有账户，马上登陆</el-button>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "NoPermission ",
        methods: {
            //登录按钮
            login() {
                this.$router.push('/login')
            },
        }
    }
</script>


<style type="text/css">

  body {
    font-family: "宋体";
    background: no-repeat;
    background-size: 100%;
    color: black;
  }

  #noPermission {
    margin: auto;
  }

  #noPermission_box{
    margin: auto;
    width: 80%;
    height: 450px;
    position: center;
    margin-top: 150px;
  }

</style>

