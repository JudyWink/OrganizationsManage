<template>
  <div>
  <div>
    <br>
    <span class="top">{{orgName}}</span>
    <br>
    <br>

    <div class="cardBox">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span class="top_h1" style="float: left">社团历史</span>
<!--          <el-button ref v-if="userType === '社团负责人'" style="float: right; padding: 3px 0" type="text" @click="modify()">修改</el-button>-->
        </div>
        <div class="text item">
          {{orgHistory}}
        </div>
      </el-card>
    </div>
    <el-divider></el-divider>

    <div class="cardBox">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span class="top_h1" style="float: left">社团介绍</span>
<!--          <el-button v-if="userType === '社团负责人'" style="float: right; padding: 3px 0" type="text" @click="modify()">修改</el-button>-->
        </div>
        <div class="text item">
          {{orgIntroduce}}
        </div>
      </el-card>
    </div>
  </div>
  <div>
    <el-carousel :interval="2000" type="card" height="350px">
      <el-carousel-item class="carousel-item" v-for="url in urls" v-bind:key="url">
        <img class="carousel-img" :src="url">
      </el-carousel-item>
    </el-carousel>
  </div>
  </div>

</template>

<script>
    export default {
        name: "OrganizationInfo",
        data(){
            return{
                urls:[],
                orgName:"",
                orgHistory:"",
                orgIntroduce:"",
                userType:"",
            }
        },

        methods:{
            modify(){

            }
        },


        created() {
            this.userType = sessionStorage.getItem("userType")
            let _this = this;
            let data = {
                data: {
                    "orgID": sessionStorage.getItem("orgID"),
                }
            };
            if (sessionStorage.getItem("orgIDInfo") != null){
                 data = {
                    data: {
                        "orgID": sessionStorage.getItem("orgIDInfo"),
                    }
                };
            }

            this.$axios.post('/findOneOrg', JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        console.log(response.data.msg)
                        _this.orgHistory = response.data.data.org.orghistory;
                        _this.orgIntroduce = response.data.data.org.orgintroduce;
                        _this.orgName = response.data.data.org.orgname;
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
            this.$axios.post('/findAllOrgImgs', JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
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

        },
    }
</script>

<style>
  .top{
    font-size: 35px;
    color: rgb(74, 202, 109);
    font-family:STHupo;
  }

  .top_h1 {
    font-size: 25px;
    color: orange;
    font-family:STHupo;
  }

  .carousel-item {
    margin-top: 5px;
    width: 80%;
    height: 100%;
    display: flex;
    justify-content: center;
  }

  .carousel-img {
    max-width: 740px;
    max-height: 420px;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    background: url("../../assets/img/cardBackground.png") repeat;
  }

  .cardBox {
    width: 80%;
    margin: auto;
  }

</style>
