<template>
  <el-form label-width="80px" size="mini" :model="sizeForm" ref="sizeForm">
    <el-form-item label="用户身份">
      <el-select v-model="role" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        >
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="用户姓名">
      <el-select v-model="name" filterable placeholder="请选择活动区域">
        <el-option
          v-if="role === '教师'"
          v-for="item in names"
          :key="item.value"
          :label="item.uName"
          :value="item.uName"
        ></el-option>
        <el-option
          v-if="role === '学生'"
          v-for="item in names"
          :key="item.value"
          :label="item.sName"
          :value="item.sName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item
      label="权限等级"
      prop="name"
      :rules="[{ required: true, message: '请输入权限等级', trigger: 'blur' }]"
    >
      <el-input v-model="sizeForm.name"></el-input>
    </el-form-item>
    <el-form-item size="large">
      <el-button type="primary" @click="onSubmit('sizeForm')"
        >立即修改</el-button
      >
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { getIns } from "@/network/cour.js";
import { courCreate } from "@/network/cour.js";
import { getStus } from "@/network/student.js";
import { getUser } from "@/network/system.js";

export default {
  components: {},
  data() {
    return {
      ins: [],
      names: [],
      clas: [],
      name: "",
      className: "",
      institution: "",
      role: "",
      sizeForm: {
        name: "",
        num: "",
      },
      options: [
        { value: "教师", label: "教师" },
        { value: "学生", label: "学生" },
        // { value: "超级用户", label: "超级用户" },
      ],
    };
  },
  watch: {
    role(val, oldval) {
      this.names = [];

      console.log(val);
      if (val === "学生") {
        getStus(this.$store.state.userMsg.uNum).then((res) => {
          this.names = res.map.stus.list;
          console.log(this.names);
        });
      }
      if (val === "教师") {
        getUser(this.$store.state.userMsg.uNum).then((res) => {
          this.names = res.map.user;
          console.log(this.names);
        });
      }
    },
  },
  methods: {
    onSubmit(formName) {
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          courCreate(
            encodeURI(encodeURI(this.sizeForm.name)),
            this.sizeForm.num,
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

<style>
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