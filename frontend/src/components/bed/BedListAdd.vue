<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>新增床位</span>
      </div>
      <div class="text item">
        <el-form ref="form" :model="form" label-width="80px" >
          <el-form-item label="房间号">
            <el-input v-model="form.roomNumber"></el-input>
          </el-form-item>
          <el-form-item label="床位号">
            <el-input v-model="form.bedNumber"></el-input>
          </el-form-item>
          <el-form-item label="床位状态">
            <el-select v-model="form.bedStatus" placeholder="请选择床位状态">
              <el-option label="空闲" value=0></el-option>
              <el-option label="占用" value=1></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'BedListAdd',
  data(){
    return {
      form: {
        bedNumber: '',
        roomNumber:'',
        bedStatus: ''
      }
    }
  },
  methods:{
    onSubmit(){
      console.log(this.form)
      let path = 'http://localhost:8081/bed/add'
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

</style>