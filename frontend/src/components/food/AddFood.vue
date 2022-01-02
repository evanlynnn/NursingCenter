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
          <el-form-item label="膳食名称">
            <el-col :span="4">
              <el-input v-model="formData.name" placeholder="请输入膳食名称"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="碳水化合物含量">
            <el-col :span="4">
              <el-input v-model="formData.cho" placeholder="单位：克"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="蛋白质含量">
            <el-col :span="4">
              <el-input v-model="formData.protein" placeholder="单位：克"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="脂肪含量">
            <el-col :span="4">
              <el-input v-model="formData.fat" placeholder="单位：克"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="热量">
            <el-col :span="4">
              <el-input v-model="formData.heat" placeholder="单位：千卡"></el-input>
            </el-col>
          </el-form-item>

          <el-form-item label="上传图片">
            <el-col :span="2">
              <!--文件名-->

            </el-col>
            <el-col :span="4" style="margin-left: 10px">
              <el-upload
                  list-type="picture-card"
                  class="avatar-uploader"
                  action="http://localhost:8081/common/upload"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess"
                  :before-upload="beforeAvatarUpload">
                <img v-if="formData.imgName" :src="`http://localhost:8081/${formData.imgName}`" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
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
  name: "AddFood",
  components: {},
  data() {
    return {
      formData: {
        name: '',
        protein: '',
        cho: '',
        fat: '',
        heat: '',
        imgName: '',
      },
      uploadData: {},

    }
  },
  methods: {
    returnBack() {
      this.$router.push('/main/food')
    },
    submitUpload() {
      console.log('data:', this.uploadData)
      console.log('submit image')
    },
    beforeAvatarUpload(file) {
      console.log(file)
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/png' || file.type === 'image/webp';
      const isLt2M = file.size / 1024 / 1024 < 4;

      if (!isJPG) {
        this.$message.error('上传正确的图片格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 4MB!');
      }
      return isJPG && isLt2M;
    },
    handleAvatarSuccess(res) {
      this.formData.imgName = res
      console.log('img_name:', this.formData.imgName)
    },
    handleSubmit() {
      console.log("formData:", this.formData)
      axios.post('http://localhost:8081/food/add', this.formData)
          .then((response) => {
            if (response.data === true) {
              this.$message.success("添加膳食成功")
              this.$router.push("/main/food")
            } else {
              this.$message.error("添加失败")
            }
          })
          .catch(err => console.log(err))
    }
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 146px;
  height: 146px;
  line-height: 146px;
  text-align: center;
}

.avatar {
  width: 146px;
  height: 146px;
  display: block;
}

</style>