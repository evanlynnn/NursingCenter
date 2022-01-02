<template>
  <div>
    <el-card class="box-card">
    <div style="margin: 20px;"></div>
    <el-form label-width="60px" :model="form">
      <el-form-item label="名称">
        <el-input v-model="form.nursingName"></el-input>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.description"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="form.servicePrice"></el-input>
      </el-form-item>
      <el-button type="success" @click="handleAdd" >提交</el-button>
    </el-form>
    </el-card>>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CustomizeNursingAdd",
  data() {
    return {
      form: {
        nursingId: '',
        nursingName: '',
        description: '',
        servicePrice:'',
      }
    };
  },
  methods:{
    handleAdd(){
      console.log(this.form)
      let path = 'http://localhost:8081/nursing/add'
      axios.post(path,this.form).then(res=>{
        if(res.data === 'success'){
          this.$message({
            message: '添加成功',
            type: 'success'
          });
        }
      })
    }
  }
}
</script>

<style scoped>
.box-card{
  width: 600px;
  margin:0 auto;
}

</style>