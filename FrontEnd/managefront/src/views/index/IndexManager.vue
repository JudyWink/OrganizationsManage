<template>
  <div id="IndexManager_box">
    <div id="IndexManager">
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        list-type="picture">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
    </div>
  </div>
</template>

<script>
    export default {
        name: "IndexManager",
        data() {
            return {
                fileList: [{
                    name: 'index1.jpg',
                    url: require('../../assets/img/index/1.jpg')
                }, {
                    name: 'index2.jpg',
                    url: require('../../assets/img/index/2.jpg')
                },
                    {
                        name: 'index3.jpg',
                        url: require('../../assets/img/index/3.jpg')
                    }]
            };
        },
        methods: {
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
  #IndexManager_box {
    margin: auto;
    width: 50%;
    height: auto;
    position: center;
    margin-top: 50px;
    background-color: white;
  }

  #IndexManager {
    width: 80%;
    margin: auto;
  }

</style>
