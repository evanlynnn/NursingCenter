<template>
  <el-card class="box-card">
    <!--Top Toolbar-->
    <div slot="header" class="clearfix">
      <span>{{title}}</span>
    </div>

    <el-row :gutter="20">
      <el-col :span="4" v-for="(menu, index) in menuList" :key="index">
        <div class="grid-content bg-purple">
          <el-card :body-style="{ padding: '0px', 'text-align': 'center' }">
            <div class="food-image" style="padding-top: 14px">
              <!--图片大小200px-->
              <img style="height: 200px; width: auto"
                   :src="`http://localhost:8081/`+ menu.food.imgName"
                   class="image">
            </div>
            <div style="padding: 14px">
              <span>{{ menu.food.name }}</span>
              <div class="bottom clearfix">

                <div class="food-card-button">
                  <el-tag>{{menu.eatingTime}}</el-tag>
                </div>


              </div>
            </div>
          </el-card>
        </div>

      </el-col>
    </el-row>

  </el-card>
</template>

<script>
export default {
  name: "DayMenu",
  props: ['menuList', 'title']
}
</script>

<style scoped>
.food-card-button {
  display: inline-block;
  padding: 10px;
}
</style>