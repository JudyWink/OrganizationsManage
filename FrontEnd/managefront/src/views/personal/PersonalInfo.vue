<template>
  <div id="personalInfo_box">
    <div id="personalInfo">
      <table class="table">
        <span>基本信息</span>
        <tr>
          <td style="border-bottom: solid 1px #d1d1d1;" colspan="5"></td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">姓名</el-tag>
          </td>
          <td>
            <el-input :disabled="isNotmodify" v-model="user.username"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">账户</el-tag>
          <td>
            <el-input :disabled="true" v-model="user.useracount"></el-input>
          </td>

        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">社团</el-tag>
          <td colspan="2">
          <el-input  :disabled="true" v-model="user.orgname"></el-input>
          </td>
          <td>
            <el-input :disabled="true" v-model="position"></el-input>
          </td>
        </tr>
        <tr>
          <td>
          <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">班级</el-tag>
          <td colspan="2">
            <el-input :disabled="isNotmodify" v-model="user.userclass"></el-input>
          </td>
          <td v-if="canModify == true">
            <el-button type="warning" icon="el-icon-edit" @click="dialogFormVisible = true" plain>修改密码</el-button>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学院</el-tag>
          <td colspan="2">
            <el-input :disabled="isNotmodify" v-model="user.useracademy"></el-input>
          </td>

        </tr>
        <tr>

          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学号</el-tag>
          <td>
            <el-input maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" :disabled="isNotmodify" v-model="user.usernumber"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">用户类型</el-tag>
          <td>
            <el-input :disabled="true" v-model="user.usertype"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">微信</el-tag>
          <td>
            <el-input :disabled="isNotmodify" v-model="user.userwechat"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">Q Q</el-tag>
          <td>
            <el-input onkeyup="value=value.replace(/[^\d]/g,'')" :disabled="isNotmodify" v-model="user.userqq"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">宿舍</el-tag>
          <td>
            <el-input :disabled="isNotmodify" v-model="user.dormitory"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">邮箱</el-tag>
          <td>
            <el-input :disabled="isNotmodify" v-model="user.useremail"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">手机</el-tag>
          <td>
            <el-input maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'')" :disabled="isNotmodify" v-model="user.userphone"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">性别</el-tag>
          <td>
            <el-input :maxlength="1" :disabled="isNotmodify" v-model="user.usersex"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">爱好</el-tag>
          <td colspan="3">
            <el-input :disabled="isNotmodify" type="textarea" v-model="user.userhobby"></el-input>
          </td>
        </tr>
        <tr v-if="canModify === true">
          <td colspan="4">
            <el-button type="primary" @click="modify">{{modifytext}}</el-button>
            <el-button type="success" @click="save">保存</el-button>
          </td>
        </tr>
      </table>

      <el-dialog :close-on-click-modal="false" @close="close" width="400px" title="密码修改" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item>
            <el-input placeholder="请输入原密码" clearable v-model="form.pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input placeholder="请输入新密码" clearable v-model="form.password1" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input placeholder="请再次输入新密码" clearable v-model="form.password2" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="modifyPassword()">确 定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>


    </div>
  </div>
</template>

<script>
    export default {
        name: "PersonalInfo",
        data() {
            return {
                canModify : true,
                wrongTip:"",
                position:"",
                user:"",
                isNotmodify:true,
                modifytext:"修改",
                dialogFormVisible : false,
                form: {
                    pass:"",
                    password1:"",
                    password2:"",
                },
            }
        },
        methods: {
            close(){
                this.form.pass = "";
                this.form.password1 = "";
                this.form.password2 = "";
            },
            async modifyPassword(){
                let _this = this;
                let data={
                    data:{
                        pass : this.form.pass,
                        password : this.form.password2,
                        userID : window.sessionStorage.getItem('userID'),
                    }
                }
                if (this.form.password1.length > 16 || this.form.password1.length < 0) {
                    this.$notify.error({
                        message: "密码长度要在6~16位",
                        showClose: false,
                        duration: 1500,
                    });
                }else if(this.form.password1 !== this.form.password2){
                    this.$notify.error({
                        message: "两次输入密码不对",
                        showClose: false,
                        duration: 1500,
                    });
                }else {
                    this.$axios.post("/modifyPassword", JSON.stringify(data))
                        .then(async function (response) {
                            if (response.data.code == 1) {
                                _this.$notify.error({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                                console.log(response.data.msg)
                            }
                            if (response.data.code == 0) {
                                _this.dialogFormVisible = false
                                await _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 3000,
                                });
                                await _this.$notify.warning({
                                    message: "修改密码后请重新登录",
                                    showClose: false,
                                    duration: 3000,
                                });
                                _this.$store.commit("LOGOUT");
                                await _this.$router.push('/login')
                                console.log(response.data.msg)
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }
            },

            modify(){
                if(this.modifytext === "修改"){
                    this.isNotmodify = false;
                    this.modifytext = "取消"
                }else {
                    this.isNotmodify = true;
                    this.modifytext = "修改"
                    const _this = this;
                    const userID = window.sessionStorage.getItem('userID');
                    let data={
                        data:{
                            userID:userID
                        }
                    }
                    this.$axios.post("/findUserInfo", JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                console.log(response.data.msg)
                            }
                            if (response.data.code == 0) {
                                _this.user = response.data.data.user;
                                console.log(response.data.msg)
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }

            },

            save() {
                if( this.modifytext != "修改") {
                    const _this = this;
                    let data = {
                        data: {
                            users: this.user
                        }
                    };
                    this.$axios.post("/updateUser", JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                console.log(response.data.msg)
                            }
                            if (response.data.code == 0) {
                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 3000,
                                });
                                console.log(response.data.msg)
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }else {
                    this.$notify.warning({
                        message: "你还没修改信息",
                        showClose: false,
                        duration: 3000,
                    });
                }
                this.isNotmodify = true;
                this.modifytext = "修改";
            }

        },
        created() {
            const _this = this;
            let userID = window.sessionStorage.getItem('userID');
            if(this.$route.params.userID != null){
                userID = this.$route.params.userID;
                this.canModify = this.$route.params.canModify;
            }
            let data={
                data:{
                    "userID":userID
                }
            }
            this.$axios.post("/findUserInfo", JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        console.log(response.data.msg)
                    }
                    if (response.data.code == 0) {
                        _this.user = response.data.data.user;
                        console.log(response.data.msg)
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        },
        beforeDestroy() {
            this.canModify = true;
        }

    }
</script>


<style type="text/css">

  .table {
    border-spacing: 10px 15px;
    border: solid 1px #d1d1d1;
    margin: auto;
    background-color: white;
  }

  #personalInfo {
    width: 80%;
    margin: 10px auto;
  }

  #personalInfo_box {
    height: 400px;
    width: 90%;
    margin: auto;
  }

</style>
