<template>
  <div id="regist_box">
    <div>
      <div id="regist">
        <img style="width: 75px;height: 75px" src="../../assets/img/logo.png">
        <h3>
          社团管理系统注册
        </h3>
        <br>
<!--        <label>登陆账户</label>-->
        <el-input clearable type="text" v-model="userAcount" placeholder="请输入账号" @blur="checkAcount"></el-input>
        <span ref="Acounttishi" class="tiShi">{{errormsg.acount}}</span><br>
<!--        <label>密码</label>-->
        <el-input type="password" v-model="userPassword1" placeholder="请输入密码" @blur="checkPassword1"></el-input>
        <span class="tiShi">{{errormsg.password1}}</span><br>
<!--        <label>确认密码</label>-->
        <el-input type="password" v-model="userPassword2" placeholder="请再次输入密码" @blur="checkPassword2"></el-input>
        <span class="tiShi">{{errormsg.password2}}</span><br>
        <!--      <label>真实姓名</label><el-input type="text" v-model="name" placeholder="请次输入真实姓名"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <!--      <label>学号</label><el-input type="text" v-model="number" placeholder="请输入学号"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <!--      <label>手机号</label><el-input type="text" v-model="phone" placeholder="请输入手机号码"></el-input>-->
        <!--      <span class="tiShi"></span><br>-->
        <el-button type="success" id="btd" @click="regist">立即注册</el-button>
        <el-button type="primary"  @click="login">已有账户，马上登陆</el-button>
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
                var _this = this;
                this.errormsg.acount = '';
                let data = {
                    data: {
                        "userAcount": this.userAcount,
                    }
                }
                var regEn = /[`~!@#$%^&*()_+<>?:"{},.\\/;'[\]]/im,
                    regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
                if (this.userAcount.length == 0) {
                    this.errormsg.acount = '用户名不能为空';
                } else if (regEn.test(this.userAcount) || regCn.test(this.userAcount)) {
                    this.errormsg.acount = "账户不能包含特殊字符";
                }
                if(this.userAcount.length >20){
                    this.errormsg.acount = '用户名过长';
                }
                if(this.userAcount.length != 0) {
                    this.$axios.post('/findOneUser', JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                _this.$refs.Acounttishi.style.color = "#FF0000";
                                _this.successful.acount = false;
                            }
                            if (response.data.code == 0) {
                                _this.$refs.Acounttishi.style.color = "#008000";
                                _this.successful.acount = true;
                            }
                            _this.errormsg.acount = response.data.msg;
                            console.log(response.data.msg);
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
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
                var _this = this;
                var nowTime = new Date();
                let data = {
                    data: {
                        "timestamp": nowTime,
                        "userAcount": this.userAcount,
                        "userPassword": this.userPassword2,
                    }
                }
                if (this.successful.acount && this.successful.password1 && this.successful.password2) {
                    this.$axios.post('/regist', JSON.stringify(data))
                        .then(function (response) {
                            if(response.data.code == 1){
                                _this.$notify.warning({
                                    title: '提示',
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                            }
                            if(response.data.code == 0){
                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 3000,
                                });
                                _this.$router.push('/login');
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });

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
    width: 300px;
    margin: auto;
  }

  #regist_box{
    margin: auto;
    width: 350px;
    height: 450px;
    position: center;
    margin-top: 30px;
    background-color: white;
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

  #btd {
    width: 80%;
    margin-bottom: 20px;
    margin-top: 20px;
  }
</style>

