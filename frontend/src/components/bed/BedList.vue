<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>床位管理</span>
      </div>
      <div class="text item">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item label="床位号">
            <el-input v-model="formInline.bedNumber" placeholder="请输入"></el-input>
          </el-form-item>
          <el-form-item label="床位状态">
            <el-select v-model="formInline.bedStatus" placeholder="床位状态">
              <el-option label="----请选择----" value=""></el-option>
              <el-option label="空闲" value="0"></el-option>
              <el-option label="占用" value="1"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button type="primary" @click="handleAdd">新增</el-button>
          </el-form-item>
        </el-form>
        <el-table
            :data="records"
            border
            style="width: 100%">
          <el-table-column
              prop="bedId"
              label="序号"
              width="150">
          </el-table-column>
          <el-table-column
              prop="roomNumber"
              label="房间号"
              width="250">
          </el-table-column>
          <el-table-column
              prop="bedNumber"
              label="床位号"
              width="250">
          </el-table-column>
          <el-table-column
              prop="bedStatus"
              label="床位状态"
              width="250"
              :formatter="formatRole"
              :show-overflow-tooltip="true">
          </el-table-column>
          <el-table-column
              label="操作">
            <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit" circle @click="handleUpdate(scope.row.bedId)"></el-button>
              <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete(scope.row.bedId)"></el-button>

              <el-popover
                  placement="right"
                  width="500"
                  style="margin-left: 10px"
                  trigger="hover">
                <el-table :data="gridData">
                  <el-table-column width="150" property="date" label="入住日期"></el-table-column>
                  <el-table-column width="100" property="name" label="姓名"></el-table-column>
                  <el-table-column width="100" property="sex" label="性别"></el-table-column>
                  <el-table-column width="150" property="tel" label="电话"></el-table-column>
                  <el-table-column width="250" property="idCard" label="身份证号"></el-table-column>
                  <el-table-column width="250" property="address" label="家庭地址"></el-table-column>
                </el-table>
                <el-button type="warning" icon="el-icon-search" slot="reference">查看床位信息</el-button>
              </el-popover>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>


  </div>
</template>

<script>

import axios from "axios";

export default {
  name: 'BedList',
  data() {
    return {
      gridData: [{
        date: '2021-12-30',
        name: 'nino',
        sex: '男',
        tel: '123456789',
        idCard: '321088200103215555',
        address: '江苏理工学院'
      }],
      formInline: {
        bedId: '',
        bedNumber: '',
        bedStatus: ''
      },
      records: []
    }
  },
  created() {
    console.log('aaa')
    //从服务器取需要显示的数据

    this.getData()
  },
  methods: {
    getData() {
      let path = 'http://localhost:8081/bed/selAll'
      axios.post(path, this.formInline).then(res => {
        console.log(res)
        this.records = res.data
        console.log(this.records)
      })
    },
    formatRole: function (row) {
      return row.bedStatus == '1' ? "占用" : row.bedStatus == '0' ? "空闲" : "暂无";
    },
    handleAdd() {
      this.$router.push('/main/bedAdd')
    },
    handleDelete(id) {
      console.log(id)
      let path = 'http://localhost:8081/bed/delete/' + id
      axios.post(path).then(res => {
        console.log(res.data)
        if (res.data === 1) {
          this.$message({
            message: '删除成功',
            type: 'success'
          });
        }
        this.getData()
      })
    },
    handleUpdate(id) {
      console.log(id)
      this.$router.push('/main/bedUpdate/' + id)
    },
    onSubmit() {
      this.getData()
    }
  }
}
</script>

<style scoped>

</style>