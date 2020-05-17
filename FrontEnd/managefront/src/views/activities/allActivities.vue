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
          type="index">
        </el-table-column>
        <el-table-column
          prop="activititystarttime"
          label="开始时间"
          sortable
          :formatter="dateFormat"
          width="160px">
        </el-table-column>
        <el-table-column
          prop="activitityendtime"
          label="结束时间"
          sortable
          :formatter="dateFormat"
          width="160px">
        </el-table-column>
        <el-table-column
          prop="activitityname"
          label="活动名"
          width="150px">
          <template slot-scope="scope">
            <el-link  @click="openMsg(scope.row)" type="primary">{{ scope.row.activitityname }}</el-link>
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
          <template slot-scope="scope">
            <span>{{scope.row.count}}/{{ scope.row.activitityscount }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button
              icon="el-icon-view"
              size="mini"
              type="success"
              @click="openMsg(scope.row)">查看详情
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
                count:0,
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

            openMsg(value) {
                sessionStorage.setItem("activitityid", value.activitityid);
                this.$router.push("/ActivitiesProgress")
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },

        },
        created() {
            let _this = this;
            let data = {
                data: {
                    "userID": sessionStorage.getItem("userID"),
                }
            }
            this.$axios.post("/findAllActivities",JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.ActivitiesList =  response.data.data.ActivitiesList;
                        console.log(response.data.msg)
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        },

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
