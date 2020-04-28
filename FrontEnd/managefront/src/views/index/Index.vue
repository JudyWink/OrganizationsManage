<template>
  <el-carousel :interval="2000" type="card" height="550px">
    <el-carousel-item class="carousel-item" v-for="url in urls"  v-bind:key="url"  >
      <img class="carousel-img" :src="url">
    </el-carousel-item>
  </el-carousel>
</template>



<script>
    export default {
        name: "Index",
        data() {
            return {
                urls: [
                    require('../../assets/img/index/1.jpg'),
                    require('../../assets/img/index/2.jpg'),
                    require('../../assets/img/index/3.jpg'),
                    require('../../assets/img/index/4.jpg'),
                    require('../../assets/img/index/5.jpg'),
                    // require('../../assets/img/index/6.jpg'),
                    require('../../assets/img/index/7.jpg'),
                    require('../../assets/img/index/8.jpg'),
                ]
            }
        },
    }
</script>

<style>

  .carousel-item {
    margin-top: 20px;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
  }

  .carousel-img {
    max-width: 740px;
    max-height: 420px;
  }
</style>
