<template>
  <div id="topBar">
    <div class="container">
      <div></div>
      <div>
        <span class="title">学籍信息管理系统</span>
      </div>
      <div>
        <el-dropdown @command="handleCommand">
          <div class="avatar">
            <span class="aaa">{{ name }}</span>
          </div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="a">个人中心</el-dropdown-item>
            <el-dropdown-item
              divided
              v-html="'退&#12288;&#12288;出'"
              command="c"
            ></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {},
    };
  },
  methods: {
    handleCommand(command) {
      switch (command) {
        case "a":
          this.$router.push("/profile");
          break;
        case "b":
          this.$router.push("/setting");
          break;
        case "c":
          this.$router.push("/login");
          window.sessionStorage.clear();
          break;
      }
    },
  },
  created() {
    this.user = this.$store.state.userMsg;
  },
  computed: {
    name() {
      let role = window.sessionStorage.getItem("role");
      if (role === "3") {
        return this.user.sName;
      } else {
        return this.user.uName;
      }
    },
  },
};
</script>
 
<style>
.container {
  display: flex;
  justify-content: space-between;
}
.avatar {
  width: 60px;
  height: 60px;
  font-size: 12px;
  cursor: pointer;
}
.avatar::before {
  content: "";
  display: block;
  width: 44px;
  height: 44px;
  margin-left: 8px;
  background: url(../../../assets/img/avatar.png) no-repeat;
  background-size: 44px;
}
.title {
  font-size: 30px;
  line-height: 60px;
  font-family: FZShuTi;
}
.aaa{
line-height: 10px !important;
}
</style>