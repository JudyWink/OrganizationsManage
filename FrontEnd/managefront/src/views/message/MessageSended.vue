<template>
  <div id="MessageSended_box">
    <div id="MessageSended">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false>
        <template slot="empty">
          你还没发送过消息
        </template>
        <el-table-column
          type="selection"
          width="80px">
        </el-table-column>
        <el-table-column
          prop="messagecreatetime"
          label="发送时间"
          sortable
          :formatter="dateFormat"
        >
        </el-table-column>
        <el-table-column
          prop="messagetitle"
          label="消息主题"
          width="350px">
          <template slot-scope="scope">
            <el-dialog ref="dialog"  width="700px" :visible.sync="dialogFormVisible">
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
              </el-form>
            </el-dialog>
            <el-link icon="el-icon-view" @click="openMsg(scope.row)" type="primary">{{ scope.row.messagetitle }}</el-link>
          </template>
        </el-table-column>
        <el-table-column
          prop="messagetype"
          label="消息分类">
        </el-table-column>
        <el-table-column
          label="接收人"
          prop="messagelaunchname">
        </el-table-column>
        <el-table-column
          prop="messagestatus"
          label="状态">
        </el-table-column>
        <el-table-column
          prop="messagereadtime"
          label="阅读时间"
          :formatter="dateFormat"
        ></el-table-column>
      </el-table>
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
        name: "Document",
        data() {
            return {
                tableData: [],
                dialoMessagetitle:"",
                dialogMessagetext:"",
                dialogFormVisible:false,
            }
        },
        methods:{
            dateFormat(row, column){
                let date = row[column.property]
                if (date == undefined) {
                    return ''
                }
                return moment(date).format("YYYY-MM-DD hh:mm")
            },
            openMsg(value){
                this.dialogFormVisible = true;
                this.dialoMessagetitle = value.messagetitle;
                this.dialogMessagetext = value.messagetext;
            }
        },

        created() {
            const _this = this;
            let data={
                data:{
                    "userID" :  sessionStorage.getItem("userID"),
                }
            }
            this.$axios.post('/findSendedMessages', JSON.stringify(data))
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
  #MessageSended {
    width: 100%;
    margin: 10px auto;
  }

  #MessageSended_box {
    width: 85%;
    margin: auto;
  }

</style>
