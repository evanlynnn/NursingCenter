<template>
  <div>

    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <div>
          <el-form :inline="true"  class="demo-form-inline"  v-loading="loading">

            <el-col span="3">
              <el-button  type="primary" @click="getData">全部</el-button>
              <el-button  type="primary" @click="handleAdd()">新增</el-button>
            </el-col>
            <el-form-item label="日期查询" >
              <el-date-picker
                  v-model="formInline.checkinDate"
                  type="date"
                  value-format="yyyy-MM-dd"
                  placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="el-icon-search" @click="handleQuery()">查询</el-button>
            </el-form-item>
          </el-form>
        </div>
        <el-table
            :data="records"
            border
            style="width: 100%">
          <el-table-column
              label="序号"
              prop="checkinId">
          </el-table-column>
          <el-table-column
              label="姓名"
              prop="user.name">
          </el-table-column>
          <el-table-column
              label="房间号">
            <template slot-scope="scope">
              <div slot="reference" class="name-wrapper">
                <el-tag  size="medium" >{{scope.row.bed.roomNumber}}</el-tag>
              </div>
            </template>
          </el-table-column>
          <el-table-column
              label="床位">
            <template slot-scope="scope">
              <div slot="reference" class="name-wrapper">
                <el-tag  type="warning" size="medium">{{scope.row.bed.bedNumber}}</el-tag>
              </div>
            </template>
          </el-table-column>

          <el-table-column
              label="联系电话"
              prop="contactTel">
          </el-table-column>
          <el-table-column
              label="入住日期"
          >
            <template slot-scope="scope">
              {{ scope.row.checkinDate | formatDate }}
            </template>
          </el-table-column>
          <el-table-column
              align="middle">

            <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit" circle @click="handleUpdate()"></el-button>
              <el-button type="danger" icon="el-icon-delete" circle @click="handledel(scope.row.checkinId)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script>
import {makeDate} from "../../common/js/dateformat";
import axios from "axios";

export default {
  data() {
    return {
      records:[],
      formInline:{
        checkinDate:''
      },
    }
  },
  created() {
    this.getData()
  },
  methods: {

    getData(){
      let path = 'http://localhost:8081/checkin/selAll';
      axios.get(path).then(res => {
        console.log(res)
        this.records = res.data
      })
    },//删除
    handledel(id) {
      let path = "http://localhost:8081/checkin/del/" + id
      axios.post(path,id).then(res => {
        if (res.data === 'success') {
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          this.getData()
        }
      })
    },
    handleAdd() {
      this.$router.push('/main/checkinAdd')
    },
    handleQuery(){
      let path = 'http://localhost:8081/checkin/queryByDate/';
      console.log(this.formInline.checkinDate)
      axios.post(path,this.formInline).then(res => {
        console.log(res)
        this.records = res.data
      })
    },
    //更新
    handleUpdate(){

    }
  },
  filters: {
    //格式化日期的过滤器
    formatDate(date) {
      return makeDate(date)
    }
  },

}
</script>

<style scoped>

</style>