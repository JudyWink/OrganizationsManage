<template>
  <div id="app">
    <TopMenu v-if="$route.meta.keepalive"></TopMenu>
    <router-view/>

  </div>
</template>


<script>
    import TopMenu from "./components/content/menu/Menu"

    export default {
        components: {
            'TopMenu': TopMenu,
        }
    }
</script>

<style>
  @import "assets/css/base.css";

  #app {
    text-align: center;
  }
</style>
