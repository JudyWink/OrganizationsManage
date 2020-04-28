<template>
  <div id="publishActivities_box">
    <div id="publishActivities">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item>
          <span id="top"><h1>活动发布</h1></span>
        </el-form-item>
        <el-form-item label="活动名称" prop="activitityName">
          <el-input v-model="ruleForm.activitityName"></el-input>
        </el-form-item>
        <el-form-item label="活动地点" prop="activitityPlace">
            <el-input v-model="ruleForm.activitityPlace"></el-input>
        </el-form-item>
        <el-form-item label="活动时间" required>
          <el-col :span="11">
            <el-form-item prop="activitityStartTime">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.activitityStartTime" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="activitityEndTime">
              <el-date-picker type="date" placeholder="选择时间" v-model="ruleForm.activitityEndTime" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="活动允许人数" prop="activititysCount">
          <el-input v-model="ruleForm.activititysCount"></el-input>
        </el-form-item>
        <el-form-item label="活动类型" prop="activitityType">
            <el-radio-group v-model="ruleForm.activitityType">
              <el-radio label="招新" ></el-radio>
              <el-radio label="娱乐"></el-radio>
              <el-radio label="讲座"></el-radio>
              <el-radio label="会议"></el-radio>
            </el-radio-group>
        </el-form-item>
        <el-form-item label="活动介绍" prop="activitityDescribe">
          <el-input type="textarea" v-model="ruleForm.activitityDescribe"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="success" @click="submitForm('ruleForm')">马上发布</el-button>
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
                    activitityStartTime: '',
                    activitityEndTime: '',
                    activititysCount: '',
                    activitityType: [],
                    activitityDescribe: ''
                },
                rules: {
                    activitityName: [
                        { required: true, message: '请输入活动名称', trigger: 'blur' },
                        { min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur' }
                    ],
                    activitityPlace: [
                        { type: 'array', required: true, message: '请输入活动地点', trigger: 'blur' }
                    ],
                    activitityStartTime: [
                        { type: 'date', required: true, message: '请选择日期', trigger: 'blur' }
                    ],
                    activitityEndTime: [
                        { type: 'date', required: true, message: '请选择时间', trigger: 'blur' }
                    ],
                    activititysCount: [
                        { type: 'array', required: true, message: '请输入活动人数', trigger: 'blur' }
                    ],
                    activitityType: [
                        { required: true, message: '请选择活动类型', trigger: 'change' }
                    ],
                    activitityDescribe: [
                        { type: 'array', required: true, message: '请输入活动介绍', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
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
    height: 550px;
    width: 80%;
    margin: auto;
    background-color: white;

  }

  #top {
    color: 	#1E90FF;
    font-family:STHupo;
  }

</style>
