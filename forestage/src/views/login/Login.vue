<template>
  <el-card class="box-card">
    <el-form
      :model="formName"
      status-icon
      :rules="rules"
      ref="formName"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="学号" prop="uNum">
        <!--userName为需要校验的字段名-->
        <el-input
          type="text"
          v-model="formName.uNum"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="uPwd">
        <el-input
          type="password"
          v-model="formName.uPwd"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="身份">
        <el-select v-model="role" placeholder="请选择身份">
          <el-option label="学生" value="3"></el-option>
          <el-option label="老师" value="2"></el-option>
          <el-option label="超级用户" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('formName')"
          >提交</el-button
        >
        <el-button @click="resetForm('formName')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import { login } from "../../network/login.js";
export default {
  data() {
    return {
      majName: "",
      role: "",
      formName: {
        uNum: "",
        uPwd: "",
      },
      rules: {
        uNum: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 5, max: 12, message: "长度在5到个字符", trigger: "blur" },
        ],
        uPwd: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          login(this.formName.uNum, this.formName.uPwd, this.role).then(
            (res) => {
              console.log(res);
              if (res.code == 100) {
                console.log(this.role);
                window.sessionStorage.clear(); //清除session
                window.sessionStorage.setItem("token", res.map.token);
                this.$store.commit("changeUserMsg", res.map.user);
                if (this.role === "3") {
                  window.sessionStorage.setItem("sNum", res.map.user.sNum);
                  this.$router.replace("/2006");
                  window.sessionStorage.setItem("role", 3);
                } else {
                  window.sessionStorage.setItem("uNum", res.map.user.uNum);
                  this.$router.replace("/home");
                  if (this.role === "2") {
                    window.sessionStorage.setItem("role", 2);
                  } else {
                    window.sessionStorage.setItem("role", 1);
                  }
                }
                this.$notify({
                  title: "登录成功",
                  type: "success",
                });
              } else {
                this.$notify.error({
                  title: "登录失败",
                  message: "请检查登录信息",
                });
              }
              console.log(res);
            }
          );
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style scoped>
.text {
  font-size: 14px;
}
.el-input {
  width: 200px;
  margin-right: 100px;
}
.box-card {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 500px;
}
.el-form-item content {
  margin-right: 60px !important;
}
.el-form-item {
  margin-left: -55px;
}
</style>