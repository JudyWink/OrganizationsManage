<template>
  <div id="document_box">
    <div id="document">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
        height="380px"
        v-el-table-infinite-scroll
        infinite-scroll-immediate=false>
        <el-table-column
          type="index">
        </el-table-column>
        <el-table-column
          prop="documentuploadtime"
          label="上传时间"
          :formatter="dateFormat"
          width="180px"
        >
        </el-table-column>
        <el-table-column
          prop="documentname"
          label="文件名"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="username"
          label="上传者"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="documenttype"
          label="文件分类"
          width="130px">
        </el-table-column>
        <el-table-column
          prop="downloadcount"
          label="下载次数"
          width="130px"
        >
        </el-table-column>

        <el-table-column
          label="操作"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="downloadDocument(scope.row)">下载
            </el-button>
          </template>
        </el-table-column>

      </el-table>
      <span style="float: right">
            共<el-tag size="mini">{{this.documentCount}}</el-tag>个
          </span>
    </div>
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';
    import moment from 'moment'

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "Document",
        data() {
            return {
                documentCount: 0,
                tableData: [],
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

            downloadDocument(value) {
                const _this = this;
                let data = {
                    data: {
                        "documentID":value.documentid,
                        "documenturl": value.documenturl,
                        "fileName": value.documentname,
                    }
                };
                this.$axios.post("/downloadDocuments",JSON.stringify(data),{responseType: 'blob'})
                    .then(function (response) {
                        console.log(response)
                        var blob = new Blob([response.data])
                        var downloadElement = document.createElement('a');
                        var href = window.URL.createObjectURL(blob); //创建下载的链接
                        downloadElement.href = href;
                        downloadElement.download = value.documentname; //下载后文件名
                        document.body.appendChild(downloadElement);
                        downloadElement.click(); //点击下载
                        document.body.removeChild(downloadElement); //下载完成移除元素
                        window.URL.revokeObjectURL(href); //释放掉blob对象
                        _this.$router.push("/test7");
                    })
                    .catch(function (error) {
                        console.log(error)
                    });

            },
        },
        created() {
            const _this = this;
            let data = {
                data: {
                    "userID": sessionStorage.getItem("userID"),
                }
            }
            this.$axios.post("/findAllDocuments",JSON.stringify(data))
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.error({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        let tableData = response.data.data.tableData
                        console.log(response.data.msg)
                        _this.tableData = tableData
                        _this.documentCount = response.data.data.documentCount
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
        }
    }
</script>

<style>
  #document {
    width: 100%;
    margin: 10px auto;

  }

  #document_box {
    height: 600px;
    width: 65%;
    margin: auto;
  }

</style>
