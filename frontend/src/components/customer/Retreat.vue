<template>
  <div>
    <el-table
        :data="records"
        border
        style="width: 100%">
      <el-table-column
          label="序号"
          prop="checkinId">
      </el-table-column>
      <el-table-column
          label="用户id"
          prop="userId">
      </el-table-column>
      <el-table-column
          label="床位"
          prop="bedId">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="name">
      </el-table-column>
      <el-table-column
          label="Name"
          prop="name">
      </el-table-column>
      <el-table-column
          align="right">

        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "Retreat"
}
</script>

<style scoped>

</style>