<template>
  <div>
    <el-card class="box-card">
      <!--Top Toolbar-->
      <div slot="header" class="clearfix">
        <span>膳食清单</span>
        <div class="food-toolbar">
          <el-form :inline="true" class="demo-form-inline">
            <el-form-item label="膳食名称">
              <el-input placeholder="膳食名称" v-model="queryForm.name"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="handleQuery">查询</el-button>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" icon="el-icon-plus" @click="jumpToAddFoodPage">新增</el-button>
            </el-form-item>
          </el-form>

        </div>
      </div>

      <!--Content-->
      <el-row :gutter="20">
        <el-col :span="4" v-for="(food) in foodList" :key="food.foodId">
          <div class="grid-content bg-purple">
            <el-card :body-style="{ padding: '0px', 'text-align': 'center' }">
              <div class="food-image" style="padding-top: 14px">
                <!--图片大小200px-->
                <img style="height: 200px; width: auto"
                     :src="`http://localhost:8081/`+food.imgName"
                     class="image">
              </div>
              <div style="padding: 14px">
                <span>{{ food.name }}</span>
                <div class="bottom clearfix">

                  <div class="food-card-button">
                    <el-popover
                        placement="right"
                        width="400"
                        trigger="click">
                      <ul>
                        <li>碳水化合物：{{ food.cho }} 克</li>
                        <li>蛋白质：{{ food.protein }} 克</li>
                        <li>脂肪：{{ food.fat }} 克</li>
                        <li>热量：{{ food.heat }} 千卡</li>
                      </ul>

                      <el-button slot="reference" icon="el-icon-search" circle></el-button>
                    </el-popover>
                  </div>

                  <div class="food-card-button">
                    <el-button icon="el-icon-edit" @click="handleEdit(food.foodId)" circle></el-button>
                  </div>

                  <div class="food-card-button">
                    <el-button icon="el-icon-delete" @click="handleDelete(food.foodId)" circle></el-button>
                  </div>


                </div>
              </div>
            </el-card>
          </div>

        </el-col>
      </el-row>


    </el-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FoodList",
  data() {
    return {
      foodList: {},
      queryForm: {
        name: '',
      }
    }
  },
  created() {
    // Retrieve food list from server
    this.getData()
  },
  methods: {
    jumpToAddFoodPage() {
      this.$router.push('/main/addFood')
    },
    getData() {
      axios.get('http://localhost:8081/food/list')
          .then((response) => {
            this.foodList = response.data
            console.log('foodList:', this.foodList)
          })
    },
    handleDelete(id) {
      axios.post('http://localhost:8081/food/delete/' + id)
          .then((response) => {
            if (response.data == true) {
              this.$message.success("删除成功")
              this.getData()
            } else {
              this.$message.error("删除失败")
            }
          })
    },
    handleEdit(id) {
      this.$router.push('/main/editFood/' + id)
    },
    handleQuery() {
      if (this.queryForm.name === '') {
        this.$message.error("查询内容不能为空")
      } else {
        axios.post('http://localhost:8081/food/query', this.queryForm)
            .then((response) => {
              let result = response.data
              console.log("response:", response.data)
              if (result.length === 0) {
                this.$message.error("没有查到相关膳食")
              } else {
                this.$message.success("查询成功")
                this.foodList = result
              }

            })
      }
    },
  },
}
</script>

<style scoped>
.food-card-button {
  display: inline-block;
  padding: 10px;
}

.food-toolbar {
  display: inline-block;
  position: absolute;
  right: 20px;
  top: 68px;
}
</style>