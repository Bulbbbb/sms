<template>
  <el-form label-width="80px" size="mini" :model="courAt" :ref="courAt">
    <el-form-item label="所属专业">
      <el-select v-model="courAt.majName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in majs"
          :key="index"
          :label="value.mName"
          :value="value.mName"
          :major="value.mName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="开设机构">
      <el-select v-model="courIns" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in ins"
          :key="index"
          :label="value.iName"
          :value="value.iName"
          :major="value.iName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="课程名称">
      <el-select v-model="courAt.courName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in cour"
          :key="index"
          :label="value.cName"
          :value="value.cName"
          :major="value.cName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="学年">
      <el-select v-model="courAt.year" placeholder="请选择活动区域">
        <el-option label="1" value="1" major="1"></el-option>
        <el-option label="2" value="2" major="2"></el-option>
        <el-option label="3" value="3" major="3"></el-option>
        <el-option label="4" value="4" major="3"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="学期">
      <el-select v-model="courAt.school" placeholder="请选择活动区域">
        <el-option label="1" value="1" major="1"></el-option>
        <el-option label="2" value="2" major="2"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item size="large">
      <el-button type="primary" @click="onSubmit()">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { getIns } from "@/network/cour.js";
import { getMajs } from "@/network/cour.js";
import { getMaj } from "@/network/ins.js";
import { getACour } from "@/network/cour.js";
import { addCourAt } from "@/network/cour.js";
export default {
  components: {},
  data() {
    return {
      courAt: {
        majName: "",
        courName: "",
        courIns: "",
        year: "",
        school: "",
      },
      ins: [],
      majs: [],
      cour: [],
      courIns: "",
    };
  },
  watch: {
    courIns(val, oldval) {
      this.courAt.courIns = val;
      console.log(val);
      getACour(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          console.log(res);
          this.cour = res.map.cour;
        }
      );
      this.courAt.courName = "";
    },
  },
  methods: {
    onSubmit() {
      console.log(this.courAt);
      addCourAt(this.courAt, this.$store.state.userMsg.uNum).then((res) => {
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
          // console.log(this.sizeForm.num);
          this.$notify.error({
            title: "提交失败",
            // message: "请检查是否登录",
          });
        }
      });
    },
  },
  created() {
    getIns(this.$store.state.userMsg.uNum).then((res) => {
      this.ins = res.map.ins;
      console.log(res);
    });
    getMaj(this.$store.state.userMsg.uNum).then((res) => {
      this.majs = res.map.maj;
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