<template>
  <div id="personalInfo_box">

    <div id="personalInfo">
      <table class="table">
        <collapse>基本信息</collapse>
        <tr>
          <td style="border-bottom: solid 1px #d1d1d1;" colspan="5"></td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">姓名</el-tag>
          </td>
          <td>
            <el-input/>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px"  type="success">账户</el-tag>
          <td>
            <el-input/>
          </td>

        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">所属社团</el-tag>
          <td>
            <el-select style="width: 100%" v-model="value" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">职位</el-tag>
          <td>
            <el-input disabled="true"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">默认登录组织</el-tag>
          <td>
            <el-select style="width: 100%" v-model="value" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">类型</el-tag>
          <td>
            <el-input disabled="true"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学院</el-tag>
          <td colspan="2">
            <el-select style="width: 100%" v-model="value" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </td>
          <td><el-button type="warning" icon="el-icon-edit" onclick="" plain>修改密码</el-button></td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">班级</el-tag>
          <td>
            <el-input/>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学号</el-tag>
          <td>
            <el-input/>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">微信</el-tag>
          <td>
            <el-input/>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">Q Q</el-tag>
          <td>
            <el-input/>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">宿舍</el-tag>
          <td>
            <el-input/>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">邮箱</el-tag>
          <td>
            <el-input/>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">手机</el-tag>
          <td>
            <el-input/>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">性别</el-tag>
          <td>
            <el-input/>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">爱好</el-tag>
          <td colspan="3">
            <el-input type="textarea"></el-input>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <el-avatar shape="square" :size="100" :fit="fit" :src="url"></el-avatar>
            <el-upload
              class="avatar-uploader"
              action="https://jsonplaceholder.typicode.com/posts/"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <el-button type="success">保存</el-button>
            <el-button type="warning">取消</el-button>
          </td>
        </tr>
      </table>
    </div>

  </div>
</template>

<script>
    export default {
        name: "PersonalInfo",
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
