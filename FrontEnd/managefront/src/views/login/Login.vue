<template class="login">
  <div class="login_box">

    <div class="login">
      <br>
      <h1>
        社团管理系统
      </h1>
      <div>
        <el-input placeholder="请输入用户名" v-model="name" clearable class="input_style"></el-input>
        <span v-if="error.name" class="err-msg">{{error.name}}</span>
      </div>
      <div>
        <el-input placeholder="请输入密码" v-model="pwd" show-password class="input_style"></el-input>
        <span v-if="error.pwd" class="err-msg">{{error.pwd}}</span>
      </div>
      <div>
        <el-button type="primary" @click="login" class="login_style">登录</el-button>
      </div>
      <div>
        <el-button style="margin-top: 10px" type="primary" @click="regist" class="login_style">注册</el-button>
      </div>
      <div style="margin-top: 10px">
        <a href="./index">游客</a>
      </div>

    </div>
  </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                name: '',
                pwd: '',
                error: {
                    name: '',
                    pwd: ''
                }
            }
        },
        methods: {
            login() {
                // eslint-disable-next-line no-unused-vars
                this.$router.push('/index')
            }
        }
    }
</script>

<style>
  /*html {*/
  /*  background-image: url("../../assets/img/loginbackgroup.jpg");*/
  /*  background-size: cover;*/
  /*}*/

  .login_box {
    margin: auto;
    width: 350px;
    height: 400px;
    background-color: white;
    position: center;
    margin-top: 100px;
  }

  .login {
    width: 200px;
    margin: auto;
  }

  .input_style {
    width: 200px;
    margin-bottom: 10px;
  }

  .login_style {
    width: 200px;
  }
</style>
