<template xmlns:c="http://www.w3.org/1999/html">
  <div id="ActivitiesProgress_box">
    <div id="ActivitiesProgress">
      <el-tag class="top_tag" effect="dark" type="danger">{{activitityName}}</el-tag>
      <el-steps :active=active align-center finish-status="success">
        <el-step title="活动准备" :description= this.description.start ></el-step>
        <el-step title="活动报名" :description="this.description.signUp"></el-step>
        <el-step title="活动进行" :description="this.description.doing"></el-step>
        <el-step title="活动结束" :description="this.description.end"></el-step>
      </el-steps>
      <br>
      <div class="elcol">
        <el-divider content-position="left">活动详情:</el-divider>
        <table>
          <tr>
            <td><el-tag effect="dark" type="warning">举办组织:</el-tag></td>
            <td class="info-td"><pre>  {{org}}</pre></td>
          </tr>
          <tr>
            <td><el-tag effect="dark" type="warning">举办地点:</el-tag></td>
            <td class="info-td"><pre>  {{place}}</pre></td>
          </tr>
          <tr>
            <td><el-tag effect="dark" type="warning">活动人数:</el-tag></td>
            <td class="info-td"><pre>  {{count}}/{{maxcount}}</pre></td>
          </tr>
          <tr>
            <td><el-tag effect="dark" type="warning">活动信息:</el-tag></td>
            <td class="info-td"><pre>  {{info}}</pre></td>
          </tr>
        </table>
        <div v-if="isenrol">
        <el-button :disabled="userType ==='游客' ? true : false" style="margin-top: 10px" type="success">活动报名</el-button>
        </div>
        <div v-else>
          <el-button style="margin-top: 10px" disabled type="success">已报名</el-button>
        </div>
    </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "ActivitiesProgress",
        data() {
            return {
                userType: window.sessionStorage.getItem('userType'),
                isenrol:true,
                org:"茶水部",
                place:"仙溪湖",
                info:"少时诵诗书所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所",
                count:20,
                maxcount:60,
                activitityName:"篮球赛",
                active: 2,
                description:{
                    start:"开始",
                    signUp:"报名",
                    doing:"进行",
                    end:"结束"
                }
            }
        },
        methods: {

        }

    }
</script>

<style>
  .info-td{
    float: left;
    line-height: 30px;
  }

  .top_tag{
    margin-top: 10px;
    margin-bottom: 20px;
    width: 200px;
  }

  #ActivitiesProgress {
    width: 100%;
    margin-top: 30px;

  }

  #ActivitiesProgress_box {
    height: 420px;
    width: 85%;
    margin: auto;
    background-color: white;
  }

  .elcol{
    /*border: solid 1px #d1d1d1;*/
    width: 80%;
    margin: auto;
  }

</style>
