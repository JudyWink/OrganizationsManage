<template>
  <div class="login_box">
    <div class="login">
      <img style="width: 75px;height: 75px" src="../../assets/img/logo.png">
      <h3>
        社团管理系统
      </h3>
      <br>
      <div>
        <el-input placeholder="请输入用户名" v-model="userAcount" clearable class="input_style"></el-input>
      </div>
      <div>
        <el-input placeholder="请输入密码" v-model="userPassword" show-password class="input_style"></el-input>
      </div>
      <div style="width: 95%; margin-top: 10px;margin-bottom: 40px">
        <input type="checkbox" id="rememberMe">
        <span class="rember-me">记住密码</span>
        <span class="forget-key"><a href="/forgetPassword">忘记密码</a></span>
      </div>
      <div>
        <el-button type="success" @click="login" class="login_style">登录</el-button>
      </div>
      <div>
        <el-button style="margin-top: 10px" type="primary" @click="regist" class="login_style">注册</el-button>
      </div>

      <div style="margin-top: 10px">
        <a href="./index">游客进入</a>
      </div>

    </div>
  </div>
</template>

<script>

    export default {
        name: "Login",
        data() {
            return {
                userAcount: '',
                userPassword: '',
                error: {
                    userAcount: '',
                    userPassword: ''
                }
            }
        },
        methods: {
            async login() {

                // let _this = this;
                // let userData = {
                //     userAcount: this.userAcount,
                //     userPassword: this.userPassword,
                // }
                if (this.userAcount.length == 0) {
                    await this.$message.error('账号不能为空');
                }
                if (this.userPassword.length == 0) {
                    await this.$message.error('密码不能为空');
                } else {
                    // this.$axios.post('/login', JSON.stringify(userData))
                    //     .then(function (response) {
                    //         console.log(response)
                    //     })
                    //     .catch(function (error) {
                    //         console.log(error)
                    //     });
                    this.$router.push('/index')
                }
            },
            regist() {
                this.$router.push('/regist')
            }
        },
        // created() {
        //     //如果登录了，直接进入首页
        // }
    }
</script>

<style>

  .login_box {
    margin: auto;
    width: 350px;
    height: 390px;
    position: center;
    background-color: white;
  }

  .login {
    width: 300px;
    margin: auto;
  }

  .input_style {
    margin-bottom: 10px;
  }

  .login_style {
    width: 300px;
  }

  #rememberMe{
    float: left;

  }
  .rember-me{
    float: left;
    font-size: 12px;

  }
  .forget-key{
    float: right;
    font-size: 12px;
  }
  .forget-key a{
    text-decoration: none;
    color: #349cf2;
  }
  .forget-key a:hover{
    cursor: pointer;
    color: #0b7edc;
  }
</style>
