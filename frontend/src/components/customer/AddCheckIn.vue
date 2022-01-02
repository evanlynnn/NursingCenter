<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <br><el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="请选择用户" prop="ruleForm.user.name" >
          <el-col :span="8">
            <el-select v-model="ruleForm.user.userId"  placeholder="请选择用户">
              <el-option v-for="(item, index) in userInfo" :key="index"
                         :label="item.name" :value="item.userId" @change="$forceUpdate()"/>
            </el-select>
          </el-col>
        </el-form-item>
        <el-form-item label="请选择房间" prop="ruleForm.bed.roomNumber" >
          <el-col :span="8">
            <el-select v-model="ruleForm.bed.bedId"  placeholder="请选择房间">
              <el-option v-for="(item, index) in bedInfo" :key="index"
                         :label="item.roomNumber" :value="item.bedId" @change="$forceUpdate()"/>
            </el-select>

          </el-col>
        </el-form-item>

        <el-form-item label="联系方式"  prop="contactTel">
          <el-col :span="8">
            <el-input v-model="ruleForm.contactTel"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="日期选择" >
          <el-date-picker
              v-model="ruleForm.checkinDate"
              type="date"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="OnSubmit">新增</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
          <el-button @click="returnQueryPage">返回</el-button>
        </el-form-item>
      </el-form>
      </div>
    </el-card></div>
</template>

<script>
import axios from "axios";

export default {
  name: 'AddCheckin',
  data() {
    return {
      ruleForm: {
        checkinId: '',
        user: {
          userId:'',
          name:'',
          age: '',
          idCard: '',
          status: ''},
        bed:{
          bedId:'',
          roomNumber:'',
          bedStatus:'',
          bedNumber:''
        },
        contactTel:"",
        checkinDate:''
      },
      // },
      userInfo:[],
      bedInfo:[]
    };
  },created() {
    this.searchUser()
    this.searchBed()
  },
  methods: {
    searchUser(){
      let path = 'http://localhost:8081/user/selAll';
      axios.get(path).then(res => {
        console.log(res)
        this.userInfo = res.data
        console.log(this.userInfo)
      })
    },
    searchBed(){
      let path = 'http://localhost:8081/bed/selAll';
      axios.get(path).then(res => {
        console.log(res)
        this.bedInfo = res.data
        console.log(this.bedInfo)
      })
    },
    OnSubmit(){


      console.log(this.ruleForm)
      let path="http://localhost:8081/checkin/Add"
      axios.post(path,this.ruleForm).then(res=> {
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
    returnQueryPage(){
      this.$router.push('/main/checkin')
    }
  }
}
</script>

<style scoped>

</style>