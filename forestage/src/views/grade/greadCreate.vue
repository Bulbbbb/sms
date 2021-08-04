<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" ref="sizeForm">
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
    <el-form-item label="学生姓名">
      <el-select v-model="stuName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in stus"
          :key="index"
          :label="value.sName"
          :value="value.sName"
          :major="value.sName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="课程姓名">
      <el-select v-model="courName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in cour"
          :key="index"
          :label="value.courName"
          :value="value.courName"
          :major="value.courName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item
      label="学年"
      prop="year"
      :rules="[{ required: true, message: '请输入学年', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.year" :disabled="true"></el-input>
    </el-form-item>
    <el-form-item
      label="学期"
      prop="sch"
      :rules="[{ required: true, message: '请输入学期', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.sch" :disabled="true"></el-input>
    </el-form-item>
    <el-form-item
      label="课程成绩"
      prop="gra"
      :rules="[{ required: true, message: '请输入课程成绩', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.gra"></el-input>
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
import { getStusForCla } from "@/network/student.js";
import { getCour } from "@/network/cour.js";
import { graCreat } from "@/network/grade.js";
export default {
  components: {},
  data() {
    return {
      ins: [],
      majs: [],
      clas: [],
      stus: [],
      cour: [],
      courName: "",
      majName: "",
      className: "",
      institution: "",
      stuName: "",
      sizeForm: {
        name: "",
        num: "",
        gra: "",
        sch: "",
        year: "",
      },
    };
  },
  watch: {
    courName(val, oldval) {
      for (let i = 0; i < this.cour.length; i++) {
        if (this.cour[i].courName === val) {
          this.sizeForm.sch = this.cour[i].school;
          this.sizeForm.year = this.cour[i].year;
          this.sizeForm.gra = "";

          // console.log(val);
        }
      }
    },
    institution(val, oldval) {
      console.log(val);
      getMajs(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.majs = res.map.majs;
          console.log(res);
        }
      );
      this.className = "";
      this.majName = "";
      this.stuName = "";
      this.courName = "";
      this.sizeForm.gra = "";
    },
    majName(val, oldval) {
      console.log(val);
      getcla(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.clas = res.map.cla;
          console.log(res);
        }
      );
      getCour(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.cour = res.map.cour;
          console.log(res);
        }
      );
      this.className = "";
      this.stuName = "";
      this.courName = "";
      this.sizeForm.gra = "";
    },
    className(val, oldval) {
      console.log(val);
      getStusForCla(
        encodeURI(encodeURI(val)),
        1,
        this.$store.state.userMsg.uNum
      ).then((res) => {
        this.stus = res.map.stus.list;
        console.log(res);
      });
      // console.log(val);

      this.stuName = "";
      this.courName = "";
      this.sizeForm.gra = "";
      // this.className = "";
    },
  },
  methods: {
    aaa(a) {
      console.log(a);
    },
    onSubmit(formName) {
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          graCreat(
            encodeURI(encodeURI(this.stuName)),
            encodeURI(encodeURI(this.courName)),
            this.sizeForm.sch,
            encodeURI(encodeURI(this.className)),
            encodeURI(encodeURI(this.sizeForm.gra)),
            this.sizeForm.year,
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