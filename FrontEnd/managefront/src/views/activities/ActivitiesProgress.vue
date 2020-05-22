<template xmlns:c="http://www.w3.org/1999/html">
  <div id="ActivitiesProgress_box">
    <div id="ActivitiesProgress">
      <div v-if="activitityname == ''">
        <el-tag class="top_tag" effect="dark" type="danger">未查询到数据</el-tag>
      </div>
      <div v-if="activitityname != ''">
        <el-tag class="top_tag" effect="dark" type="danger">{{activitityname}}</el-tag>
        <el-steps :active=active align-center finish-status="success">
          <el-step title="活动准备" :description=this.description.start></el-step>
          <el-step title="活动报名" :description="this.description.signUp"></el-step>
          <el-step title="活动筹备中" :description="this.description.doing"></el-step>
          <el-step title="活动进行" :description="this.description.doing"></el-step>
          <el-step title="活动结束" :description="this.description.end"></el-step>
        </el-steps>
        <br>
        <el-row class="row">
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动名称:</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple-light"><span class="spanText">{{activitityname}}</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动地点:</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple-light"><span class="spanText">{{activitityPlace}}</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动允许人数:</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple-light"><span class="spanText">{{count}}/{{activititysCount}}</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动类型:</span></div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple-light"><span class="spanText">{{activitityType}}</span></div>
          </el-col>
        </el-row>
        <el-row class="row">
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动时间:</span></div>
          </el-col>
          <el-col :span="9">
            <div class="grid-content bg-purple-light"><span class="spanText">{{activitityStartTime|dateFormat}}----{{activitityEndTime|dateFormat}}</span>
            </div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">报名时间:</span></div>
          </el-col>
          <el-col :span="9">
            <div class="grid-content bg-purple-light"><span class="spanText">{{signuptime|dateFormat}}----{{signupendtime|dateFormat}}</span>
            </div>
          </el-col>
        </el-row>
        <el-row class="row">
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">举办社团:</span></div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple-light"><span class="spanText">{{orgName}}</span></div>
          </el-col>
        </el-row>
        <el-row class="row">
          <el-col :span="3">
            <div class="grid-content bg-purple"><span class="span">活动描述:</span></div>
          </el-col>
          <el-col :span="21">
            <div class="grid-content bg-purple-light"><span class="spanText">{{activitityDescribe}}</span></div>
          </el-col>
        </el-row>
        <el-row v-if="this.type == '学生'" class="row">
          <el-button disabled v-if="active != '2' && Singup == 'true'" type="danger">不在报名时间</el-button>
          <el-button v-if="Singup == 'true'&& active == '2'" type="success" @click="ActSingup">活动报名</el-button>
          <el-button v-if="Singup == 'false'" disabled type="danger">已报名</el-button>
        </el-row>

      </div>
    </div>
  </div>
</template>

<script>
    import moment from 'moment'

    export default {
        name: "ActivitiesProgress",
        data() {
            return {
                value: '',
                description: {
                    start: "",
                    signUp: "",
                    doing: "",
                    end: ""
                },
                active: 0,
                activitityname: "",
                orgName: "",
                activitityType: "",
                activititysCount: "",
                activitityPlace: "",
                activitityStartTime: "",
                activitityEndTime: "",
                activitityDescribe: "",
                signuptime: "",
                signupendtime: "",
                Singup: "",
                count: 0,
                type: window.sessionStorage.getItem('userType'),
            }
        },
        methods: {
            ActSingup() {
                let _this = this;
                let data = {
                    data: {
                        "userID": sessionStorage.getItem("userID"),
                        "activityID": sessionStorage.getItem("activitityid"),
                    }
                };
                this.$axios.post('/actSingup', JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 0) {
                            _this.$notify.success({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                            _this.Singup = 'false';
                        }
                        if (response.data.code == 1) {
                            _this.$notify.warning({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });

            },

        },
        filters: {
            dateFormat: function (value) {
                return moment(value).format("YYYY-MM-DD HH:mm")
            },
        },
        beforeDestroy() {
            sessionStorage.removeItem("activitityid");
        },
        created() {
            if (sessionStorage.getItem("activitityid") != null) {
                let _this = this;
                let data = {
                    data: {
                        "userID": sessionStorage.getItem("userID"),
                        "activityID": sessionStorage.getItem("activitityid"),
                    }
                };
                this.$axios.post('/findOneActivity', JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 0) {
                            _this.activitityname = response.data.data.activitityInfo.activitityname;
                            _this.orgName = response.data.data.activitityInfo.orgname;
                            _this.activititysCount = response.data.data.activitityInfo.activitityscount;
                            _this.activitityType = response.data.data.activitityInfo.activititytype;
                            _this.activitityPlace = response.data.data.activitityInfo.activitityplace;
                            _this.activitityStartTime = response.data.data.activitityInfo.activititystarttime;
                            _this.activitityEndTime = response.data.data.activitityInfo.activitityendtime;
                            _this.activitityDescribe = response.data.data.activitityInfo.activititydescribe;
                            _this.signuptime = response.data.data.activitityInfo.signuptime;
                            _this.active = parseInt(response.data.data.activitityInfo.activititystatus);
                            _this.Singup = response.data.data.activitityInfo.singup;
                            _this.Singup = response.data.data.activitityInfo.singup;
                            _this.signupendtime = response.data.data.activitityInfo.signupendtime;
                            _this.count = response.data.data.count;
                            console.log(response.data.msg);
                        }
                        if (response.data.code == 1) {
                            _this.$notify.warning({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
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

  .top_tag {
    margin-top: 10px;
    margin-bottom: 20px;
    width: 200px;
  }

  #ActivitiesProgress {
    width: 100%;
    margin-top: 30px;
  }

  #ActivitiesProgress_box {
    height: 500px;
    width: 85%;
    margin: auto;
    background-color: white;
  }

  .bg-purple {
    background: #409EFF;
  }

  .bg-purple-light {
    background: #E4E7ED;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row {
    width: 80%;
    margin: auto;
    margin-top: 30px;
  }

  .span {
    line-height: 36px;
    color: white;
  }

  .spanText {
    line-height: 36px;
    color: black;
  }


</style>
