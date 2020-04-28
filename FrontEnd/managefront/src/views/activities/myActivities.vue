<template>
  <div id="ActivitiesProgress_box">
    <div id="ActivitiesProgress">
      <el-select class="top_select" v-model="value" placeholder="请选择活动">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <div v-if=haveNotacts>
        <el-steps :active=active align-center finish-status="success">
          <el-step title="活动准备" :description=this.description.start></el-step>
          <el-step title="活动报名" :description="this.description.signUp"></el-step>
          <el-step title="活动进行" :description="this.description.doing"></el-step>
          <el-step title="活动结束" :description="this.description.end"></el-step>
        </el-steps>
        <br>
        <div class="elcol">
          <el-divider content-position="left">活动详情:</el-divider>
          <table style="width: 60%">
            <tr>
              <td>
                <el-tag effect="dark" type="warning">举办组织:</el-tag>
              </td>
              <td class="info-td">
                <pre>  {{activitityOwnerOrg}}</pre>
              </td>
              <td>
                <el-tag effect="dark" type="warning">举办地点:</el-tag>
              </td>
              <td class="info-td">
                <pre>  {{activitityPlace}}</pre>
              </td>
              <td>
                <el-tag effect="dark" type="warning">举办地点:</el-tag>
              </td>
              <td class="info-td">
                <pre>  {{activitityPlace}}</pre>
              </td>
            </tr>
            <tr>
              <td>
                <el-tag effect="dark" type="warning">举办地点:</el-tag>
              </td>
              <td class="info-td">
                <pre>  {{activitityPlace}}</pre>
              </td>
            </tr>
            <tr>
              <td>
                <el-tag effect="dark" type="warning">活动人数:</el-tag>
              </td>
              <td class="info-td">
                <pre>  {{memberCount}}/{{activititysCount}}</pre>
              </td>
            </tr>
            <tr>
              <td>
                <el-tag effect="dark" type="warning">活动信息:</el-tag>
              </td>
              <td colspan="4" class="info-td" >{{activitityDescribe}}
              </td>
            </tr>
          </table>
          <div>
            <el-button style="margin-top: 10px" type="danger">取消报名</el-button>
          </div>
        </div>
      </div>
      <div v-else>
        <div style="margin-top: 80px ;color: rgb(74, 202, 109)">
          <h1>你还没参加活动呀~</h1>
          <h1>赶紧去参加吧！</h1>
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

                activitityName: "篮球赛",
                activitityOwnerOrg: "茶水部",
                activitityPlace: "仙溪湖",
                activitityDescribe: "少时诵ssssssssssssssssssssssssssssssss诗书所",
                memberCount: 20,
                activititysCount: 60,

                active: 2,

                description: {
                    start: "",
                    signUp: "",
                    doing: "",
                    end: ""
                },
                //
                haveNotacts: true,
                options: [{
                    value: '选项1',
                    label: '黄金糕'
                }, {
                    value: '选项2',
                    label: '双皮奶'
                }, {
                    value: '选项3',
                    label: '蚵仔煎'
                }, {
                    value: '选项4',
                    label: '龙须面'
                }, {
                    value: '选项5',
                    label: '北京烤鸭'
                }],
                value: ''
            }
        },
        methods: {}

    }
</script>

<style>

  .info-td {
    /*float: left;*/
    line-height: 30px;
  }

  .top_select {
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

  .elcol {
    /*border: solid 1px #d1d1d1;*/
    width: 80%;
    margin: auto;
  }

</style>
