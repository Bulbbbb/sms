<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" ref="sizeForm">
    <el-form-item
      label="学院名称"
      prop="name"
      :rules="[{ required: true, message: '请输入学院名称', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.name"></el-input>
    </el-form-item>
    <el-form-item
      label="学院编号"
      prop="num"
      :rules="[{ required: true, message: '请输入学院编号', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.num"></el-input>
    </el-form-item>
    <el-form-item size="large">
      <el-button type="primary" @click="onSubmit('sizeForm')"
        >立即创建</el-button
      >
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { getStus } from "@/network/ins.js";
export default {
  components: {},
  data() {
    return {
      sizeForm: {
        name: "",
        num: "",
      },
    };
  },
  methods: {
    onSubmit(formName) {
      // console.log();
      this.$refs[formName].validate((valid) => {
        if (valid) {
          getStus(
            encodeURI(encodeURI(this.sizeForm.name)),
            this.sizeForm.num,
            this.$store.state.userMsg.uNum
          ).then((res) => {
            if (typeof res == "undefined") {
              this.$notify.error({
                title: "提交失败",
                message: "请检查该学院编号是否已存在",
              });
            } else if (res.code == "100") {
              this.$notify({
                title: "成功",
                type: "success",
              });
            } else {
              this.$notify.error({
                title: "提交失败",
                message: "请检查是否登录",
              });
            }
          });
        } else {
          this.$notify.error({
            title: "提交失败",
            message: "请检查提交信息是否为空",
          });
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.el-form {
  margin-left: 25%;
}
.el-input {
  width: 300px;
}
.el-button {
  padding: 8px 20px;
}
</style>