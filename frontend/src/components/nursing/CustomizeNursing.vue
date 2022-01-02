<template>
  <div>
    <div class="divposi">
      <el-card class="box-card">

        <el-form :inline="true" :model="formInline" class="demo-form-inline">

          <el-form-item label="查询项目"  >
            <el-input v-model="formInline.name" placeholder="项目编号" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleSearch" >查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="success" @click="handleAdd" >添加</el-button>
          </el-form-item>

          <el-table
              :data="tableData"
              style="width: 100%">
            <el-table-column
                label="编号"
                prop="nursingId">
            </el-table-column>
            <el-table-column
                label="名称"
                prop="nursingName">
            </el-table-column>
            <el-table-column
                label="描述"
                prop="description">
            </el-table-column>
            <el-table-column
                label="价格"
                prop="servicePrice">
            </el-table-column>

            <el-table-column>

              <template slot-scope="scope">
                <el-button
                    @click="handleEdit(scope.row.nursingId)" type="primary" icon="el-icon-edit" circle></el-button>
                <el-button
                    @click="handleDelete(scope.row.nursingId)" type="danger" icon="el-icon-delete" circle></el-button>
              </template>

            </el-table-column>
          </el-table>

        </el-form>

      </el-card>
      </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CustomizeNursing",
  data() {
    return {
      tableData: [],
      formInline:{
        name:''
      }
    }
  },
  created(){
    console.log('aaa')
    this.getData()
  },
  methods: {
    getData(){
      //从服务器取需要显示的数据
      let path = 'http://localhost:8081/nursing/selAll'
      axios.post(path,this.formInline.name).then(res=>{
        console.log(res)
        this.tableData = res.data
        console.log(this.records)
      })
    },

    handleEdit(row){
      console.log(row)
      this.$router.push('/main/CustomizeNursingEdit/' + row)
    },


    handleAdd(){
      this.$router.push('/main/CustomizeNursingAdd')
    },

    handleDelete(nursingId) {
      console.log(nursingId)
      let path = 'http://localhost:8081/nursing/del/'+nursingId
      axios.get(path).then(res=>{
        if(res.data === 'success'){
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          this.getData()
        }
      })
      },
    handleSearch(){
      let path = 'http://localhost:8081/nursing/queryById/'
      axios.post(path+this.formInline.name).then(res=>{
        console.log(res)
        this.tableData = [res.data]
        console.log(this.tableData)
      })
    },
  }
}
</script>

<style scoped>
.box-card {
  width: 800px;
  margin:0 auto;
}


</style>