<template>
  <div>
    <el-container>
      <el-header>
        <Top />
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Top from '../top/Top'

export default {
  name: "Main",
  components: {
    Top,
  }
}
</script>

<style scoped>
.el-main {
  padding: 0;
}
.el-header {
  padding: 0;
}

</style>