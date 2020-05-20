<template>
  <div id="Uploaddocument_box">
    <div id="Uploaddocument">
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
                width="150px"
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
                  <el-button
                    size="mini"
                    type="danger"
                    @click="deleteDocument(scope.row)">删除
                  </el-button>
                </template>
              </el-table-column>

            </el-table>
            <span style="float: right">
            共<el-tag size="mini">{{this.documentCount}}</el-tag>个
          </span>
    </div>

    <div>
      <el-upload
        class="upload-demo"
        action="http://baidu.com"
        :before-upload="beforeUpload"
        multiple
        ref="newupload"
        :auto-upload="false">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="newSubmitForm">上传到服务器</el-button>
        <div slot="tip" class="el-upload__tip">文件大小请不要超过10Mb</div>
      </el-upload>
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
        name: "UploadDocument",
        data() {
            return {
                documentCount: 0,
                tableData: [],
                fileList: [],
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
                    })
                    .catch(function (error) {
                        console.log(error)
                    });

            },
            deleteDocument() {
                this.$message.error("删除")
            },
            newSubmitForm() {
                this.$refs.newupload.submit()
            },
            beforeUpload(file) {
                const _this = this;
                let fd = new FormData();
                fd.append('file', file);
                fd.append('userID', sessionStorage.getItem("userID"));
                fd.append('fileName', file.name);
                newVideo(fd) .then(function (response) {
                    if (response.data.code == 0) {
                        _this.$notify.success({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                        _this.$router.push("/test5");
                    }
                    if (response.data.code == 1) {
                        _this.$notify.error({
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                })
                    .catch(function (error) {
                        console.log(error)
                    });
                return true
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
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
    import axios from 'axios';
    export function newVideo (data) {
        return axios({
            method: 'post',
            baseURL: 'http://127.0.0.1:8021/uploadDocument',
            timeout:  5000,
            data: data,
            headers:{
                common:{
                    'Token' : sessionStorage.getItem('token'),
                },
                post:{
                    'Content-Type':'application/json',
                },
            }
        })
    }
</script>


<style>
  #Uploaddocument {
    width: 100%;
    margin: 10px auto;

  }

  #Uploaddocument_box {
    height: 600px;
    width: 65%;
    margin: auto;
  }

</style>
