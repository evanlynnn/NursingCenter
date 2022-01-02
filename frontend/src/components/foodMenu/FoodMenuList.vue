<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>定制膳食</span>

        <!--Toolbar-->
        <div class="food-toolbar">
          <el-form :inline="true" class="demo-form-inline">
            <el-form-item label="客户姓名">
              <el-select v-model="queryForm.user" placeholder="请选择用餐人">
                <el-option v-for="(item, index) in userData" :key="index"
                           :label="item.name" :value="item.userId" @change="$forceUpdate()"/>
              </el-select>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="handleQuery">查询</el-button>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" icon="el-icon-plus" @click="jumpToAddMenuPage">新增</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>

      <!--Table-->
      <div class="text item">
        <template>
          <el-table
              :data="foodMenuList"
              stripe
              style="width: 100%">
            <el-table-column
                label="序号"
                type="index"
                width="50">
            </el-table-column>
            <el-table-column
                label="膳食名称"
                width="400">
              <template slot-scope="scope">
                {{ scope.row.food.name }}
              </template>
            </el-table-column>
            <el-table-column
                label="用餐时段"
                width="200"
            >
              <template slot-scope="scope">
                {{ scope.row.eatingTime }}
              </template>
            </el-table-column>
            <el-table-column
                label="用餐日期"
                width="200">
              <template slot-scope="scope">
                {{ scope.row.week | formatWeek }}
              </template>
            </el-table-column>

            <el-table-column
                label="用餐人"
                width="200">
              <template slot-scope="scope">
                {{ scope.row.user.name}}
              </template>
            </el-table-column>

            <el-table-column
                label="操作"
            >
              <template slot-scope="scope">
                <el-button type="primary" icon="el-icon-edit" @click="handleEdit(scope.row.menuId)" circle></el-button>
                <el-button type="primary" icon="el-icon-delete" @click="handleDelete(scope.row.menuId)" circle></el-button>
              </template>
            </el-table-column>
          </el-table>
        </template>
      </div>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FoodMenuList",
  data() {
    return {
      menuQueryForm: {
        name: '',
      },
      foodMenuList: {},
      userData: {},
      queryForm: {},

    }
  },
  created() {
    this.getMenuList()
    this.getUserData()
  },
  methods: {
    getMenuList() {
      axios.get('http://localhost:8081/foodMenu/list')
          .then((response) => {
            this.foodMenuList = response.data
            console.log(this.foodMenuList)
          })
    },
    getUserData() {
      axios.get('http://localhost:8081/user/selbystatus/1')
          .then((response) => {
            this.userData = response.data
            console.log("userData:", this.userData)
          })
    },
    handleQuery() {
      console.log('form', this.queryForm)
      // Change the food id into food object
      this.queryForm.user = this.userData.find(user => user.userId === this.queryForm.user)
      console.log('form:', this.queryForm)

      axios.post('http://localhost:8081/foodMenu/query', this.queryForm)
          .then((response) => {
            let result = response.data
            console.log("response:", response.data)
            if (result.length === 0) {
              this.$message.error("没有查到相关膳食定制记录")
            } else {
              this.$message.success("查询成功")
              this.foodMenuList = result
            }

          })
    },
    jumpToAddMenuPage() {
      this.$router.push('/main/addFoodMenu')
    },
    handleDelete(id) {
      console.log('delete:', id)
      axios.post('http://localhost:8081/foodMenu/delete/' + id)
          .then((response) => {
            if (response.data === true) {
              this.$message.success("删除生成")
              this.getMenuList()
            } else {
              this.$message.error("添加失败")
            }
          })
          .catch(err => console.log(err))
    },
    handleEdit(id) {
      console.log('edit:', id)
      this.$router.push('/main/editFoodMenu/' + id)
    },
  },
  filters: {
    formatWeek(day) {
      console.log('day:', day)
      let representation = ''
      switch (day) {
        case 1:
          representation = '星期一';
          break;
        case 2:
          representation = '星期二';
          break;
        case 3:
          representation = '星期三';
          break;
        case 4:
          representation = '星期四';
          break;
        case 5:
          representation = '星期五';
          break;
        case 6:
          representation = '星期六';
          break;
        case 7:
          representation = '星期天';
          break;
      }
      return representation
    }
  }
}
</script>

<style scoped>
.food-toolbar {
  display: inline-block;
  position: absolute;
  right: 20px;
  top: 68px;
}
</style>