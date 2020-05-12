<template>
  <div id="IndexManager_box">
    <div id="IndexManager">
      <el-form :model="form">
        <el-form-item>
          <el-upload
            action="http://up.imgapi.com/"
            ref="upload"
            :data="myHeaders"
            accept="image/png,image/jpg,image/jpeg"
            list-type="picture-card"
            :multiple="true"
            :limit=limitNum
            :auto-upload="false"
            :on-exceed="handleExceed"
            :before-upload="handleBeforeUpload"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :on-change="fileChange">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <el-form-item>
          <span>一次只能上传9张以内的jpeg/jpg/png文件，且一张不超过10M</span>
        </el-form-item>
        <el-form-item>
          <el-button size="small" type="success" @click="uploadFile">立即上传</el-button>
        </el-form-item>
      </el-form>
      <div>
        <el-carousel :interval="2000" :autoplay="false" type="card" height="200px">
          <el-carousel-item class="carousel-item" v-for="url in urls"  v-bind:key="url">
            <el-image @click="deleteImg(url)"
              :src=url
            ></el-image>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
  </div>
</template>

<script>
    export default {

        name: "IndexManager",
        inject:['reload'],
        data() {
            return{
                myHeaders: {
                    Token: "6191e057f3e239d7d0f3b7914eb2debd79cba8ab:3JZYx3WE0plcWDzeGCgxXXH38zU=:eyJkZWFkbGluZSI6MTU4OTEwMzk3NywiYWN0aW9uIjoiZ2V0IiwidWlkIjoiNzE4NTk3IiwiYWlkIjoiMTY4NzYxMSIsImZyb20iOiJmaWxlIn0="
                },
                dialogImageUrl: '',
                dialogVisible: false,
                limitNum: 9,
                form: {
                },
                fileList:[],
                urls: [],
            }
        },
        methods: {
            // 上传文件之前的钩子
            handleBeforeUpload(file){
                if(!(file.type === 'image/png' || file.type === 'image/jpg' || file.type === 'image/jpeg')) {
                    this.$notify.error({
                        message: '请上传格式为image/png, image/jpg, image/jpeg的图片'
                    })
                }
                let size = file.size / 1024 / 1024 / 11
                if(size > 2) {
                    this.$notify.error({
                        message: '图片大小必须小于10M'
                    })
                }
            },
            // 文件超出个数限制时的钩子
            handleExceed(files, fileList) {
                this.$notify.error(`一次只能上传9张图片，你已经选择了${files.length + fileList.length}张图片`);
                console.log(files, fileList);
            },
            // 文件列表移除文件时的钩子
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            // 点击文件列表中已上传的文件时的钩子
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            //文件改变时的钩子
            fileChange(file){
                this.fileList.push(file.raw);//上传文件变化时将文件对象push进files数组
            },

            async uploadFile() {
                if(this.fileList.length < 1){
                    this.$notify.error({
                        message: "请选择图片",
                        showClose: false,
                        duration: 1500,
                    });
                    return;
                }
                const _this = this;
                let formData = new FormData();
                formData.append("Token","6191e057f3e239d7d0f3b7914eb2debd79cba8ab:UOuHYjcYtO_kVEDj08_Ofuc0nPA=:eyJkZWFkbGluZSI6MTU4OTE4OTExNSwiYWN0aW9uIjoiZ2V0IiwidWlkIjoiNzE4NTk3IiwiYWlkIjoiMTY4NzYxMSIsImZyb20iOiJmaWxlIn0=");
                for (let i = 0; i< this.fileList.length;i++){
                     formData.delete('file');
                     formData.set('file',this.fileList[i]);
                      this.$store.commit("SB", "1");
                      await this.$axios.post('http://up.imgapi.com/', formData)
                        .then(function (response) {
                            if (response.status === 200) {
                                console.log("图片上传到贴图库成功");
                                _this.$refs.upload.clearFiles();
                                let userAccount = window.sessionStorage.getItem('userID')
                                let data = {
                                    data: {
                                        "url": response.data.linkurl,
                                        "userAccount":userAccount,
                                    }
                                }
                                _this.$store.commit("SB", "cao");
                                _this.$axios.post('/upLoadIndexImgs', JSON.stringify(data))
                                    .then(function (response) {
                                        if (response.data.code == 0) {
                                            _this.$notify.success({
                                                message: response.data.msg,
                                                showClose: false,
                                                duration: 2000,
                                            });
                                        }
                                        if (response.data.code == 1) {
                                            _this.$notify.error({
                                                message: response.data.msg,
                                                showClose: false,
                                                duration: 2000,
                                            });
                                        }
                                    })
                                    .catch(function (error) {
                                        console.log(error)
                                    });
                            }
                            if (response.status != 200) {
                                console.log("图片上传到贴图库失败")
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }
                _this.reload();
            },

            deleteImg(value){

                this.$confirm('此操作将从主页删除该图片, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let _this = this;
                    let data = {
                        data: {
                            "url": value,
                        }
                    };
                    this.$axios.post('/deleteIndexImgs', JSON.stringify(data))
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
                                _this.reload();
                            }
                        })
                        .catch(function (error) {
                            console.log(error)
                        });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },
        },
        created() {
            let _this = this;
            this.$axios.post('/findAllIndexImgs')
                .then(function (response) {
                    if (response.data.code == 1) {
                        _this.$notify.warning({
                            title: '提示',
                            message: response.data.msg,
                            showClose: false,
                            duration: 1500,
                        });
                    }
                    if (response.data.code == 0) {
                        _this.urls = response.data.data.IndexImgsUrls;
                    }
                })
                .catch(function (error) {
                    console.log(error)
                });
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
