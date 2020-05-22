<template>
  <div id="Message_box">
    <div id="Message">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false
        @selection-change="handleSelectionChange">
        <template slot="empty">
          暂时还没有人给你发消息哦
        </template>
        <el-table-column
          type="selection"
          width="80px">
        </el-table-column>
        <el-table-column
          prop="messagecreatetime"
          label="时间"
          sortable
          :formatter="dateFormat"
          >
        </el-table-column>
        <el-table-column
          prop="messagetitle"
          label="消息主题"
          width="450px">
          <template slot-scope="scope">
            <el-link icon="el-icon-view" @click="openMsg(scope.row)" type="primary">{{ scope.row.messagetitle }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="messagetype"
          label="消息分类">
        </el-table-column>
        <el-table-column
          label="发送人"
          prop="messagelaunchname">
        </el-table-column>
        <el-table-column
          prop="messagestatus"
          label="状态">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.messagestatus === '未读' "
              size="mini"
              :disabled=false
              type="success"
              @click="readMsg(scope.row)">已读
            </el-button>
            <el-button v-if="scope.row.messagestatus === '已读'"
              size="mini"
              :disabled=true
              @click="readMsg(scope.row)">已读
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="deleteMsg(scope.row)">删除
            </el-button>
            <el-dialog ref="dialog"  :close-on-click-modal="false" width="700px" :visible.sync="dialogFormVisible">
              <el-form>
                <el-form-item>
                  <h2>{{dialoMessagetitle}}</h2>
                </el-form-item>
                <el-form-item>
                  <el-card class="box-card">
                    <div>
                      {{dialogMessagetext}}
                    </div>
                  </el-card>
                </el-form-item>
                <el-form-item>
                  <el-button v-if="dialogMessagestatus === '已读'" disabled>已 读</el-button>
                  <el-button v-if="dialogMessagestatus === '未读'" type="success" @click="readMsg(scope.row)">已 读</el-button>
                  <el-button  type="primary" @click="reply">{{replytext}}</el-button>
                </el-form-item>
                <el-form-item v-if="input">
                <el-input
                  rows="4"
                  v-model="replyMessagetext"
                          type="textarea"
                          placeholder="请输入内容"
                          maxlength="100"
                          show-word-limit
                ></el-input>
                  </el-form-item>
                  <el-form-item v-if="input">
                  <el-button  type="danger" @click="send">发 送</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <span style="float: left">
            选中:
      <el-tag size="mini">{{this.multipleSelection.length}}</el-tag>
      条
      <el-button type="success" size="mini" @click="readAllMsgs()">一键已读</el-button>
    </span>
  </div>
</template>

<script>
    import moment from 'moment'
    import elTableInfiniteScroll from 'el-table-infinite-scroll';
    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "Document",
        data() {
            return {
                tableData: [],
                multipleSelection: [],
                dialogFormVisible:false,
                input : false,
                replytext : "回 复",
                replyMessagetext:"",
                replyType : "",
                dialoMessagetitle:"",
                dialogMessagetext:"",
                dialogMessagestatus:"",
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

            readMsg(value) {
                const _this = this;
                let data={
                    data:{
                        "MessageID" :  value.messageid,
                    }
                }
                this.$axios.post('/readMessage', JSON.stringify(data))
                    .then(async function (response) {
                        if (response.data.code == 1) {
                            _this.$notify.error({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                        if (response.data.code == 0) {
                         await   _this.$notify.success({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                         await _this.$router.replace("/test");
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            },

            readAllMsgs(){
                let MessageIDs = [];
                let Selection = this.multipleSelection;
                    for(let i = 0 ; i < Selection.length; i++){
                        MessageIDs.push(Selection[i].messageid)
                        if(Selection[i].messagestatus === "已读"){
                            this.$notify.warning({
                                message: "请选择未读消息",
                                showClose: false,
                                duration: 1500,
                            });
                            return false;
                        }
                    }
                const _this = this;
                let data={
                    data:{
                        "MessageIDs" :  MessageIDs,
                    }
                }
                this.$axios.post('/readMessages', JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 1) {
                            _this.$notify.error({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                        if (response.data.code == 0) {
                               _this.$notify.success({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                            _this.$router.replace("/test");
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });


            },


            openMsg(value){
                this.dialogFormVisible = true;
                this.dialoMessagetitle = value.messagetitle;
                this.dialogMessagetext = value.messagetext;
                this.dialogMessagestatus = value.messagestatus;
                this.dialogMessageUserID = value.messagelaunch;
                this.input = false;
                this.replytext = "回 复";
            },

            reply(){

                if(this.replytext === "回 复") {
                    this.input = true
                    this.replytext = "取 消"
                }else if(this.replytext === "取 消") {
                    this.input = false
                    this.replytext = "回 复"
                }

            },


            deleteMsg(value){
                let _this = this;
                let data = {
                    data:{
                        "MessageID" : value.messageid,

                    }
                };
                if (value.messagestatus === '未读'){
                    this.$confirm('此消息还未读, 是否继续删除?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        _this.$axios.post('/deleteMessages', JSON.stringify(data))
                            .then(async function (response) {
                                if (response.data.code == 1) {
                                    _this.$notify.error({
                                        message: response.data.msg,
                                        showClose: false,
                                        duration: 1500,
                                    });
                                }
                                if (response.data.code == 0) {
                                    _this.$notify.success({
                                        message: response.data.msg,
                                        showClose: false,
                                        duration: 1500,
                                    });
                                    _this.$router.replace("/test");
                                }
                            })
                            .catch(function (error) {
                                console.log(error)
                            });
                    }).catch(() => {
                        this.$notify.warning({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
                }else {
                    this.$axios.post('/deleteMessages', JSON.stringify(data))
                        .then(async function (response) {
                            if (response.data.code == 1) {
                                _this.$notify.error({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                            }
                            if (response.data.code == 0) {
                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                                _this.$router.replace("/test");
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }
            },

            send(){
                if(this.replyMessagetext.length<1){
                    this.$notify.warning({
                        message: "请填写回复内容",
                        showClose: false,
                        duration: 1500,
                    });
                    return false;
                }
                    let _this = this;
                    let data = {
                        data:{
                            "msg":{
                              "text": this.replyMessagetext,
                                "title": "回复【"+this.dialoMessagetitle+"】",
                                "type" :"回复",
                            },
                            "ReceiveID":this.dialogMessageUserID,
                            "userID": sessionStorage.getItem('userID'),
                        }
                    };
                    this.$axios.post("/senddMessage",JSON.stringify(data))
                        .then(function (response) {
                            if (response.data.code == 1) {
                                _this.$notify.warning({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                            }
                            if (response.data.code == 0) {
                                _this.$notify.success({
                                    message: response.data.msg,
                                    showClose: false,
                                    duration: 1500,
                                });
                                _this.dialogFormVisible = false;
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
            },

            handleSelectionChange(val){
                this.multipleSelection = val;
            },
        },
        created() {
            const _this = this;
            let data={
                data:{
                    "userID" :  sessionStorage.getItem("userID"),
                }
            }
            this.$axios.post('/findMessages', JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        console.log(response.data.msg);
                        _this.tableData = response.data.data.tableData;
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });

        }
    }
</script>

<style>
  #Message {
    width: 100%;
    margin: 10px auto;
  }

  #Message_box {
    width: 85%;
    margin: auto;
  }

</style>
