<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <br>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px" class="demo-ruleForm">

          <el-form-item label="姓名" prop="name">
            <el-col :span="8">
              <el-input v-model="ruleForm.name"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="身份证号" prop="idCard">
            <el-col :span="8">
              <el-input v-model="ruleForm.idCard"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item type="age" label="年龄" prop="age">
            <el-col :span="8">
              <el-input v-model="ruleForm.age"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="性别" prop="sex">
            <el-select v-model="ruleForm.sex" placeholder="请选择性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="入住状态" prop="status">
            <el-select v-model="ruleForm.status" placeholder="请选择状态">
              <el-option label="未入住" value="0"></el-option>
              <el-option label="已入住" value="1"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="OnSubmit">新增</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
            <el-button @click="returnQueryPage">返回</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'AddCustomer',
  data() {
    return {
      ruleForm: {
        name: '',
        sex: '',
        age: '',
        idCard: '',
        status: '',
      },
      rules: {
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
        ],
        age: [
          {required: true, message: '请输入年龄', trigger: 'blur'},
        ],
        sex: [
          {required: true, message: '请选择性别', trigger: 'change'}
        ], status: [
          {required: true, message: '请选择入住状态', trigger: 'change'}
        ], idCard: [
          {required: true, message: '请输入身份证号', trigger: 'blur'},
          {min: 18, max: 18, message: '身份证号不符合标准', trigger: 'blur'}
        ],


      }
    };
  },
  methods: {
    OnSubmit() {
      console.log(this.ruleForm)
      let path = "http://localhost:8081/user/Add"
      axios.post(path, this.ruleForm).then(res => {
        if (res.data === 'success') {
          this.$message({
            message: '添加成功',
            type: 'success'
          });
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //返回查询页面
    returnQueryPage() {
      this.$router.push('/main/customer')
    }
  }
}
</script>

<style scoped>

</style>