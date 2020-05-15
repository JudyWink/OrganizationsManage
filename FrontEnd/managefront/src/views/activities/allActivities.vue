<template>
  <div id="allActivities_box">
    <div id="allActivities">
      <el-table
        :data="ActivitiesList"
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
          prop="activititystarttime"
          label="开始时间"
          sortable
          :formatter="dateFormat"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="activitityendtime"
          label="结束时间"
          sortable
          :formatter="dateFormat"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="activitityname"
          label="活动名"
          width="180px">
          <template slot-scope="scope">
            <el-link icon="el-icon-view" @click="openMsg" type="primary">{{ scope.row.activitityname }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="activititytype"
          label="活动类型"
          width="100px">
        </el-table-column>
        <el-table-column
          label="举办组织"
          prop="orgname"
          width="230px">
        </el-table-column>
        <el-table-column
          prop="activititystatus"
          width="130px"
          label="活动状态">
        </el-table-column>
        <el-table-column
          prop="activitityscount"
          label="人数"
          width="130px">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.activitityname=='校园十大歌手'|| scope.row.activitityname=='我是歌手'"
                       type="warning"
                       size="mini"
                       disabled
                       @click="openMsg">已报名
            </el-button>
            <el-button v-if="scope.row.activitityname!='校园十大歌手'&& scope.row.activitityname!='我是歌手'"
              type="success"
              size="mini"
                       :disabled="userType ==='游客' || userType ==='系统管理员' || scope.row.activititystatus != '报名中' ? true : false"
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
    import moment from 'moment'

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "allActivities",
        data() {
            return {
                userType: window.sessionStorage.getItem('userType'),
                msgCount: 1,
                ActivitiesList:[],
                multipleSelection: [],
            }
        },
        methods: {
            dateFormat(row, column){
                let date = row[column.property]
                if (date == undefined) {
                    return ''
                }
                return moment(date).format("YYYY-MM-DD hh:mm")
            },

            openMsg() {
                this.$router.push('/ActivitiesProgress')
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        },
        created() {
            const _this = this;
            this.$axios.post("/findAllActivities")
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.ActivitiesList = response.data.data.ActivitiesList
                            console.log(response.data.msg)
                        console.log(_this.ActivitiesList)
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
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
