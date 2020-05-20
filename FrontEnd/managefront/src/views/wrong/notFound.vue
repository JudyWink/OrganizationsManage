<template>
  <div id="notFound_box">
    <div>
      <div id="notFound">

        <img  style="width: 150px;height: 150px" src="../../assets/img/404.png">
        <h1>
          页面找不到了啊
        </h1>
        <el-button type="success"  @click="login">返回首页</el-button>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "notFound ",
        methods: {
            //登录按钮
            login() {
                this.$router.push('/index')
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

  #notFound {
    margin: auto;
  }

  #notFound_box{
    margin: auto;
    width: 80%;
    height: 450px;
    position: center;
    margin-top: 150px;
  }

</style>

