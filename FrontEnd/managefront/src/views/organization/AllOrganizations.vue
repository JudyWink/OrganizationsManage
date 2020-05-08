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
          label="社团名称"
          width="180px"
          prop="orgName">
          <template slot-scope="scope">
            <el-link @click="openMsg" type="primary">{{ scope.row.orgName }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          label="社团口号"
          prop="orgSlogan"
          width="290px">
        </el-table-column>
        <el-table-column
          label="所在校区"
          prop="orgCampus"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="orgType"
          label="社团类型"
          width="130px">
        </el-table-column>
        <el-table-column
          label="社团负责人"
          prop="orgLeader"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="orgMmuberCount"
          label="社团人数"
          width="120px">
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
                tableData: [
                    {
                        orgName: '佛山科学技术学院学生会',
                        orgSlogan: '提升自我，服务大家',
                        orgCampus: '仙溪',
                        orgType: '校级机构',
                        orgLeader: '张三',
                        orgMmuberCount: '200',
                    },
                    {
                        orgName: '佛山科学技术学院社团联合会',
                        orgSlogan: '服务社团，服务同学',
                        orgCampus: '仙溪',
                        orgType: '校级机构',
                        orgLeader: '李四',
                        orgMmuberCount: '150',
                    }, {
                        orgName: '佛大话剧团',
                        orgSlogan: '一个演员的自我修养',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '小明',
                        orgMmuberCount: '80',
                    }, {
                        orgName: '吉他协会',
                        orgSlogan: '用音乐创造快乐',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '六叔',
                        orgMmuberCount: '50',
                    }, {
                        orgName: '墨韵书画社',
                        orgSlogan: '书出个性，画出张扬',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '120',
                    }, {
                        orgName: 'XXXX',
                        orgSlogan: 'XXXXXXXX',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '100',
                    },
                    {
                        orgName: 'XXXX',
                        orgSlogan: 'XXXXXXXX',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '100',
                    },
                    {
                        orgName: 'XXXX',
                        orgSlogan: 'XXXXXXXX',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '100',
                    },
                    {
                        orgName: 'XXXX',
                        orgSlogan: 'XXXXXXXX',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '100',
                    },
                    {
                        orgName: 'XXXX',
                        orgSlogan: 'XXXXXXXX',
                        orgCampus: '仙溪',
                        orgType: '社团',
                        orgLeader: '张三',
                        orgMmuberCount: '100',
                    }],
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
            openMsg() {
                this.$router.push('/myOrganization')
                // this.$message.error('打开社团界面');
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            // load() {
            //     // this.$message.success('加载下一页');
            // }
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
