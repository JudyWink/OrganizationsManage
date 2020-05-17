<template xmlns:c="http://www.w3.org/1999/html">
  <div id="myPushActs_box">
    <div id="myPushActs">
      <div>
        <div>
          <el-select @change="sb(value)" v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.activitiesid"
              :label="item.actname"
              :value="item.activitiesid"
            >
            </el-option>
          </el-select>
        </div>
        <div v-if="activitityname == ''"><el-tag class="top_tag" effect="dark" type="danger">选一个你发布的活动吧！</el-tag></div>
      </div>
      <div v-if="activitityname != ''">
        <el-tag class="top_tag" effect="dark" type="danger">{{activitityname}}</el-tag>
        <el-steps :active=active align-center finish-status="success">
          <el-step title="活动准备" :description= this.description.start ></el-step>
          <el-step title="活动报名" :description="this.description.signUp"></el-step>
          <el-step title="活动进行" :description="this.description.doing"></el-step>
          <el-step title="活动结束" :description="this.description.end"></el-step>
        </el-steps>
        <br>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动名称:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityname}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动地点:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityPlace}}</span></div></el-col>

          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动类型:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityType}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动允许人数:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{count}}/{{activititysCount}}</span></div></el-col>

        </el-row>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">举办社团:</span></div></el-col>
          <el-col :span="6"><div class="grid-content bg-purple-light"><span class="spanText">{{orgName}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动时间:</span></div></el-col>
          <el-col :span="12"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityStartTime|dateFormat}}==={{activitityEndTime|dateFormat}}</span></div></el-col>
        </el-row>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动描述:</span></div></el-col>
          <el-col :span="21"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityDescribe}}</span></div></el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
    import moment from 'moment'
    export default {
        data() {
            return {
                options: [],
                value: '',
                description:{
                    start:"开始",
                    signUp:"报名",
                    doing:"进行",
                    end:"结束"
                },
                active: "",
                activitityname:"",
                orgName:"",
                activitityType:"",
                activititysCount:"",
                activitityPlace:"",
                activitityStartTime:"",
                activitityEndTime:"",
                activitityDescribe:"",
                count:0,
            }
        },
        methods: {
            sb(value){
                let _this = this;
                let data = {
                    data: {
                        "activityID": value,
                        "userID": sessionStorage.getItem("userID"),
                    }
                }
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
                            _this.active = response.data.data.activitityInfo.activititystatus;
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

        },
        filters:{
            dateFormat:function(value){
                return moment(value).format("YYYY-MM-DD HH:mm")
            },
        },
        created() {
            let _this = this;
            let data = {
                data: {
                    "orgID": sessionStorage.getItem("orgID"),
                }
            }
            this.$axios.post('/findMyPushActivities', JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 0) {
                        console.log(response.data.msg);
                        _this.options = response.data.data.ActivitiesList;
                    }
                    if (response.data.code == 1) {
                        console.log(response.data.msg);
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        }


    }
</script>

<style>

  .top_tag{
    margin-top: 10px;
    margin-bottom: 20px;
    width: 200px;
  }

  #myPushActs {
    width: 100%;
    margin-top: 30px;
  }

  #myPushActs_box {
    height: 420px;
    width: 85%;
    margin: auto;
    background-color: white;
  }

  .bg-purple {
    background:#409EFF;
  }
  .bg-purple-light {
    background:	#E4E7ED;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row{
    width: 80%;
    margin: auto;
    margin-top: 30px;
  }
  .span{
    line-height:36px;
    color: white;
  }

  .spanText{
    line-height:36px;
    color: black;
  }


</style>
