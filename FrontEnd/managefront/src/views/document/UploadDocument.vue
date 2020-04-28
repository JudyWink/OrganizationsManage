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
          type="index"
          :index="indexMethod">
        </el-table-column>
        <el-table-column
          prop="documentUploadTime"
          label="上传时间"
        >
        </el-table-column>
        <el-table-column
          prop="documentName"
          label="文件名"
          width="450px">
        </el-table-column>
        <el-table-column
          prop="documentOwner"
          label="上传者">
        </el-table-column>
        <el-table-column
          prop="documentType"
          label="文件分类">
        </el-table-column>
        <el-table-column
          label="操作"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="downloadDocument(scope.$index)">下载
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="deleteDocument(scope.$index)">删除
            </el-button>
          </template>
        </el-table-column>
        <el-table-column
          prop="documentDownloadCount"
          label="下载次数"
        >
        </el-table-column>
      </el-table>
      <span style="float: right">
      共<el-tag size="mini">{{this.documentCount}}</el-tag>个
    </span>
    </div>

    <div>
      <el-upload
        class="upload-demo"
        ref="upload"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        :auto-upload="false">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
        <div slot="tip" class="el-upload__tip">请上传正确的文件格式，大小请不要超过5Mb</div>
      </el-upload>
    </div>
  </div>
</template>

<script>
    import elTableInfiniteScroll from 'el-table-infinite-scroll';

    export default {
        directives: {
            'el-table-infinite-scroll': elTableInfiniteScroll
        },
        name: "UploadDocument",
        data() {
            return {
                documentCount:6,
                tableData: [
                    {
                        documentUploadTime: '2016-05-02',
                        documentName: '科室借用申请表.word',
                        documentOwner: '小明',
                        documentType: '申请表',
                        documentDownloadCount:'10',
                    },
                    {
                        documentUploadTime: '2016-05-02',
                        documentName: '社团组织招新时间表.word',
                        documentOwner: '梁书记',
                        documentType: '通知',
                        documentDownloadCount:'76',
                    },{
                        documentUploadTime: '2016-05-02',
                        documentName: '测试.word',
                        documentOwner: '管理员',
                        documentType: '申请表',
                        documentDownloadCount:'2',
                    },{
                        documentUploadTime: '2016-05-02',
                        documentName: '社团负责人申请表.word',
                        documentOwner: '管理员',
                        documentType: '申请表',
                        documentDownloadCount:'138',
                    },{
                        documentUploadTime: '2016-05-02',
                        documentName: '社团管理系统使用注意事项.pdf',
                        documentOwner: '管理员',
                        documentType: '文档',
                        documentDownloadCount:'10',
                    },{
                        documentUploadTime: '2016-05-02',
                        documentName: '社团管理系统操作手册.pdf',
                        documentOwner: '管理员',
                        documentType: '文档',
                        documentDownloadCount:'80',
                    },
                ],
                fileList: [{
                    name: '测试.word',
                    url: ''
                }, {
                    name: '测试.pdf',
                    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }]
            }
        },
        methods: {
            downloadDocument(){
                this.$message.error("下载")
            },
            deleteDocument(){
                this.$message.error("删除")
            },
            submitUpload() {
                this.$refs.upload.submit();
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            }
        }
    }
</script>

<style>
  #Uploaddocument {
    width: 100%;
    margin: 10px auto;

  }

  #Uploaddocument_box {
    height: 600px;
    width: 85%;
    margin: auto;
  }

</style>
