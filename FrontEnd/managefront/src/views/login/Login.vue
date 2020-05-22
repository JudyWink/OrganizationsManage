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
        <el-input @keyup.enter.native="login()" placeholder="请输入密码" v-model="userPassword" show-password class="input_style"></el-input>
      </div>
      <div style="width: 95%; margin-top: 10px;margin-bottom: 40px">
        <input type="checkbox" v-model="rememberINPUT" id="rememberMe">
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
        <el-link @click="noPower">游客进入</el-link>
      </div>

    </div>
  </div>
</template>

<script>
    import {mapMutations} from 'vuex';

    export default {
        name: "Login",
        data() {
            return {
                rememberINPUT: '',
                userAcount: '',
                userPassword: '',
                userID:'',
                orgID:'',
                useremail:'',
                error: {
                    userAcount: '',
                    userPassword: ''
                },
                token : '',
            }
        },
        methods: {
            ...mapMutations(['changeLogin']),
            async login() {
                let _this = this;
                let data = {
                    data: {
                        "userAcount": this.userAcount,
                        "userPassword": this.userPassword,
                    }
                }
                if (this.userAcount.length == 0) {
                    await this.$message.error('账号不能为空');
                }
                if (this.userPassword.length == 0) {
                    await this.$message.error('密码不能为空');
                } else {
                    this.$axios.post('/Login', JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                _this.$notify.error({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                            }
                            if (response.data.code == 0) {
                                _this.token = response.data.data.token;
                                _this.userName = response.data.data.userName;
                                _this.userType = response.data.data.userType;
                                _this.userID = response.data.data.userID;
                                _this.orgID = response.data.data.orgID;
                                _this.userEmail = response.data.data.userEmail;
                                if (_this.rememberINPUT == true){
                                    _this.$store.commit("REMEMBER_ACCOUNT",_this.userAcount);
                                    _this.$store.commit("REMEMBER_PASSWORD",_this.userPassword);
                                }else if (_this.rememberINPUT == false){
                                    _this.$store.commit("NO_REMEMBER");
                                }
                                    //保存token
                                    _this.$store.commit("SET_TOKEN", _this.token);
                                    //保存用户名字
                                    _this.$store.commit("SET_NAME", _this.userName);
                                    //保存用户类型
                                    _this.$store.commit("SET_TYPE", _this.userType);
                                    //保存用户ID
                                    _this.$store.commit("SET_USERID", _this.userID);
                                    //保存用户社团
                                    _this.$store.commit("SET_ORGID", _this.orgID);
                                    //保存用户邮箱
                                    _this.$store.commit("SET_EMAIL", _this.userEmail);


                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 3000,
                                });
                                _this.$router.push('/index');
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }
            },
            regist() {
                this.$router.push('/regist')
            },
            noPower(){
                this.$store.commit("SET_TOKEN", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiLmuLjlrqIifQ.oA44T_HJGQBdVkaN-NFaykRM7rureZT2bsr93QlEpTk");
                this.$store.commit( "SET_NAME", "游客");
                this.$store.commit( "SET_TYPE","游客");
                this.$store.commit( "SET_USERID","1");
                this.$router.push('/index')
            }
        },
        created() {
            //如果登录了，直接进入首页
            let token = this.$store.state.token ? this.$store.state.token : window.sessionStorage.getItem('token');
            let name = this.$store.state.userName ? this.$store.state.userName : window.sessionStorage.getItem('userName');
            let userAccount = window.localStorage.getItem('account')
            let userPassword = window.localStorage.getItem('password')
            if(userAccount != null) {
                this.userAcount = userAccount;
                this.userPassword = userPassword;
            }
            if (token != null) {
                this.$notify.success({
                    message: name+",欢迎回来",
                    showClose: false,
                    duration: 3000,
                });
                this.$router.push('/index')
            }
        }
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

  #rememberMe {
    float: left;

  }

  .rember-me {
    float: left;
    font-size: 12px;

  }

  .forget-key {
    float: right;
    font-size: 12px;
  }

  .forget-key a {
    text-decoration: none;
    color: #349cf2;
  }

  .forget-key a:hover {
    cursor: pointer;
    color: #0b7edc;
  }
</style>
