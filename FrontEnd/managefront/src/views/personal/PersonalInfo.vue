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
            <el-input name="info_input" v-model="userName"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">账户</el-tag>
          <td>
            <el-input v-model="userAcount"></el-input>
          </td>

        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">默认登录组织</el-tag>
          <td>
            <el-select v-model="value" placeholder="请选择">
              <el-option
                v-for="item in defultOrg"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">职位</el-tag>
          <td>
            <el-input disabled="true" v-model="position"></el-input>
          </td>
        </tr>
        <tr>
          <td>
          <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">班级</el-tag>
          <td colspan="2">
            <el-input v-model="userClass"></el-input>
          </td>
          <td>
            <el-button type="warning" icon="el-icon-edit" onclick="" plain>修改密码</el-button>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学院</el-tag>
          <td colspan="2">
            <el-input v-model="userAcademy"></el-input>
          </td>

        </tr>
        <tr>

          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">学号</el-tag>
          <td>
            <el-input v-model="userNumber"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">类型</el-tag>
          <td>
            <el-input disabled="true" v-model="userType"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">微信</el-tag>
          <td>
            <el-input v-model="weChat"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">Q Q</el-tag>
          <td>
            <el-input v-model="QQ"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">宿舍</el-tag>
          <td>
            <el-input v-model="dormitory"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">邮箱</el-tag>
          <td>
            <el-input v-model="userEmail"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">手机</el-tag>
          <td>
            <el-input v-model="phone"></el-input>
          </td>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">性别</el-tag>
          <td>
            <el-input v-model="sex"></el-input>
          </td>
        </tr>
        <tr>
          <td>
            <el-tag style="width: 140px ;height: 40px;font-size: 14px" type="success">爱好</el-tag>
          <td colspan="3">
            <el-input type="textarea" v-model="userHobby"></el-input>
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
            <el-button type="success" @click="save">保存</el-button>
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
                userName: '张三',
                userAcount: '123456',
                ownOrgs: ['轮滑社',
                    '吉他社'
                ],
                defultOrg: [
                    '轮滑社',
                    '吉他社'
                ],
                position: '',
                userAcademy: '电子信息工程学院',
                userClass: '16网络工程4班',
                userNumber: '20160390406',
                phone: '13250142334',
                sex: '男',
                userHobby: '打篮球',
                userEmail: '1040984760@qq.com',
                QQ: '1040984760',
                weChat: '1040984760',
                dormitory: 'D8-601',
                userType: '学生'
            }
        },
        methods: {
            save() {
                this.$message.error("保存");
            }

        },

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
