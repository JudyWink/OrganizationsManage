<template>
  <div id="app">
    <div class="header">
      <div class="hd-cont">
        <img src="https://web.fosu.edu.cn/wp-content/themes/fosu2019/images/pc/fosu-motto.png" class="fosu-motto" alt="佛山科学技术学院校训-明德博学，自强有为">
        <div class="home-link">
          <a href="https://web.fosu.edu.cn" title="佛山科学技术学院"><img src="https://web.fosu.edu.cn/wp-content/themes/fosu2019/images/pc/fosu-logo.png" class="fosu-logo" alt="佛山科学技术学院LOGO"></a>
        </div>
      </div>
    </div>
    <TopMenu v-if="$route.meta.keepalive"></TopMenu>
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>


<script>
    import TopMenu from "./components/content/menu/Menu"

    export default {
        components: {
            'TopMenu': TopMenu,
        },
        provide () {    //父组件中通过provide来提供变量，在子组件中通过inject来注入变量。
            return {
                reload: this.reload
            }
        },
        data() {
            return{
                isRouterAlive: true                    //控制视图是否显示的变量
            }
        },
        methods: {
            reload () {
                this.isRouterAlive = false;            //先关闭，
                this.$nextTick(function () {
                    this.isRouterAlive = true;         //再打开
                })
            }
        }
    }
</script>

<style>
  @import "assets/css/base.css";
  html{
    background: url("assets/img/background1.jpg");
    background-size: cover;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }

  #app {
    text-align: center;
  }

  .hd-cont{
    width:100%;
    height:100px;
    margin:0 auto;
    background: url("./assets/img/bg-gym.png") no-repeat right top;
  }

  .hd-cont .home-link{
    float:left;
    margin-top:20px;
  }
  .hd-cont .fosu-motto{
    float:right;
    margin-top:52px;
  }
</style>
