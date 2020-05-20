<template>
  <div id="SignupMembers_box">
    <div id="SignupMembers">
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
          width="80px"
          prop="username">
          <template slot-scope="scope">
            <el-link @click="openUser(scope.row)" type="primary">{{ scope.row.username }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          label="性别"
          prop="usersex"
          width="50px">
        </el-table-column>
        <el-table-column
          label="学院"
          prop="useracademy"
          width="160px">
        </el-table-column>
        <el-table-column
          label="班级"
          prop="userclass"
          width="160px">
        </el-table-column>
        <el-table-column
          prop="userphone"
          label="联系方式"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="userqq"
          label="QQ号"
          width="100px">
        </el-table-column>
        <el-table-column
          prop="userwechat"
          label="微信号"
          width="100px">
        </el-table-column>
        <el-table-column
          prop="usernumber"
          label="学号"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="updatetime"
          label="报名时间"
          sortable
          :formatter="dateFormat"
          width="160px">
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
              @click="openempower(scope.row)">授权
            </el-button>

            <el-dialog :close-on-click-modal="false" width="500px" :visible.sync="dialogEmpowerVisible"
                       :title=openempowerTitle>
              <el-button type="success" @click="empower(scope.row)">确定</el-button>
            </el-dialog>


            <el-dialog ref="dialog" :close-on-click-modal="false" width="700px" :visible.sync="dialogFormVisible">
              <el-form :model="Form" :rules="fromrules">
                <el-form-item>
                  <h2>向报名学生[<span style="color:red">{{Name}}</span>]发送消息</h2>
                </el-form-item>
                <el-form-item prop="title">
                  <el-input
                    v-model="Form.title"
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
                  <el-button type="primary" @click="send">发 送</el-button>
                  <el-button type="success" @click="dialogFormVisible = false">取 消</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>
            <el-dialog ref="dialog"  :close-on-click-modal="false"  width="700px" :visible.sync="dialogmanyFormVisible">
              <el-form :model="manyForm" :rules="manyfromrules">
                <el-form-item>
                  <h2>批量向[<span style="color:red">{{manyCount}}</span>]位用户发送消息</h2>
                </el-form-item>
                <el-form-item prop="manytitle">
                  <el-input
                    v-model = "manyForm.manytitle"
                    placeholder="请输入消息标题"
                    maxlength="10"
                    show-word-limit
                  ></el-input>
                </el-form-item>
                <el-form-item prop="manytext">
                  <el-input
                    v-model="manyForm.manytext"
                    type="textarea"
                    rows="4"
                    placeholder="请输入消息内容"
                    maxlength="100"
                    show-word-limit
                  ></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button  type="primary" @click="manysend">批量发送</el-button>
                  <el-button type="success" @click="dialogmanyFormVisible = false">取 消</el-button>
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
      名成员
      <el-button type="success" size="mini" @click="opensendMany">一键通知</el-button>
    </span>
    <span style="float: right">
      共<el-tag size="mini">{{this.userCount}}</el-tag>人
    </span>
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';
    import moment from 'moment'

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "SignupMembers",
        data() {
            return {
                options: [],
                empowerorgID: '',
                empowerID: '',
                empowerorgName: '',
                openempowerTitle: '',
                empowerName: "",
                signupID:"",
                usersList: [],
                userCount: '',
                dialogFormVisible: false,
                dialogEmpowerVisible: false,
                Name: "",
                MessageType: "",
                messageInfo: {},
                Form: {
                    title: "",
                    text: "",
                    type: "",
                },
                fromrules: {
                    title: [
                        {required: true, message: '请输入消息标题', trigger: 'blur'},
                        {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
                    ],
                    text: [
                        {required: true, message: '请输入消息内容', trigger: 'blur'},
                        {min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur'}
                    ],
                    type: [
                        {required: true, message: '请选择消息类型', trigger: 'change'}
                    ],
                },
                manyUseID:[],
                dialogmanyFormVisible:false,
                manyForm: {
                    manytitle: "",
                    manytext: "",
                },
                manyfromrules:{
                    manytitle: [
                        { required: true, message: '请输入消息标题', trigger: 'blur' },
                        { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
                    ],
                    manytext: [
                        { required: true, message: '请输入消息内容', trigger: 'blur' },
                        { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
                    ],
                },
                manyCount:"",
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
            sendMessage(value) {
                this.messageInfo = value
                this.Form = {};
                this.dialogFormVisible = true;
                this.Name = value.username;
            },
            send() {
                if (this.Form.text == null || this.Form.text.length > 100 || this.Form.text.length < 1) {
                    return false;
                }
                if (this.Form.title == null || this.Form.title.length > 10 || this.Form.title.length < 1) {
                    return false;
                }
                if (this.Form.type == null || this.Form.type.length < 1) {
                    return false;
                }
                let _this = this;
                let data = {
                    data: {
                        "msg": this.Form,
                        "ReceiveID": this.messageInfo.userid,
                        "userID": sessionStorage.getItem('userID'),
                    }
                };
                this.$axios.post("/senddMessage", JSON.stringify(data))
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

            openUser(value) {
                this.$router.push({
                    name: 'PersonalInfo',
                    params: {
                        canModify: false,
                        userID: value.userid,
                    }
                })
            },

            openempower(value) {
                this.openempowerTitle = "授权学生【" + value.username + "】加入本社团";
                this.dialogEmpowerVisible = true;
                this.empowerName = value.username;
                this.empowerID = value.userid;
                this.signupID = value.userphoto;
            },

            empower() {
                console.log(this.empowerID);
                console.log(this.empowerorgID);
                this.$confirm('是否授权学生【' + this.empowerName + '】加入本社团？, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'success'
                }).then(() => {
                    let _this = this;
                    let data = {
                        data: {
                            "orgID": sessionStorage.getItem("orgID"),
                            "userID": this.empowerID,
                            "signupID" : this.signupID,
                        }
                    };
                    this.$axios.post("/empowerOrg", JSON.stringify(data))
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
                                _this.$router.push("/test6");
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });

                }).catch(() => {
                    this.$notify.warning({
                        showClose: false,
                        duration: 1500,
                        message: '已取消'
                    });
                });
            },
            handleSelectionChange(val) {
                this.manyUseID = [];
                this.multipleSelection = val;
                this.manyCount = val.length;
                for(let i=0; i<val.length; i++){
                    this.manyUseID.push(val[i].userid);
                }
            },
            opensendMany(){
                this.manyForm = {type:"通知"};
                this.dialogmanyFormVisible = true

            },
            manysend(){
                if(this.manyForm.manytext == null || this.manyForm.manytext.length > 100 ||this.manyForm.manytext.length <1){
                    return false;
                }if(this.manyForm.manytitle == null || this.manyForm.manytitle.length > 10 ||this.manyForm.manytitle.length <1){
                    return false;
                }
                let _this = this;
                let data = {
                    data:{
                        "msg":this.manyForm,
                        "ReceiveID":this.manyUseID,
                        "userID": sessionStorage.getItem('userID'),
                    }
                };
                this.$axios.post("/sendManyMessage",JSON.stringify(data))
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
                            _this.dialogmanyFormVisible = false;
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            },
        },
        created() {
            let _this = this;
            let data = {
                data:{
                    "orgID": sessionStorage.getItem('orgID'),
                }
            };
            this.$axios.post("/findsignUpUser",JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.usersList = response.data.data.usersList;
                        _this.userCount = _this.usersList.length;
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
  #SignupMembers {
    width: 100%;
    margin: 10px auto;
  }

  #SignupMembers_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }
</style>
