<template>
  <div id="allActivities_box">
    <div id="allActivities">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false
        @selection-change="handleSelectionChange">
        <el-table-column
          type="index"
          :index="indexMethod">
        </el-table-column>
        <el-table-column
          prop="activitityStartTime"
          label="开始时间"
          sortable
          width="130px">
        </el-table-column>
        <el-table-column
          prop="activitityEndTime"
          label="结束时间"
          sortable
          width="130px">
        </el-table-column>
        <el-table-column
          prop="activitityName"
          label="活动名"
          width="250px">
          <template slot-scope="scope">
            <el-link icon="el-icon-view" @click="openMsg" type="primary">{{ scope.row.activitityName }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="activitityType"
          label="活动类型"
          width="130px">
        </el-table-column>
        <el-table-column
          label="举办组织"
          prop="activitityOwnerOrg"
          width="180px">
        </el-table-column>
        <el-table-column
          prop="activitityStatus"
          label="活动状态">
        </el-table-column>
        <el-table-column
          prop="activititysCount"
          label="人数"
          width="130px">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.activitityName=='校园十大歌手'|| scope.row.activitityName=='我是歌手'"
                       type="success"
                       size="mini"
                       disabled
                       @click="openMsg">已报名
            </el-button>
            <el-button v-if="scope.row.activitityName!='校园十大歌手'&& scope.row.activitityName!='我是歌手'"
              type="success"
              size="mini"
                       :disabled="userType ==='游客' ? true : false"
              @click="openMsg">报名
            </el-button>
            <el-button
              icon="el-icon-view"
              size="mini"
              type="primary"
              :disabled="userType ==='游客' ? true : false"
              @click="openMsg">详情
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "allActivities",
        data() {
            return {
                userType: window.sessionStorage.getItem('userType'),
                msgCount: 1,
                tableData: [{
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '校园十大歌手',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '摄影大赛',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '我是歌手',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '荧光夜跑',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '食堂开放日',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '物理知识讲座',
                    activitityType: '知识讲座',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '校长下午茶',
                    activitityType: '知识讲座',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '50KM徒步',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                }, {
                    activitityStartTime: '2016-05-02',
                    activitityEndTime: '2016-05-02',
                    activitityName: '校园十大歌手',
                    activitityType: '娱乐',
                    activitityOwnerOrg: '佛山科学技术学院学生会',
                    activitityStatus: '进行中',
                    activititysCount: '20/60',
                },],
                multipleSelection: [],
            }
        },
        methods: {
            openMsg() {
                this.$router.push('/ActivitiesProgress')
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        }
    }
</script>

<style>
  #allActivities {
    width: 100%;
    margin: 10px auto;
  }

  #allActivities_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }

</style>
