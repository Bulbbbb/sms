<template>

  <el-form label-width="80px" size="mini" :model="sizeForm" ref="sizeForm">
    <el-form-item
      label="学生姓名"
      prop="name"
      :rules="[{ required: true, message: '请输入课程姓名', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.name"></el-input>
    </el-form-item>
    <el-form-item
      label="学生编号"
      prop="num"
      :rules="[{ required: true, message: '请输入课程编号', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.num"></el-input>
    </el-form-item>
    <el-form-item
      label="入学年份"
      prop="year"
      :rules="[{ required: true, message: '请输入入学年份', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.year"></el-input>
    </el-form-item>
    <el-form-item label="所属学院">
      <el-select v-model="institution" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in ins"
          :key="index"
          :label="value.iName"
          :value="value.iName"
          :major="value.iName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="所属专业">
      <el-select v-model="majName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in majs"
          :key="index"
          :label="value.mName"
          :value="value.mName"
          :major="value.mName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="所属班级">
      <el-select v-model="className" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in clas"
          :key="index"
          :label="value.cName"
          :value="value.cName"
          :major="value.cName"
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
import { getIns } from "@/network/cour.js";
import { getMajs } from "@/network/cour.js";
import { getcla } from "@/network/cour.js";
import { courCreate } from "@/network/cour.js";
import { stuCreate } from "@/network/student.js";
export default {
  components: {},
  data() {
    return {
      ins: [],
      majs: [],
      clas: [],
      majName: "",
      className: "",
      institution: "",
      sizeForm: {
        name: "",
        num: "",
        year:"",
      },
    };
  },
  watch: {
    institution(val, oldval) {
      console.log(val);
      getMajs(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.majs = res.map.majs;
          console.log(res);
        }
      );
      this.className = "";
      this.majName="";
    },
    majName(val, oldval) {
      console.log(val);
      getcla(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.clas = res.map.cla;
          console.log(res);
        }
      );
      this.className = "";
    },
  },
  methods: {
    onSubmit(formName) {
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          stuCreate(
            encodeURI(encodeURI(this.sizeForm.name)),
            this.sizeForm.num,
            this.sizeForm.year,
            encodeURI(encodeURI(this.institution)),
            encodeURI(encodeURI(this.majName)),
            encodeURI(encodeURI(this.className)),
            this.$store.state.userMsg.uNum
          ).then((res) => {
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