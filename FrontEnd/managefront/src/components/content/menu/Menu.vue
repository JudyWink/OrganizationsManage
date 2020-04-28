<template>
  <div id="menu">
    <el-menu :default-active="this.$route.path" router class="el-menu-demo"
             mode="horizontal" background-color="#4ACA6D" text-color="#fff"
             active-text-color="#fff">
      <el-menu-item index="/index">首页</el-menu-item>
      <el-submenu index="">
        <template slot="title">权限管理</template>
        <el-menu-item index="/signupMembers">无组织学生</el-menu-item>
        <el-menu-item index="/members">社团学生</el-menu-item>
      </el-submenu>
      <el-submenu>
        <template slot="title">活动管理</template>
        <el-menu-item index="/publishActivities">发布活动</el-menu-item>
        <el-menu-item index="/myActivities">参加的活动</el-menu-item>
      </el-submenu>
      <el-menu-item index="/message"><el-badge :is-dot=isDot class="item">
        消息中心
      </el-badge></el-menu-item>
      <el-menu-item index="/indexManager">首页管理</el-menu-item>
      <el-menu-item index="/document">文件管理</el-menu-item>
      <el-menu-item index="/calendar">社团日历</el-menu-item>
      <el-menu-item style="float: right;" @click="signout"><i class="el-icon-switch-button"></i></el-menu-item>
      <el-menu-item style="float: right;" index="/personalInfo">你好，{{userName}}</el-menu-item>
    </el-menu>

  </div>
</template>

<script>
    export default {
        name: "Menu",
        data() {
            return {
                userName: '系统管理员',
                count: 3,
            }
        },
        methods: {
            //退出登录
            signout(){
                this.$router.push('/login')
            }
        },
        created() {
            //消息中心小红点
            if(this.count!= 0){
                this.isDot = true;
            }
        }

    }
</script>
<style>
  .item {
    margin-bottom: 5px;
  }

</style>
