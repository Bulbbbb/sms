<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" ref="sizeForm">
    <el-form-item
      label="专业名称"
      prop="name"
      :rules="[{ required: true, message: '请输入专业名称', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.name"></el-input>
    </el-form-item>
    <el-form-item
      label="专业编号"
      prop="num"
      :rules="[{ required: true, message: '请输入专业编号', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.num"></el-input>
    </el-form-item>
    <el-form-item label="所属学院">
      <el-select v-model="sizeForm.institution" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in ins"
          :key="index"
          :label="value.iName"
          :value="value.iName"
          :major="value.iName"
        ></el-option>
      </el-select>
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
import { getIns } from "@/network/ins.js";
import { majCreate } from "@/network/ins.js";
export default {
  components: {},
  data() {
    return {
      sizeForm: {
        name: "",
        num: "",
        institution: "",
      },
      ins: [],
      major: "",
    };
  },
  methods: {
    onSubmit(formName) {
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          majCreate(
            encodeURI(encodeURI(this.sizeForm.name)),
            this.sizeForm.num,
            encodeURI(encodeURI(this.sizeForm.institution)),
            this.$store.state.userMsg.uNum
          ).then((res) => {
            if (typeof res == "undefined") {
              this.$notify.error({
                title: "提交失败",
                // message: "请检查该专业编号是否已存在",
              });
            } else if (res.code == "100") {
              console.log(res);
              this.$notify({
                title: "成功",
                type: "success",
              });
            } else {
              console.log(this.sizeForm.num);
              this.$notify.error({
                title: "提交失败",
                // message: "请检查是否登录",
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
  created() {
    getIns(this.$store.state.userMsg.uNum).then((res) => {
      this.ins = res.map.ins;
      console.log(res);
    });
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