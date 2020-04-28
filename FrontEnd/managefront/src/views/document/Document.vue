<template>
  <div id="document_box">
    <div id="document">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%"
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
              type="danger"
              @click="downloadDocument(scope.$index)">下载
            </el-button>
          </template>
        </el-table-column>
        <el-table-column
          prop="documentDownloadCount"
          label="下载次数"
          >
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
        name: "Document",
        data() {
            return {
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
                ]
            }
        },
        methods: {
            downloadDocument(){
                this.$message.error("下载")
            }

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
    width: 85%;
    margin: auto;
  }

</style>
