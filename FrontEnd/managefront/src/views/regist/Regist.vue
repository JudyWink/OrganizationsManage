<template>
  <div id="regist_box">
    <div>

    <div id="successful">
      <h3 style="text-align: center;margin-top: 80px;margin-bottom: 40px;">注册成功，快去登录吧!</h3>
      <el-button type="primary" @click="close">取消</el-button>
      <el-button type="primary" @click="login">登录</el-button>
    </div>

    <div id="regist">
      <h1>
        社团管理系统用户注册
      </h1>
      <label>登陆账户</label><el-input type="text" v-model="name" placeholder="请输入账号"></el-input>
      <span class="tiShi"></span><br>
      <label>密码</label><el-input type="password" v-model="password1" placeholder="请输入密码"></el-input>
      <span class="tiShi"></span><br>
      <label>确认密码</label><el-input type="password" v-model="password2" placeholder="请再次输入密码"></el-input>
      <span class="tiShi"></span><br>
<!--      <label>真实姓名</label><el-input type="text" v-model="name" placeholder="请次输入真实姓名"></el-input>-->
<!--      <span class="tiShi"></span><br>-->
<!--      <label>学号</label><el-input type="text" v-model="number" placeholder="请输入学号"></el-input>-->
<!--      <span class="tiShi"></span><br>-->
<!--      <label>手机号</label><el-input type="text" v-model="phone" placeholder="请输入手机号码"></el-input>-->
<!--      <span class="tiShi"></span><br>-->
      <el-button type="primary" id="btd">立即注册</el-button>
      <div class ="now_login">已经注册，马上登陆<br><el-button type="primary" class="btd_login" @click="login">登录</el-button></div>
    </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Regist",
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
                this.$router.push('/login')
            },
            close(){
                var box=document.getElementById("successful");
                box.style.display="none";
            },
        }
    }
</script>


<style type="text/css">
  *{margin: 0px;padding: 0px;}
  a{color: black;text-decoration: none;}
  body{font-family:  "宋体";background:no-repeat;background-size: 100%;color: black;}
  #regist{width: 350px;margin:100px auto;}
  label{display: inline-block;width:70px;height:25px;text-align: center;}
  .tiShi{font-size: 12px;color:red;margin:0 0 10px 70px;}
  #successful{width: 300px;height: 200px;border: 1px solid silver;position: fixed;left: 50%;bottom: 50%;display: none}
  #btd{width: 300px;margin-bottom: 20px;}
</style>

