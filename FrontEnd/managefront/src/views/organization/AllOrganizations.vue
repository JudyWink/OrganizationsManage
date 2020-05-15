<template>
  <div id="allActivities_box">
    <div id="allActivities">
      <el-table
        :data="orgsList"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false
        @selection-change="handleSelectionChange">
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          label="社团名称"
          width="220px"
          prop="orgname">
          <template slot-scope="scope">
            <el-link @click="openOrgInfo(scope.row)" type="primary">{{ scope.row.orgname }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          label="社团口号"
          prop="orgslogan"
          width="270px">
        </el-table-column>
        <el-table-column
          label="所在校区"
          prop="orgcampus"
          width="100px">
        </el-table-column>
        <el-table-column
          prop="orgtype"
          label="社团类型"
          width="130px">
        </el-table-column>
        <el-table-column
          label="社团负责人"
          prop="leadername"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="orgMmuberCount"
          label="社团人数"
          width="100px">
        </el-table-column>
        <el-table-column
          prop="count"
          label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.orgName!='佛大话剧团'"
              type="success"
              size="mini"
                       :disabled="userType ==='游客' ? true : false"
              @click="SignUp">报名
            </el-button>
            <el-button v-if="scope.row.orgName=='佛大话剧团'"
                       type="warning"
                       size="mini"
                       disabled
                       @click="SignUp">成员
            </el-button>
            <el-button
              type="danger"
              size="mini"
              :disabled="userType ==='游客' ? true : false"
              @click="Feedback">意见反馈
            </el-button>
            <el-button
              icon="el-icon-view"
              size="mini"
              type="primary"
              @click="openOrgInfo(scope.row)">详情
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
                orgsList:[],
                userType: window.sessionStorage.getItem('userType'),
                Count: 1,
                multipleSelection: [],
            }
        },
        methods: {
            SignUp(){
                this.$message.error('报名');
            },
            Feedback(){
                this.$message.error('意见反馈');
            },
            openOrgInfo(row) {
                sessionStorage.setItem("orgID", row.orgid);
                this.$router.push({
                        name:"OrganizationInfo",
                        params: {
                            org: row,
                        }
                })

            },

            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        },
        created() {
            const _this = this;
            this.$axios.post("/findAllOrgs")
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.orgsList = response.data.data.orgsList
                        _this.Count = _this.orgsList.length,
                            console.log(response.data.msg)
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
