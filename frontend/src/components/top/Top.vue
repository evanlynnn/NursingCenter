<template>
  <div>
    <el-menu :default-active="1" class="el-menu-demo" mode="horizontal" @select="handleSelect"
             background-color="#32896C" text-color="#ffffff">
      <el-menu-item index="1">首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">客户管理</template>
        <el-menu-item index="2-1">客户列表</el-menu-item>
        <el-menu-item index="2-2">客户入住</el-menu-item>
        <el-menu-item index="2-3">客户退住</el-menu-item>
      </el-submenu>
      <el-menu-item index="3">床位管理</el-menu-item>
      <el-submenu index="4">
        <template slot="title">护理管理</template>
        <el-menu-item index="4-1">护理设置</el-menu-item>
        <el-menu-item index="4-2">定制护理</el-menu-item>
      </el-submenu>
      <el-submenu index="5">
        <template slot="title">膳食管理</template>
        <el-menu-item index="5-1">膳食列表</el-menu-item>
        <el-menu-item index="5-2">制定膳食</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Top",
  data() {
    return {}
  },
  methods: {
    handleSelect(id) {
      switch (id) {
        case '1':
          this.$router.push('/main/dashboard')
          break;
        case '2':
          this.$router.push('/main/customer')
          break;
        case '2-1':
          this.$router.push('/main/customer')
          break;
        case '2-2':
          this.$router.push('/main/checkin')
          break;
        case '2-3':
          this.$router.push('/main/retreat')
          break;
        case '3':
          this.$router.push('/main/bed')
          break;
        case '4-1':
          this.$router.push('/main/nursing')
          break;
        case '4-2':
          this.$router.push('/main/customizeNursing')
          break;
        case '5-1':
          this.$router.push('/main/food')
          break;
        case '5-2':
          this.$router.push('/main/customizeMenu')
          break;
      }
    }
  }
}
</script>

<style scoped>
.el-menu-item,el-submenu  {
  width: 100px;
  text-align: center;
  font-weight: bold;
}
li.el-submenu {
  font-weight: bold;
  width: 100px;
}
</style>