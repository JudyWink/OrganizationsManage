<template>
  <div id="AllOrganizations_box">
    <div id="AllOrganizations">
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
            <el-button v-if="scope.row.orgid!= myorgID"
              type="success"
              size="mini"
                       :disabled="userType ==='游客' ? true : false"
              @click="SignUp(scope.row)">报名
            </el-button>
            <el-button v-if="scope.row.orgid== myorgID"
                       type="warning"
                       size="mini"
                       disabled
                       @click="SignUp">成员
            </el-button>
            <el-button
              type="danger"
              size="mini"
              :disabled="userType ==='游客' ? true : false"
              @click="openFeedback(scope.row)">意见反馈
            </el-button>
            <el-button
              icon="el-icon-view"
              size="mini"
              type="primary"
              @click="openOrgInfo(scope.row)">详情
            </el-button>
            <el-dialog ref="dialog"  :close-on-click-modal="false"  width="700px" :visible.sync="dialogFormVisible">
              <el-form :model="Form" :rules="fromrules">
                <el-form-item>
                  <h2>向【{{org}}】负责人[<span style="color:red">{{Name}}</span>]发送消息</h2>
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
                dialogFormVisible:false,
                Name:"",
                org:"",
                myorgID:"",
                MessageType:"",
                messageInfo:{},
                ReceiveID:"",
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
                orgsList:[],
                userType: window.sessionStorage.getItem('userType'),
                multipleSelection: [],
            }
        },
        methods: {
            SignUp(value){
                this.$confirm('是否要报名参加['+value.orgname+'], 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let _this = this;
                    let data = {
                        data: {
                            "userID": sessionStorage.getItem("userID"),
                            "orgID": value.orgid,
                        }
                    };
                    this.$axios.post("/signUpOrg",JSON.stringify(data))
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
            openFeedback(value){
                this.Form = {type:"意见反馈"};
                this.org = value.orgname;
                this.Name = value.leadername;
                this.ReceiveID = value.orgleader;
                this.dialogFormVisible = true;
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


            openOrgInfo(row) {
                sessionStorage.setItem("orgIDInfo", row.orgid);
                this.$router.push({
                        name:"OrganizationInfo",
                })

            },

            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
        },
        created() {
            this.myorgID = sessionStorage.getItem("orgID");
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
  #AllOrganizations {
    width: 100%;
    margin: 10px auto;
  }

  #AllOrganizations_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }

</style>
