<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" :ref="sizeForm">
    <el-form-item
      label="姓名"  
      prop="uName"
      :rules="[{ required: true, message: '请输入姓名', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.uName"></el-input>
    </el-form-item>
    <el-form-item
      label="工号"
      prop="uNum"
      :rules="[{ required: true, message: '请输入教师工号', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.uNum"></el-input>
    </el-form-item>
    <el-form-item
      label="性别"
      prop="uSex"
      :rules="[{ required: true, message: '请选择教师性别', trigger: 'blur' }]"
    >
      <el-radio-group v-model="sizeForm.uSex" size="medium">
        <el-radio border label="男"></el-radio>
        <el-radio border label="女"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item
      label="职位"
      prop="uJob"
      :rules="[{ required: true, message: '请输入教师职位', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.uJob"></el-input>
    </el-form-item>
    <el-form-item
      label="学历"
      prop="uEdu"
      :rules="[{ required: true, message: '请输入教师学历', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.uEdu"></el-input>
    </el-form-item>
    <el-form-item label="所属学院"
          prop="uIns"
      :rules="[{ required: true, message: '请选择教师所属学院', trigger: 'blur' }]">
      <el-select v-model="sizeForm.uIns" placeholder="请选择活动区域">
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
      <el-button type="primary" @click="onSubmit(sizeForm)">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { teaCreate } from "@/network/teacher.js";
import { getIns } from "@/network/cour.js";

export default {
  components: {},
  data() {
    return {
      dynamicValidateForm: {
        email: "",
      },
      sizeForm: {
        uName: "",
        uNum: "",
        uSex: "",
        uJob: "",
        uEdu: "",
        uIns: "",
      },
      ins:[]
    };
  },
  methods: {
    onSubmit(formName) {
      console.log(formName);
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          teaCreate(this.sizeForm,this.$store.state.userMsg.uNum).then((res) => {
            console.log(res);
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
  created(){
    getIns(this.$store.state.userMsg.uNum).then((res) => {
      this.ins = res.map.ins;
      console.log(res);
    });
  }
};
</script >

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