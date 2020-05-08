<template>
  <div class="login_box">
    <div class="login">
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
            <el-input placeholder="验证码" v-model="code" class="input_style"></el-input>
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
                code: '',
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
                if (this.code.length == 0) {
                    await this.$message.error('请输入验证码');
                } else {
                    // this.$axios.post('/login', JSON.stringify(userData))
                    //     .then(function (response) {
                    //         console.log(response)
                    //     })
                    //     .catch(function (error) {
                    //         console.log(error)
                    //     });
                    // this.$router.push('/login')
                }
            },
            getlogin(){
                // 按钮60秒倒计时
                this.disabled=true
                this.totalCount=60
                this.changetype = "warning"
                this.changestyle = "color: black"
                this.interval=setInterval(()=>{
                    this.totalCount--
                    if(this.totalCount === 0){
                        clearInterval(this.interval)
                        this.disabled=false
                    }
                },1000);
            }

        },
    }
</script>

<style>

  .login_box {
    margin: auto;
    width: 350px;
    height: 430px;
    position: center;
    margin-top: 50px;
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
</style>
