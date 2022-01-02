<template>
  <div>
    <br><br>
    <!-- 规则检测表单   -->
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-card shadow="hover">
        <el-form-item label-width="75px">
          <i className="el-icon-user" id="login" style="font-size: 80px"></i>
        </el-form-item>
        <el-form-item label="登录" prop="" label-width="40px">
          <el-input type="text" v-model="form.adminRname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass" label-width="40px">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label-width="80px">
          <el-button type="primary" round @click="onSubmit">登录</el-button>
        </el-form-item>
      </el-card>
    </el-form>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  data() {
    //判断密码状态
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };

    return {
      form: {
        adminRname: '',
        password: ''
      },
      ruleForm: {
        pass: '',
        checkPass: ''
      },
      rules: {
        pass: [
          {validator: validatePass, trigger: 'blur'}
        ]
      }, mess: ''
    };
  },
  methods: {
    Notify(name) {
      this.$notify({
        title: '欢迎回来！',
        message: '管理员' + name,

      });
    },
    //登录
    onSubmit() {
      this.form.password = this.ruleForm.pass
      let path = "http://localhost:8081/admin/login"
      axios.post(path, this.form).then(res => {
        this.mess = res.data
        console.log(res.data)
        if (res.data === 'success') {
          this.$message({
            message: '登录成功',
            type: 'success'
          })
          this.Notify(this.form.adminRname)
          this.$router.push("/main")
        } else {
          this.$message({
            message: '登陆失败',
            type: 'error'
          })
        }
      })
    }
  }
}
</script>
<style scoped>

form {
  display: flex;
  justify-content: center;
}
</style>