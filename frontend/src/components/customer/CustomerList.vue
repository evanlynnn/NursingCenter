<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <div>
          <el-form :inline="true" class="demo-form-inline" v-loading="loading">
            <el-col span="3">
              <el-button type="primary" @click="getData">全部</el-button>
              <el-button type="primary" @click="handleAdd()">新增</el-button>
            </el-col>
            <el-form-item label="状态">
              <el-select v-model="status" placeholder="请选择状态">
                <el-option label="未入住" value=0></el-option>
                <el-option label="已入住" value=1></el-option>
              </el-select>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" icon="el-icon-search" @click="handleQuery()">查询</el-button>
            </el-form-item>
            <el-button v-if=finish type="success" icon="el-icon-check" @click="deleteInfo()">完成删除</el-button>
            <el-button type="primary" icon="el-icon-edit" @click="updatePage()">删除</el-button>
          </el-form>
        </div>

        <el-table
            ref="multipleTable"
            :data="records"
            border
            highlight-current-row
            @current-change="handleCurrentChange"
            style="width: 100%">

          <el-table-column
              v-if=show
              type="selection"
              width="55">
          </el-table-column>
          <el-table-column
              label="序号"
              type="index"
              width="80">

          </el-table-column>

          <el-table-column
              property="name"
              label="姓名"
              width="220">
            <!-- 显示输入框     -->
            <template slot-scope="scope">
              <el-input v-model="scope.row.name" v-if="scope.row.editable"></el-input>
              <span v-if="!scope.row.editable">{{ scope.row.name }}</span>
            </template>
          </el-table-column>
          <el-table-column
              property="sex"
              label="性别"
              width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.sex" v-if="scope.row.editable" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
              <span v-if="!scope.row.editable">{{ scope.row.sex }}</span>
            </template>
          </el-table-column>
          <el-table-column
              property="age"
              label="年龄"
              width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.age" v-if="scope.row.editable"></el-input>
              <!--        <input type="text" v-model="scope.row.name" v-show="scope.row.editable" />-->
              <span v-if="!scope.row.editable">{{ scope.row.age }}</span>
            </template>
          </el-table-column>
          <el-table-column
              property="idCard"
              label="身份证号"
              width="250">
            <template slot-scope="scope">
              <el-input v-model="scope.row.idCard" v-if="scope.row.editable"></el-input>
              <!--        <input type="text" v-model="scope.row.name" v-show="scope.row.editable" />-->
              <span v-if="!scope.row.editable">{{ scope.row.idCard }}</span>
            </template>
          </el-table-column>
          <el-table-column
              property="status"
              label="入住状态"
              :formatter="formatRole"
              :show-overflow-tooltip="true"
              width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.status" v-if="scope.row.editable" placeholder="请选择性别">
                <el-option label="已入住" value="1"></el-option>
                <el-option label="未入住" value="0"></el-option>
              </el-select>
              <span v-if="!scope.row.editable">{{ formatRole(scope.row) }}</span>
            </template>
          </el-table-column>
          <el-table-column
              label="操作">
            <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit" @click="edit(scope.row)">修改信息</el-button>
              <el-button type="success" icon="el-icon-check" v-if="finish2" @click="handleupdate(scope.row)">保存信息
              </el-button>
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
  name: 'CustomerList',
  data() {
    return {
      //加载变量
      loading: false,
      //隐藏变量
      show: false,
      finish: false,
      finish2: false,
      //数据变量
      records: [],
      userInfo: [],
      //搜索状态变量
      status: "",
      //打开关闭删除页面
      openStatus: 1,

    }
  }, created() {
    this.getData()
    this.Addiseditor()
  }
  , methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    getData() {
      let path = 'http://localhost:8081/user/selAll';
      axios.get(path).then(res => {
        console.log(res)
        this.records = res.data
        console.log(this.records[0].userId)
      })
    },//生成与获取行数相同的可编辑属性
    Addiseditor() {
      setTimeout(() => {
        Object.keys(this.records).forEach(item => {

          this.records[item].editable = false
        })
        console.log(this.records)
      }, 20)
    },
    //改变editable值来打开关闭修改
    edit(row) {
      row.editable = true;
      this.finish2 = true
      console.log(row)

    },
    save(row) {
      row.editable = false;
      this.finish2 = false
      console.log(row)
    },
    //强制失焦
    clickHandler(row) {
      this.save(row)
      // $clearSelection
      this.$refs.multipleTable.setCurrentRow()
    },//上传数据
    handleupdate(row) {
      this.clickHandler(row);

      console.log(row)
      let path = "http://localhost:8081/user/update"
      axios.post(path, row).then(res => {
        if (res.data === 'success') {
          this.$message({
            message: '更新成功',
            type: 'success'
          });
        }
      })
    },

    //打开修改和多选框
    updatePage() {
      if (this.openStatus === 1) {
        this.openStatus = 0
        this.show = true
        this.finish = true
      } else {
        this.openStatus = 1
        this.show = false
        this.finish = false
      }
      console.log(this.show)
      //关闭修改与多选框
    }, updateChange() {
      this.userInfo = this.$refs.multipleTable.selection
      console.log(this.$refs.multipleTable.selection)
      this.show = false
      this.finish = false
    },
    //删除信息
    deleteInfo() {
      this.updateChange()
      let length = this.userInfo.length
      let i = 0
      for (i = 0; i < length; i++) {
        let id = this.userInfo[i].userId
        let path = "http://localhost:8081/user/del/" + id
        axios.get(path).then(res => {
          if (res.data === 'success') {
            this.$message({
              message: '删除成功',
              type: 'success'
            });
          }
        })
      }
      this.loading = true
      setTimeout(() => {
        this.loading = false;
      }, 2000)
      this.getData()
    },
    //跳转Add页面
    handleAdd() {
      this.$router.push('/main/customerAdd')
    },
    //查询
    handleQuery() {
      let path = 'http://localhost:8081/user/selbystatus/' + this.status;
      axios.post(path, this.status).then(res => {
        console.log(res)
        this.records = res.data
      })
    },
    //改变0，1显示status
    formatRole: function (row) {
      return row.status === '1' ? "已入住" : row.status === '0' ? "未入住" : "无";
    }
  }

}
</script>

<style scoped>
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>