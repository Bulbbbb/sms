<template>
  <el-form ref="form" :model="form" label-width="80px">
    <div v-if="role === '1' || role === '2'" style="overflow-y:scroll;height:400px">
      <el-form-item label="姓名">
        <el-input v-model="form.uName" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="工号">
        <el-input v-model="form.uNum" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="form.uPhone" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.uSex" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="职位">
        <el-input v-model="form.uJob" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="所属学院">
        <el-input v-model="form.uIns" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.uEmail" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="学历">
        <el-input v-model="form.uEdu" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-input v-model="form.uBirth" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.uPwd" :disabled="isEdit"></el-input>
      </el-form-item>
    </div>
    <div v-else style="overflow-y:scroll;height:400px">
      <el-form-item label="姓名">
        <el-input v-model="form.sName" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="form.sNum" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="班级">
        <el-input v-model="form.sCla" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="学院">
        <el-input v-model="form.sIns" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="入学年份">
        <el-input v-model="form.sIn" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="form.sPhone" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.sSex" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.sEmail" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="生日">
        <el-input v-model="form.sBirth" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.sPwd" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="学生状态">
        <el-input v-model="form.sState" :disabled="true"></el-input>
      </el-form-item>
    </div>
    <el-form-item>
      <el-button type="primary" @click="edit">编辑</el-button>
      <el-button type="primary" @click="onSubmit">立即更新</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      form: {},
      isEdit: true,
      role: "",
    };
  },
  methods: {
    onSubmit() {
      console.log(this.form);
      console.log("submit!");
    },
    edit() {
      this.isEdit = !this.isEdit;
    },
  },
  created() {
    this.form = this.$store.state.userMsg;
    this.role = window.sessionStorage.getItem("role");
    console.log(this.form);
  },
};
</script>

<style>
.el-form-item {
  margin-bottom: 19px;
}
</style>