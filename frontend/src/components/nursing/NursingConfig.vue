<template>
  <div>
    <div class="divposi">
      <el-card class="box-card1">

        <el-form :inline="true" :model="formInline" class="demo-form-inline">

          <el-form-item label="查询用户"  >
            <el-input v-model="formInline.name" placeholder="用户编号" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleSearch" >查询</el-button>
          </el-form-item>

          <el-table
              :data="tableData"
              style="width: 100%">
            <el-table-column
                label="用户编号"
                prop="userId">
            </el-table-column>
            <el-table-column
                label="姓名"
                prop="name">
            </el-table-column>
            <el-table-column
                label="性别"
                prop="sex">
            </el-table-column>
            <el-table-column
                label="年龄"
                prop="age">
            </el-table-column>

            <el-table-column>

              <template slot-scope="scope">
                <el-button
                    @click="getInfo(scope.row.userId)" type="primary" round>护理信息</el-button>

              </template>

            </el-table-column>
          </el-table>

        </el-form>

      </el-card>

      <el-card class="box-card2">
        <el-table
            :data="tableData1"
            border
            style="width: 100%">
          <el-table-column
              fixed
              prop="recordId"
              label="编号"
              width="80">
          </el-table-column>
          <el-table-column
              prop="nursingId"
              label="护理编号"
              width="120">
          </el-table-column>
          <el-table-column
              prop="nursingTime"
              label="护理时间"
              width="120">
          </el-table-column>
          <el-table-column
              prop="nursingContent"
              label="护理内容"
              width="320">
          </el-table-column>
          <el-table-column
              fixed="right"
              label="操作"
              width="110">
            <template slot-scope="scope">
              <el-button
                  @click="handleEdit(scope.row.recordId)" type="primary" icon="el-icon-edit" circle></el-button>
              <el-button
                  @click="handleDelete(scope.row.recordId)" type="danger" icon="el-icon-delete" circle></el-button>
            </template>
          </el-table-column>
        </el-table>
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
      tableData1:[],
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
      let path = 'http://localhost:8081/user/selAll'
      axios.post(path,this.formInline.name).then(res=>{
        console.log(res)
        this.tableData = res.data
        console.log(this.records)
      })
    },

    handleEdit(row){
      console.log(row)
      this.$router.push('/main/CustomizeNursingEdit/')
    },


    handleAdd(){
      this.$router.push('/main/CustomizeNursingAdd')
    },

    handleDelete(nursingId) {
      console.log('nursingid:',nursingId)

      let path = 'http://localhost:8081/nursingrecord/del/' + nursingId
      axios.get(path).then(res=>{
        if(res.data === 'success'){
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          this.getInfo()
        }
      })
    },

    getInfo(userId){
      let path = 'http://localhost:8081/nursingrecord/queryById/'
      axios.post(path + userId).then(res=>{
        console.log(res)
        this.tableData1 = [res.data]
        console.log('tabledate',this.tableData1)
      })



    },
    handleSearch(){
      let path = 'http://localhost:8081/user/queryById/'
      axios.post(path + this.formInline.name).then(res=>{
        console.log(res)
        this.tableData = [res.data]
        console.log(this.tableData)
      })
    },
  }
}
</script>

<style scoped>
.box-card1 {

  width: 600px;
  margin-right:200px;
  position:absolute;  top:100px; left:100px;
}
.box-card2 {
  width: 700px;
  margin-right:50px;
  position:absolute;  top:100px; right:0px;
}



</style>