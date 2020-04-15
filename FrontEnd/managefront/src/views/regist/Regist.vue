<template>
  <div id="regist_box">
    <div>
      <div id="regist">
        <h1>
          社团管理系统用户注册
        </h1>
        <label>登陆账户</label>
        <el-input clearable type="text" v-model="userAcount" placeholder="请输入账号" @blur="checkAcount"></el-input>
        <span class="tiShi">{{errormsg.acount}}</span><br>
        <label>密码</label>
        <el-input type="password" v-model="userPassword1" placeholder="请输入密码" @blur="checkPassword1"></el-input>
        <span class="tiShi">{{errormsg.password1}}</span><br>
        <label>确认密码</label>
        <el-input type="password" v-model="userPassword2" placeholder="请再次输入密码" @blur="checkPassword2"></el-input>
        <span class="tiShi">{{errormsg.password2}}</span><br>
        <!--      <label>真实姓名</label><el-input type="text" v-model="name" placeholder="请次输入真实姓名"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <!--      <label>学号</label><el-input type="text" v-model="number" placeholder="请输入学号"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <!--      <label>手机号</label><el-input type="text" v-model="phone" placeholder="请输入手机号码"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <el-button type="primary" id="btd" @click="regist">立即注册</el-button>
        <el-button type="primary" @click="login">已有账户，马上登陆</el-button>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Regist",
        data() {
            return {
                successful: {
                    acount: false,
                    password1: false,
                    password2: false,
                },
                errormsg: {
                    acount: '',
                    password1: '',
                    password2: '',
                },
                userAcount: '',
                userPassword1: '',
                userPassword2: '',
            }
        },
        methods: {
            //账号判断
            checkAcount() {
                this.errormsg.acount = '';
                var regEn = /[`~!@#$%^&*()_+<>?:"{},.\\/;'[\]]/im,
                    regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
                if (this.userAcount.length == 0) {
                    this.errormsg.acount = '用户名不能为空';
                } else if (regEn.test(this.userAcount) || regCn.test(this.userAcount)) {
                    this.errormsg.acount = "账户不能包含特殊字符";
                } else {
                    this.successful.acount = true;
                }
            },
            //密码判断
            checkPassword1() {
                this.errormsg.password1 = '';
                if (this.userPassword1.length > 16 || this.userPassword1.length < 0) {
                    this.errormsg.password1 = '密码长度要在6~16位';
                } else {
                    this.successful.password1 = true;
                }
            },
            checkPassword2() {
                this.errormsg.password2 = '';
                if (this.userPassword1 !== this.userPassword2) {
                    this.errormsg.password2 = '两次输入密码不对';
                } else {
                    this.successful.password2 = true;
                }
            },
            //注册按钮
            regist() {
                var nowTime = new Date();

                let data = {
                    timestamp: nowTime,
                    userId: "abcde",
                    token: "dsadasasdasdasdasdasdasdsadasdasdasdas",
                    userType: "123456",
                    jsonDate: {
                        "userAcount": this.userAcount,
                        "userPassword": this.userPassword2,
                        "createTime": nowTime
                    }

                }

                if (this.successful.acount && this.successful.password1 && this.successful.password2) {
                    this.$axios.post('/addUser', JSON.stringify(data))
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    // this.$router.push('/login');
                } else {
                    this.$message.error('请填写正确信息');
                }
            },
            //登录按钮
            login() {
                this.$router.push('/login')
            },
        }
    }
</script>


<style type="text/css">
  * {
    margin: 0px;
    padding: 0px;
  }

  a {
    color: black;
    text-decoration: none;
  }

  body {
    font-family: "宋体";
    background: no-repeat;
    background-size: 100%;
    color: black;
  }

  #regist {
    width: 350px;
    margin: 100px auto;
  }

  label {
    display: inline-block;
    width: 70px;
    height: 25px;
    text-align: center;
  }

  .tiShi {
    font-size: 10px;
    color: red;
    margin: 0 10px 0;
    text-align: center;
  }

  #successful {
    width: 300px;
    height: 200px;
    border: 1px solid silver;
    position: fixed;
    left: 50%;
    bottom: 50%;
    display: none
  }

  #btd {
    width: 350px;
    margin-bottom: 50px;
    margin-top: 20px;
  }

  .btd_login {
    width: 350px;
  }
</style>

