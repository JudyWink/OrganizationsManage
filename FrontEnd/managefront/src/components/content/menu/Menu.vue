<template>
  <el-menu :v-if="$route.meta.keepalive" default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64" text-color="#fff" active-text-color="red">
    <keep-alive>
      <router-link to="/index" tag="el-menu-item" replace>首页</router-link>
    </keep-alive>
    <keep-alive>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
    </keep-alive>
    <keep-alive>
      <el-menu-item index="3">消息中心</el-menu-item>
    </keep-alive>
    <keep-alive>
      <el-menu-item index="4"><a target="_blank">订单管理</a></el-menu-item>
      <!--      <el-menu-item index="5">登录</el-menu-item>-->
    </keep-alive>
  </el-menu>
</template>

<script>
    export default {
        data() {
            return {
                activeIndex: '1',
                activeIndex2: '1'
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>
