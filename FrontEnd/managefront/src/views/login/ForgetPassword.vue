<template>
  <div class="ForgetPassword_box">
    <div class="ForgetPassword">
      <a href="/">
        <img style="width: 75px;height: 75px" src="../../assets/img/logo.png">
      </a>
      <h3>
        密码找回
      </h3>
      <br>
      <div>
        <el-input placeholder="请输入用户名" v-model="userAcount" clearable class="input_style"></el-input>
      </div>
      <div>
        <el-input placeholder="请输入新密码" v-model="userNewPassword1" show-password class="input_style"></el-input>
      </div>
      <div>
        <el-input placeholder="请再次输入新密码" v-model="userNewPassword2" show-password class="input_style"></el-input>
      </div>
      <div>
        <el-input placeholder="请输入邮箱" v-model="email" class="input_style"></el-input>
      </div>
      <div>
        <tr>
          <td>
            <el-button class="btn-bottom" :disabled="disabled" :type="changetype" :style="changestyle" @click="getlogin">{{btnText}}</el-button>
          </td>
          <pre>  </pre>
          <td>
            <el-input placeholder="验证码" v-model="codenum" class="input_style"></el-input>
          </td>
        </tr>
      </div>
      <div>
        <el-button type="success" @click="login" class="login_style">确定</el-button>
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
                userNewPassword1: '',
                userNewPassword2: '',
                email: '',
                codenum: '',
                VerificationCode:"",
                disabled: false,
                interval:undefined,
                totalCount:0,
                changetype:'',
                changestyle:'',
            }
        },
        computed: {
            btnText(){
                return this.totalCount !==0? `${this.totalCount}s`: "获取验证码"
            }
        },
        methods: {
            async login() {
                if (this.userAcount.length == 0) {
                    await this.$message.error('账号不能为空');
                }
                if (this.userNewPassword1.length == 0 || this.userNewPassword1.length == 0) {
                    await this.$message.error('密码不能为空');
                }
                if (this.userNewPassword1 != this.userNewPassword2) {
                    await this.$message.error('两次输入密码不正确');
                }
                if (this.codenum.length == 0) {
                    await this.$message.error('请输入验证码');
                } else {
                    if(this.VerificationCode != this.codenum){
                        this.$message.error('验证码不正确');
                        return false;
                    }
                    let _this = this;
                    let data = {
                        data: {
                            "password": this.userNewPassword2,
                            "userAcount" : this.userAcount,
                        }
                    }
                    this.$axios.post('/forgetPassword', JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                _this.$notify.warning({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                            }
                            if (response.data.code == 0) {
                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                })
                            }
                        }).catch(function (error) {
                            console.log(error)
                        });
                    this.$router.push('/login')
                }
            },
            getlogin(){
                let _this = this;
                let data = {
                    data: {
                        "userAcount": this.userAcount,
                        "email" : this.email,
                    }
                }
                this.$axios.post("/sendEmail",JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 1) {
                            _this.$notify.warning({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                        if (response.data.code == 0) {
                            _this.$notify.success({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                            _this.disabled=true
                            _this.totalCount=60
                            _this.changetype = "warning"
                            _this.changestyle = "color: black"
                            _this.interval=setInterval(()=>{
                                _this.totalCount--
                                if(_this.totalCount === 0){
                                    clearInterval(_this.interval)
                                    _this.disabled=false
                                }
                            },1000);
                            _this.VerificationCode = response.data.data.code
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            }

        },
    }
</script>

<style>

  .ForgetPassword_box {
    margin: auto;
    width: 350px;
    height: 430px;
    position: center;
    margin-top: 50px;
    background-color: white;
  }

  .ForgetPassword {
    width: 300px;
    margin: auto;
  }

  .input_style {
    margin-bottom: 10px;
  }

  .login_style {
    width: 300px;
  }
</style>
