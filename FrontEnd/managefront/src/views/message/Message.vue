<template>
  <div id="document_box">
    <div id="document">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="80px">
        </el-table-column>
        <el-table-column
          prop="messageCreateTime"
          label="时间"
          sortable
          >
        </el-table-column>
        <el-table-column
          prop="messageTitle"
          label="消息内容"
          width="500px">
          <template slot-scope="scope">
            <el-link icon="el-icon-view" @click="openMsg" type="primary">{{ scope.row.messageTitle }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="messageType"
          label="消息分类">
        </el-table-column>
        <el-table-column
          label="发送人"
          prop="messageLaunch">
        </el-table-column>
        <el-table-column
          prop="messageStatus"
          label="状态">
        </el-table-column>
        <el-table-column
          prop="count"
          label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.messageTitle =='佛大话剧团即将开展元旦晚会表演'"
              size="mini"
                       disabled
              @click="readMsg">已读
            </el-button>
            <el-button v-if="scope.row.messageTitle !='佛大话剧团即将开展元旦晚会表演'"
                       size="mini"
                       type="success"
                       @click="readMsg">已读
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="deleteMsg">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <span style="float: left">
            选中:
      <el-tag size="mini">{{this.multipleSelection.length}}</el-tag>
      条
      <el-button type="success" size="mini" @click="readMsg">一键已读</el-button>
      <el-button
        size="mini"
        type="danger"
        @click="deleteMsg">删除</el-button>
    </span>
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';
    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "Document",
        data() {
            return {
                tableData: [{
                    messageCreateTime: '2016-05-02',
                    messageLaunch: '李四',
                    messageTitle: '佛大话剧团即将开展元旦晚会表演',
                    messageType: '邀请函',
                    messageStatus:'已读',
                }, {
                    messageCreateTime: '2016-05-02',
                    messageLaunch: '辅导员',
                    messageTitle: '辅导员通知你社团活动取消',
                    messageType: '通知',
                    messageStatus:'未读',
                }, {
                    messageCreateTime: '2016-05-02',
                    messageLaunch: '管理员',
                    messageTitle: '管理员通知你修改密码',
                    messageType: '通知',
                    messageStatus:'未读',
                }, {
                    messageCreateTime: '2016-05-02',
                    messageLaunch: '小明',
                    messageTitle: '佛山科学技术学院学生会的一份邀请',
                    messageType: '邀请函',
                    messageStatus:'未读',
                }],
                multipleSelection: [],
            }
        },
        methods: {
            readMsg() {
                this.$message('已读');
            },
            openMsg(){
                this.$message('消息详情');
            },
            deleteMsg(){
                this.$message('删除消息');
            },

            handleSelectionChange(val){
                this.multipleSelection = val;
            },
        }
    }
</script>

<style>
  #document {
    width: 100%;
    margin: 10px auto;
  }

  #document_box {
    width: 85%;
    margin: auto;
  }

</style>
