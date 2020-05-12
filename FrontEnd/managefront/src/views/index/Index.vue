<template>
  <el-carousel :interval="2000" type="card" height="550px">
    <el-carousel-item class="carousel-item" v-for="url in urls"  v-bind:key="url">
      <el-image
        class="carousel-img"
        :src=url
      ></el-image>
    </el-carousel-item>
  </el-carousel>
</template>



<script>
    export default {
        name: "Index",
        data() {
            return {
                urls: [],
            }
        },
        created() {
            let _this = this;
            this.$axios.post('/findAllIndexImgs')
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            title: '提示',
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.urls = response.data.data.IndexImgsUrls;


                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        }
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
