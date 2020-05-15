<template>
  <div id="publishActivities_box">
    <div id="publishActivities">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="auto" class="demo-ruleForm">
        <el-form-item>
          <span id="top"><h1>活动发布</h1></span>
        </el-form-item>
        <el-form-item label="活动名称" prop="activitityName">
          <el-input v-model="ruleForm.activitityName"></el-input>
        </el-form-item>
        <el-form-item label="活动地点" prop="activitityPlace">
            <el-input v-model="ruleForm.activitityPlace"></el-input>
        </el-form-item>
        <el-form-item label="报名时间" required>
          <el-form-item prop="signupTime">
          <el-col :span="1">
          <el-date-picker
            v-model="ruleForm.signupTime"
            type="datetimerange"
            value-format="yyyy-MM-dd HH:mm:ss" format="yyyy-MM-dd HH:mm:ss"
            start-placeholder="报名开始日期"
            end-placeholder="报名结束日期">
          </el-date-picker>
          </el-col>
          </el-form-item>
        </el-form-item>
        <el-form-item label="活动时间" required>
          <el-form-item prop="activitityTime">
            <el-col :span="1">
              <el-date-picker
                v-model="ruleForm.activitityTime"
                value-format="yyyy-MM-dd HH:mm:ss" format="yyyy-MM-dd HH:mm:ss"
                type="datetimerange"
                start-placeholder="活动开始日期"
                end-placeholder="活动结束日期">
              </el-date-picker>
            </el-col>
          </el-form-item>
        </el-form-item>
        <el-form-item label="活动允许人数" prop="activititysCount">
          <el-input v-model.number="ruleForm.activititysCount"></el-input>
        </el-form-item>
        <el-form-item label="活动类型">
          <el-radio-group v-model="ruleForm.activitityType" >
            <el-radio  label="娱乐"></el-radio>
            <el-radio  label="讲座"></el-radio>
            <el-radio  label="比赛"></el-radio>
            <el-radio  label="公益活动"></el-radio>
            <el-radio  label="表演"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="活动介绍" prop="activitityDescribe">
          <el-input type="textarea" v-model="ruleForm.activitityDescribe"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="success" @click="submitForm()">马上发布</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
    export default {
        name: "PublishActivities",
        data() {
            return {
                radio: '招新',
                ruleForm: {
                    activitityName: '',
                    activitityPlace: '',
                    signupTime:'',
                    activitityTime: '',
                    activititysCount: '',
                    activitityType: '',
                    activitityDescribe: '',
                    orgID : '',
                },
                rules: {
                    activitityName: [
                        { required: true, message: '请输入活动名称', trigger: 'blur' },
                        { min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur' }
                    ],
                    activitityPlace: [
                        { required: true, message: '请输入活动地点', trigger: 'blur' }
                    ],
                    signupTime: [
                        { type: 'date', required: true, message: '请选择报名时间', trigger: 'blur' }
                    ],
                    activitityTime: [
                        { type: 'date', required: true, message: '请选择活动时间', trigger: 'blur' }
                    ],
                    activititysCount: [
                        { type: 'number', required: true, message: '请输入正确的活动人数' }
                    ],
                    activitityType: [
                        { required: true, message: '请选择活动类型', trigger: 'change' }
                    ],
                    activitityDescribe: [
                        { required: true, message: '请输入活动介绍', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm() {
                let _this = this
                let data ={
                    data:{
                        orgID: window.sessionStorage.getItem("orgID"),
                        Form:this.ruleForm,
                    },
                }
                this.$axios.post('/pushActivity', JSON.stringify(data))
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
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style>

  #publishActivities {
    width: 80%;
    margin: 0 auto;
  }

  #publishActivities_box {
    height: 650px;
    width: 80%;
    margin: auto;
    background-color: white;

  }

  #top {
    color: 	#1E90FF;
    font-family:STHupo;
  }

</style>
