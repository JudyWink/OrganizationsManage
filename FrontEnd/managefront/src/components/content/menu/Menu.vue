<template>
  <div id="menu">
    <el-menu :default-active="this.$route.path" router class="el-menu-demo"
             mode="horizontal" background-color="#545c64" text-color="#fff"
             active-text-color="#ffd04b">
      <el-menu-item index="/index">首页</el-menu-item>
      <el-submenu index="">
        <template slot="title">我的工作台</template>
        <el-menu-item index="">选项1</el-menu-item>
        <el-menu-item index="">选项2</el-menu-item>
        <el-menu-item index="">选项3</el-menu-item>
        <el-submenu index="2">
          <template slot="title">选项4</template>
          <el-menu-item index="2-2">选项1</el-menu-item>
          <el-menu-item index="">选项2</el-menu-item>
          <el-menu-item index="">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="">消息中心</el-menu-item>
      <el-menu-item index="">xxxx</el-menu-item>
      <el-menu-item style="float: right" index="/login">登录</el-menu-item>
    </el-menu>
  </div>
</template>

<script>

</script>
