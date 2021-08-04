<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" :ref="sizeForm">
    <el-form-item
      label="姓名"
      prop="sName"
      :rules="[{ required: true, message: '请输入姓名', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.sName"></el-input>
    </el-form-item>
    <el-form-item
      label="学号"
      prop="sNum"
      :rules="[{ required: true, message: '请输入学生学号', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.sNum"></el-input>
    </el-form-item>
    <el-form-item
      label="性别"
      prop="sSex"
      :rules="[{ required: true, message: '请选择学生性别', trigger: 'blur' }]"
    >
      <el-radio-group v-model="sizeForm.sSex" size="medium">
        <el-radio border label="男"></el-radio>
        <el-radio border label="女"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item
      label="所属学院"
      prop="sIns"
      :rules="[
        { required: true, message: '请选择教师所属学院', trigger: 'blur' },
      ]"
    >
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
    <el-form-item
      label="所属专业"
      prop="sMaj"
      :rules="[
        { required: true, message: '请选择教师所属专业', trigger: 'blur' },
      ]"
    >
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
    <el-form-item
      label="所属班级"
      prop="sCla"
      :rules="[
        { required: true, message: '请选择教师所属班级', trigger: 'blur' },
      ]"
    >
      <el-select v-model="sizeForm.sCla" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in cla"
          :key="index"
          :label="value.cName"
          :value="value.cName"
          :major="value.cName"
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
import { addAStu } from "@/network/student.js";
import { getIns } from "@/network/cour.js";
import { getMajs } from "@/network/cour.js";
import { getcla } from "@/network/cour.js";
export default {
  components: {},
  data() {
    return {
      dynamicValidateForm: {
        email: "",
      },
      sizeForm: {
        sName: "",
        sNum: "",
        sSex: "",
        sIns: "",
        sMaj: "",
        sCla: "",
      },
      ins: [],
      majs: [],
      cla: [],
      institution: "", //
      majName: "", //
      className: "", //
    };
  },
  methods: {
    onSubmit(formName) {
      console.log(this.sizeForm);
      console.log(formName);
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          addAStu(this.sizeForm, this.$store.state.userMsg.uNum).then(
            (res) => {
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
            }
          );
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
  watch: {
    institution(val, oldval) {
      this.sizeForm.sIns = val;
      console.log(val);
      getMajs(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.majs = res.map.majs;
          console.log(res);
        }
      );
      this.className = "";
      this.majName = "";
    },
    majName(val, oldval) {
      this.sizeForm.sMaj = val;
      console.log(val);
      getcla(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.cla = res.map.cla;
          console.log(res);
        }
      );
      this.className = "";

    },
  },
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