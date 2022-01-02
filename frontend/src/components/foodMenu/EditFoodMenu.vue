<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>新增膳食</span>
        <el-button style="float: right; padding: 3px 0" type="text" @click="returnBack">返回</el-button>
      </div>
      <div class="text item">
        <!--Add food form-->
        <el-form ref="form" :model="formData" label-width="120px">
          <el-form-item label="膳食">
            <el-col :span="4">
              <el-select v-model="formData.food" placeholder="请选择膳食">
                <el-option v-for="(item, index) in foodData" :key="index"
                           :label="item.name" :value="item.foodId" @change="$forceUpdate()"/>
              </el-select>
            </el-col>
          </el-form-item>

          <el-form-item label="用餐时段">
            <el-col :span="4">
              <el-select v-model="formData.eatingTime" placeholder="请选择用餐时段">
                <el-option label="早餐" value="早餐"></el-option>
                <el-option label="中餐" value="中餐"></el-option>
                <el-option label="晚餐" value="晚餐"></el-option>
              </el-select>
            </el-col>
          </el-form-item>

          <el-form-item label="用餐时间">
            <el-col :span="4">
              <el-select v-model="formData.week" placeholder="请选择用餐时间">
                <el-option label="星期一" value="1"></el-option>
                <el-option label="星期二" value="2"></el-option>
                <el-option label="星期三" value="3"></el-option>
                <el-option label="星期四" value="4"></el-option>
                <el-option label="星期五" value="5"></el-option>
                <el-option label="星期六" value="6"></el-option>
                <el-option label="星期天" value="7"></el-option>
              </el-select>

            </el-col>
          </el-form-item>

          <el-form-item label="用餐人">
            <el-col :span="4">
              <el-select v-model="formData.user" placeholder="请选择用餐人">
                <el-option v-for="(item, index) in userData" :key="index"
                           :label="item.name" :value="item.userId" @change="$forceUpdate()"/>
              </el-select>
            </el-col>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="handleSubmit">提交</el-button>
          </el-form-item>

        </el-form>


      </div>
    </el-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "EditFoodMenu",
  data() {
    return {
      formData: {
        food: {},
        eatingTime: '',
        week: '',
        user: {}

      },
      userData: {

      },
      foodData: {

      }
    }
  },
  created() {
    let id = this.$route.params.id;
    axios.get('http://localhost:8081/foodMenu/get/' + id)
        .then((response) => {
          this.formData = response.data
          this.formData.food = this.formData.food.foodId
          this.formData.user = this.formData.user.userId
        })
    this.getFoodData()
    this.getUserData()
  },
  methods: {
    getFoodData() {
      axios.get('http://localhost:8081/food/list')
          .then((response) => {
            this.foodData = response.data
            console.log('foodData:', this.foodData)
          })
    },
    getUserData() {
      axios.get('http://localhost:8081/user/selbystatus/1')
          .then((response) => {
            this.userData = response.data
            console.log("userData:", this.userData)
          })
    },
    returnBack() {
      this.$router.push('/main/foodMenu')
    },
    handleSubmit() {
      console.log('form', this.formData)
      // Change the food id into food object
      this.formData.food = this.foodData.find(food => food.foodId === this.formData.food)
      this.formData.user = this.userData.find(user => user.userId === this.formData.user)
      console.log('form:', this.formData)

      axios.post('http://localhost:8081/foodMenu/update', this.formData)
          .then((response) => {
            if (response.data === true) {
              this.$message.success("更新成功")
              this.$router.push("/main/foodMenu")
            } else {
              this.$message.error("更新失败")
            }
          })
          .catch(err => console.log(err))

    },

  },
}
</script>

<style scoped>

</style>