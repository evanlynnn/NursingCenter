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
        <el-button type="success" @click="handleEdit" >提交</el-button>
      </el-form>
    </el-card>>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CustomizeNursingEdit",
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
  created(){
    //取传递的参数id
    let id = this.$route.params.id
    console.log(id)
    //根据主键加载数据
    let path = 'http://localhost:8081/nursing/queryById/'+id
    axios.get(path).then(res=>{
      this.form = res.data
      console.log('response:', res)
    })
  },
  methods:{
    handleEdit(){
      console.log(this.form)
      let path = 'http://localhost:8081/nursing/edit'
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