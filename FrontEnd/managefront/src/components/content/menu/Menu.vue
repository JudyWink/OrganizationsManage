<template>
  <div id="menu">
    <el-menu :default-active="this.$route.path" router class="el-menu-demo"
             mode="horizontal" background-color="#4ACA6D" text-color="#fff"
             active-text-color="#fff">
      <el-menu-item index="/index">首页</el-menu-item>
      <el-submenu index="1" v-if="userType === '社团负责人'">
        <template slot="title">成员管理</template>
        <el-menu-item index="/members">社团成员</el-menu-item>
        <el-menu-item index="/signupMembers">报名学生</el-menu-item>
      </el-submenu>
      <el-submenu index="2" v-if="userType === '社团负责人'">
        <template slot="title">活动管理</template>
        <el-menu-item index="/PublishActivities">发布活动</el-menu-item>
        <el-menu-item index="/myPushActs">已发布活动</el-menu-item>
      </el-submenu>
      <el-submenu index="3" v-if="userType === '学生'">
        <template slot="title">社团信息</template>
        <el-menu-item index="/allOrganizations">所有社团</el-menu-item>
        <el-menu-item index="/myOrganization">我的社团</el-menu-item>
      </el-submenu>
      <el-menu-item v-if="userType === '游客'" index="/allOrganizations">所有社团</el-menu-item>
      <el-submenu index="4" v-if="userType === '学生'">
        <template slot="title">活动中心</template>
        <el-menu-item index="/allActivities">所有活动</el-menu-item>
        <el-menu-item index="/myActivities">参加的活动</el-menu-item>
      </el-submenu>
      <el-menu-item  v-if="userType === '游客'" index="/allActivities">所有活动</el-menu-item>
      <el-submenu  index="5" v-if="userType === '系统管理员'">
        <template slot="title">权限管理</template>
        <el-menu-item index="/userPower">无组织学生</el-menu-item>
        <el-menu-item index="/havaOrgUsers">社团学生</el-menu-item>
      </el-submenu>
      <el-submenu index="6" v-if="userType === '系统管理员'">
        <template slot="title">活动管理</template>
        <el-menu-item index="/publishActivities">发布活动</el-menu-item>
        <el-menu-item index="/allActivities">所有活动</el-menu-item>
      </el-submenu>


      <el-submenu  v-if="userType != '游客'" index="7">
        <template slot="title"><el-badge :is-dot=isDot class="item">消息中心 </el-badge></template>
        <el-menu-item index="/message">
          收信箱
        </el-menu-item>
        <el-menu-item index="/messageSended">
          发信箱</el-menu-item>

      </el-submenu>



      <el-submenu index="8" v-if="userType === '社团负责人'">
        <template slot="title">社团信息</template>
        <el-menu-item index="/OrganizationSetting">社团主页图片</el-menu-item>
        <el-menu-item index="/organizationInfo">社团信息</el-menu-item>
      </el-submenu>

      <el-menu-item v-if="userType === '学生'" index="/personalInfo">个人信息</el-menu-item>
      <el-menu-item v-if="userType === '学生'|| userType === '游客'" index="/Document">文件下载</el-menu-item>
      <el-menu-item  v-if="userType === '系统管理员'" index="/indexManager">首页管理</el-menu-item>
      <el-menu-item v-if="userType === '系统管理员' || userType === '社团负责人'" index="/uploadDocument">文件管理</el-menu-item>


      <el-menu-item index="/calendar">社团日历</el-menu-item>
      <el-menu-item style="float: right;" @click="signout"><i class="el-icon-switch-button"></i></el-menu-item>
      <el-menu-item style="float: right;" index="/personalInfo">你好，【{{userType}}】{{userName}}</el-menu-item>
    </el-menu>

  </div>
</template>

<script>
    export default {
        name: "Menu",
        data() {
            return {
                userName: window.sessionStorage.getItem('userName'),
                userType: window.sessionStorage.getItem('userType'),
                isDot : false,
            }
        },
        methods: {
            //退出登录
            signout(){
                this.$router.push('/login');
                this.$store.commit("LOGOUT");
                this.$notify.success({
                    message: "退出成功",
                    showClose: false,
                    duration: 3000,
                });
            }
        },
        created() {
            //消息中心小红点
            if (sessionStorage.getItem('userType') != "游客") {
                const _this = this;
                let data = {
                    data: {
                        "userID": sessionStorage.getItem("userID"),
                    }
                }

                this.$axios.post('/MessagesIsDot', JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 1) {
                            _this.$notify.warning({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                        if (response.data.code == 0) {
                            console.log(response.data.msg);
                            _this.isDot = response.data.data.isDot;
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            }
        }
    }
</script>
<style>
  .item {
    margin-bottom: 5px;
  }

</style>
