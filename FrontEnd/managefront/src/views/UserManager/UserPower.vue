<template>
<div id="UserPower_box">
  <div id="UserPower">
    <el-table
      :data="usersList"
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
        prop="username">
        <template slot-scope="scope">
          <el-link  @click="openUser(scope.row)" type="primary">{{ scope.row.username }}</el-link>
        </template>
      </el-table-column>
      <el-table-column
        label="学院"
        prop="useracademy"
        width="240px">
      </el-table-column>
      <el-table-column
        label="班级"
        prop="userclass"
        width="240px">
      </el-table-column>
      <el-table-column
        prop="userphone"
        label="联系方式"
        width="200px">
      </el-table-column>
      <el-table-column
        prop="usernumber"
        label="学号"
        width="200px">
      </el-table-column>
      <el-table-column
        prop="count"
        label="操作">
        <template slot-scope="scope">
          <el-button
            type="success"
            size="mini"
            @click="sendMessage(scope.row)">通知
          </el-button>
          <el-button
            type="primary"
            size="mini"
            @click="empower">授权
          </el-button>
          <el-dialog ref="dialog"  :close-on-click-modal="false"  width="700px" :visible.sync="dialogFormVisible">
            <el-form :model="Form" :rules="fromrules">
              <el-form-item>
                <h2>向用户[<span style="color:red">{{Name}}</span>]发送消息</h2>
              </el-form-item>
              <el-form-item prop="title">
                <el-input
                  v-model = "Form.title"
                  placeholder="请输入消息标题"
                  maxlength="10"
                  show-word-limit
                ></el-input>
              </el-form-item>
              <el-form-item prop="text">
                <el-input
                  v-model="Form.text"
                  type="textarea"
                  rows="4"
                  placeholder="请输入消息内容"
                  maxlength="100"
                  show-word-limit
                ></el-input>
              </el-form-item>
              <el-form-item prop="type">
                <el-radio-group v-model="Form.type">
                  <el-radio label="通知"></el-radio>
                  <el-radio label="公告"></el-radio>
                  <el-radio label="警告"></el-radio>
                  <el-radio label="广告"></el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item>
                <el-button  type="primary" @click="send">发 送</el-button>
                <el-button type="success" @click="dialogFormVisible = false">取 消</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>
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
        name: "UserPower",
        data() {
            return {
                usersList:[],
                userCount: '',
                dialogFormVisible:false,
                Name:"",
                MessageType:"",
                messageInfo:{},
                Form: {
                    title: "",
                    text: "",
                    type: "",
                },
                fromrules:{
                    title: [
                        { required: true, message: '请输入消息标题', trigger: 'blur' },
                        { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
                    ],
                    text: [
                        { required: true, message: '请输入消息内容', trigger: 'blur' },
                        { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
                    ],
                    type: [
                        { required: true, message: '请选择消息类型', trigger: 'change' }
                    ],
                }
            }
        },
        methods: {
            sendMessage(value) {
                this.messageInfo = value
                this.Form = {};
                this.dialogFormVisible = true;
                this.Name = value.username;
            },
            send(){
                if(this.Form.text == null || this.Form.text.length > 100 ||this.Form.text.length <1){
                return false;
                }if(this.Form.title == null || this.Form.title.length > 10 ||this.Form.title.length <1){
                    return false;
                }if(this.Form.type == null ||this.Form.type.length <1){
                    return false;
                }
                let _this = this;
                let data = {
                    data:{
                        "msg":this.Form,
                        "ReceiveID":this.messageInfo.userid,
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

            openUser(value){
                this.$router.push({
                    name: 'PersonalInfo',
                    params: {
                        canModify: false,
                        userID:value.userid,
                    }
                })
            },

            empower() {
                this.$message.error('授权');
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        },
        created() {
            const _this = this;
            this.$axios.post("/findNoOrgAllUsers")
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.usersList = response.data.data.usersList
                        _this.userCount = _this.usersList.length,
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
  #UserPower {
    width: 100%;
    margin: 10px auto;
  }

  #UserPower_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }
</style>
