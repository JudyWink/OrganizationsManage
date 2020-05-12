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
        width="160px"
        prop="username">
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
        <template>
          <el-button
            type="success"
            size="mini"
            @click="sendMessage">通知
          </el-button>
          <el-button
            type="primary"
            size="mini"
            @click="empower">授权
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
    <el-button type="success" size="mini" @click="sendMessage">一键授权</el-button>
    </span>
  <span style="float: right">
      共<el-tag size="mini">{{this.userCount}}</el-tag>人
    </span>
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
                multipleSelection: [],
            }
        },
        methods: {
            sendMessage() {
                this.$message.error('发通知');
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
            this.$axios.post("/findAllUsers")
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
                        console.log(_this.usersList)
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
