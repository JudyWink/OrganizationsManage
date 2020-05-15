<template>
<div>
<div>
  <el-form :model="ruleForm" :rules="rules" ref="ruleFormRef">
    <el-form-item label="原密码" prop="pass" :label-width="formLabelWidth">
      <el-col :span="8">
        <el-input v-model="ruleForm.pass" placeholder="请输入原密码" type="password"></el-input>
      </el-col>
    </el-form-item>
    <el-form-item label="新密码" prop="newpass" :label-width="formLabelWidth">
      <el-col :span="8">
        <el-input v-model="ruleForm.newpass" placeholder="请输入新密码" id="newkey" type="password"></el-input>
      </el-col>
    </el-form-item>
    <el-form-item label="重复新密码" prop="checknewpass" :label-width="formLabelWidth">
      <el-col :span="8">
        <el-input v-model="ruleForm.checknewpass" placeholder="请再次输入新密码" id='newkey1' type="password"></el-input>
      </el-col>
    </el-form-item>
  </el-form>
</div>
  <div class="grid-content bg-purple">
    <el-button type="primary"  @click="submitForm('ruleFormRef')">保存</el-button>
  </div>
</div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: [{
                    pass: '',
                }],
            }
        }
    }
</script>

<style scoped>

</style>
