<template xmlns:c="http://www.w3.org/1999/html">
  <div id="myPushActs_box">
    <div id="myPushActs">
      <div>
        <div>
          <el-select @change="change(value)" v-model="value" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.activitiesid"
              :label="item.actname"
              :value="item.activitiesid"
            >
            </el-option>
          </el-select>
        </div>
        <div v-if="activitityname == ''"><el-tag class="top_tag" effect="dark" type="danger">选一个你发布的活动吧！</el-tag></div>
      </div>
      <div v-if="activitityname != ''">
        <el-tag class="top_tag" effect="dark" type="danger">{{activitityname}}</el-tag>
        <el-steps :active=active align-center finish-status="success">
          <el-step title="活动准备" :description= this.description.start ></el-step>
          <el-step title="活动报名" :description="this.description.signUp"></el-step>
          <el-step title="活动进行" :description="this.description.doing"></el-step>
          <el-step title="活动结束" :description="this.description.end"></el-step>
        </el-steps>
        <br>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动名称:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityname}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动地点:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityPlace}}</span></div></el-col>

          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动类型:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityType}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动允许人数:</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple-light"><span class="spanText">{{count}}/{{activititysCount}}</span></div></el-col>

        </el-row>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">举办社团:</span></div></el-col>
          <el-col :span="6"><div class="grid-content bg-purple-light"><span class="spanText">{{orgName}}</span></div></el-col>
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动时间:</span></div></el-col>
          <el-col :span="12"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityStartTime|dateFormat}}==={{activitityEndTime|dateFormat}}</span></div></el-col>
        </el-row>
        <el-row class="row">
          <el-col :span="3"><div class="grid-content bg-purple"><span class="span">活动描述:</span></div></el-col>
          <el-col :span="21"><div class="grid-content bg-purple-light"><span class="spanText">{{activitityDescribe}}</span></div></el-col>
        </el-row>
        <div><el-tag class="middle_tag" effect="dark" type="success" @click="openalready">报名的学生</el-tag></div>
        <div v-if="isalready">
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
            width="130px"
            prop="username">
            <template slot-scope="scope">
              <el-link @click="openUser(scope.row)" type="primary">{{ scope.row.username }}</el-link>
            </template>
          </el-table-column>
            <el-table-column
              label="社团"
              prop="orgname"
              width="210px">
            </el-table-column>
          <el-table-column
            label="学院"
            prop="useracademy"
            width="180px">
          </el-table-column>
          <el-table-column
            label="班级"
            prop="userclass"
            width="150px">
          </el-table-column>
          <el-table-column
            prop="userphone"
            label="联系方式"
            width="130px">
          </el-table-column>
          <el-table-column
            prop="usernumber"
            label="学号"
            width="130px">
          </el-table-column>
            <el-table-column
              prop="Sinuptime"
              label="报名时间"
              :formatter="dateFormat"
              width="150px">
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
                type="danger"
                size="mini"
                @click="fire(scope.row)">移除
              </el-button>
              <el-dialog ref="dialog"  :close-on-click-modal="false"  width="700px" :visible.sync="dialogFormVisible">
                <el-form :model="Form" :rules="fromrules">
                  <el-form-item>
                    <h2>向用户<span style="color:red">{{Name}}</span>发送消息</h2>
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
                  <el-form-item>
                    <el-button  type="primary" @click="send">发 送</el-button>
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
          <span style="float: left">
            选中:
      <el-tag size="mini">{{this.multipleSelection.length}}</el-tag>
      名成员
      <el-button type="success" size="mini" @click="opensendMany">一键通知</el-button>
    </span>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
    import moment from 'moment'
    import elTableInfiniteScroll from 'el-table-infinite-scroll';

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        data() {
            return {
                options: [],
                value: '',
                description:{
                    start:"开始",
                    signUp:"报名",
                    doing:"进行",
                    end:"结束"
                },
                active: "",
                activitityname:"",
                orgName:"",
                activitityType:"",
                activititysCount:"",
                activitityPlace:"",
                activitityStartTime:"",
                activitityEndTime:"",
                activitityDescribe:"",
                activityID:"",
                isalready:false,
                count:0,
                usersList:[],
                dialogFormVisible: false,
                Name:'',
                Form: {
                    title: "",
                    text: "",
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
                membersCount:"",
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

            change(value) {
                this.isalready = false;
                this.activityID = value;
                let _this = this;
                let data = {
                    data: {
                        "activityID": value,
                        "userID": sessionStorage.getItem("userID"),
                    }
                }
                this.$axios.post('/findOneActivity', JSON.stringify(data))
                    .then(function (response) {
                        if (response.data.code == 0) {
                            _this.activitityname = response.data.data.activitityInfo.activitityname;
                            _this.orgName = response.data.data.activitityInfo.orgname;
                            _this.activititysCount = response.data.data.activitityInfo.activitityscount;
                            _this.activitityType = response.data.data.activitityInfo.activititytype;
                            _this.activitityPlace = response.data.data.activitityInfo.activitityplace;
                            _this.activitityStartTime = response.data.data.activitityInfo.activititystarttime;
                            _this.activitityEndTime = response.data.data.activitityInfo.activitityendtime;
                            _this.activitityDescribe = response.data.data.activitityInfo.activititydescribe;
                            _this.active = parseInt(response.data.data.activitityInfo.activititystatus);
                            _this.count = response.data.data.count;
                            console.log(response.data.msg);
                        }
                        if (response.data.code == 1) {
                            _this.$notify.warning({
                                message: response.data.msg,
                                showClose: false,
                                duration: 1500,
                            });
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    });
            },
            openalready(){
                if(this.isalready === true){
                    this.isalready = false;
                }else if(this.isalready === false){
                    this.isalready = true;
                }
                let _this = this;
                let data = {
                    data: {
                        "activityID": this.activityID,
                    }
                }
                this.$axios.post("/findSingupStudents",JSON.stringify(data))
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

            sendMessage(value) {
                this.Form = {type:"通知"};
                this.Name = value.username;
                this.dialogFormVisible = true;
                this.ReceiveID = value.userid;
            },
            send(){
                if(this.Form.text == null || this.Form.text.length > 100 ||this.Form.text.length <1){
                    return false;
                }if(this.Form.title == null || this.Form.title.length > 10 ||this.Form.title.length <1){
                    return false;
                }
                let _this = this;
                let data = {
                    data:{
                        "msg":this.Form,
                        "ReceiveID":this.ReceiveID,
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

            fire(value){
                this.$confirm('是否要把['+value.username+']移除出本活动, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let _this = this;
                    let data = {
                        data: {
                            "relationid": value.relationid,
                        }
                    };
                    this.$axios.post("/fireFromActivity",JSON.stringify(data))
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
                                _this.$router.push("/test4");
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
        filters:{
            dateFormat:function(value){
                return moment(value).format("YYYY-MM-DD HH:mm")
            },
        },
        created() {
            let _this = this;
            let data = {
                data: {
                    "orgID": sessionStorage.getItem("orgID"),
                }
            }
            this.$axios.post('/findMyPushActivities', JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 0) {
                        console.log(response.data.msg);
                        _this.options = response.data.data.ActivitiesList;
                    }
                    if (response.data.code == 1) {
                        console.log(response.data.msg);
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        }


    }
</script>

<style>

  .top_tag{
    margin-top: 10px;
    margin-bottom: 20px;
    width: 200px;
  }

  .middle_tag{
    margin-top: 40px;
    margin-bottom: 10px;
    width: 200px;
  }

  #myPushActs {
    width: 100%;
    margin-top: 30px;
  }

  #myPushActs_box {
    height: 420px;
    width: 85%;
    margin: auto;
    background-color: white;
  }

  .bg-purple {
    background:#409EFF;
  }
  .bg-purple-light {
    background:	#E4E7ED;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row{
    width: 80%;
    margin: auto;
    margin-top: 30px;
  }
  .span{
    line-height:36px;
    color: white;
  }

  .spanText{
    line-height:36px;
    color: black;
  }


</style>
