<template>
  <div id="havaOrgUsers_box">
    <div id="havaOrgUsers">
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
          width="130px"
          prop="username">
          <template slot-scope="scope">
            <el-link  @click="openUser(scope.row)" type="primary">{{ scope.row.username }}</el-link>
            <el-dialog ref="dialog"  :close-on-click-modal="false"  width="700px" :visible.sync="dialogFormVisible">
              <el-form :model="Form" :rules="fromrules">
                <el-form-item>
                  <h2>向【{{department}}】[{{position}}]<span style="color:red">{{Name}}</span>发送消息</h2>
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
        <el-table-column
          label="组织"
          prop="orgName"
          width="220px">
        </el-table-column>
        <el-table-column
          label="部门"
          prop="department"
          width="150px">
        </el-table-column>
        <el-table-column
          label="职位"
          prop="position"
          width="120px">
        </el-table-column>
        <el-table-column
          prop="phone"
          label="联系方式"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="joinTime"
          label="入团时间"
          width="200px"
          :formatter="dateFormat">
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
              size="mini"
              type="danger"
              @click="fire">踢出
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
<!--    <span style="float: left">-->
<!--            选中:-->
<!--      <el-tag size="mini">{{this.multipleSelection.length}}</el-tag>-->
<!--      名成员-->
<!--      <el-button type="success" size="mini" @click="sendMessage">一键通知</el-button>-->
<!--    </span>-->
<!--    <span style="float: right">-->
<!--      共<el-tag size="mini">{{this.membersCount}}</el-tag>人-->
<!--    </span>-->
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';
    import moment from 'moment'
    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        data() {
            return {
                membersCount:"",
                dialogFormVisible:false,
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
                Name:"",
                department:"",
                position:"",
                ReceiveID:"",
                tableData: [],
                multipleSelection: [],
            }
        },
        methods: {
            dateFormat(row, column){
                let date = row[column.property]
                if (date == undefined) {
                    return ''
                }
                return moment(date).format("YYYY-MM-DD")
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
            sendMessage(value) {
                this.Form = {type:"通知"};
                this.Name = value.username;
                this.department = value.department;
                this.position = value.position;
                this.dialogFormVisible = true;
                this.ReceiveID = value.userid;
                this.dialogFormVisible = true
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
        },
        created() {
            let _this = this;
            this.$axios.post("/findhaveOrgAllUsers")
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.tableData =  response.data.data.tableData;
                        _this.membersCount = response.data.data.membersCount;
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
  #havaOrgUsers {
    width: 100%;
    margin: 10px auto;
  }

  #havaOrgUsers_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }

</style>
