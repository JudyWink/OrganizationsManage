<template>
  <div id="members_box">
    <div id="members">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="60px">
        </el-table-column>
        <el-table-column
          label="学生名"
          width="200px"
          prop="userName">
        </el-table-column>
        <el-table-column
          label="部门"
          prop="department"
          width="200px">
        </el-table-column>
        <el-table-column
          label="职位"
          prop="position"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="phone"
          label="联系方式"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="joinTime"
          label="入团时间"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="count"
          label="操作">
          <template>
            <el-button
              type="success"
              size="mini"
              @click="sendMessage">通知
            </el-button>
            <el-button
              type="primary"
              size="mini"
              @click="promoted">升职
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="fire">踢出
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <span style="float: left">
            选中:
      <el-tag size="mini">{{this.multipleSelection.length}}</el-tag>
      名成员
      <el-button type="success" size="mini" @click="sendMessage">一键通知</el-button>
    </span>
    <span style="float: right">
      共<el-tag size="mini">{{this.membersCount}}</el-tag>人
    </span>
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
                membersCount:'30',
                tableData: [
                    {
                        userName: '张三',
                        department: '宣传部',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '李四',
                        department: '宣传部',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '吴三',
                        department: '部长',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '吴四',
                        department: '宣传部',
                        position: '副部长',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '上下九',
                        department: '宣传部',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '武德训',
                        department: '宣传部',
                        position: '副部长',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '西门口',
                        department: '宣传部',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                    {
                        userName: '贾发',
                        department: '宣传部',
                        position: '成员',
                        phone: '12345678910',
                        joinTime: '2016-05-02',
                    },
                ],
                multipleSelection: [],
            }
        },
        methods: {
            sendMessage() {
                this.$message.error('发通知');
            },
            promoted() {
                this.$message.error('升职');
            },
            fire() {
                this.$message.error('解雇');
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
  #members {
    width: 100%;
    margin: 10px auto;
  }

  #members_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }

</style>
