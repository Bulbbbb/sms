<template >
  <el-menu
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    :collapse="false"
    :unique-opened="true"

  >
    <!-- <el-button type="primary" icon="el-icon-s-operation" @click="deploy" /> -->
    <el-menu-item
      v-for="(item, index) in powers"
      :key="index"
      :index="index.toString()"
      @click="jump(item.powNum)"
    >
      <!-- <i class="el-icon-menu"></i> -->
      <span slot="title">{{ item.powName }}</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
import { getPowers } from "@/network/power.js";
export default {
  name: "Menu",
  data() {
    return {
      count: 0,
      isCollapse: true,
      powers: Array,
    };
  },
  methods: {
    jump(s) {
      this.$router.push("/" + s);
      console.log(s);
    },
    handleOpen(key, keyPath) {
      console.log(key);
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    deploy() {
      this.isCollapse = !this.isCollapse;
    },
  },

  created() {
    let role = window.sessionStorage.getItem("role");
    let auth = "";
    let num = "";
    if (role === "3") {
      auth = this.$store.state.userMsg.sAuth;
      num = this.$store.state.userMsg.sNum;
    } else {
      auth = this.$store.state.userMsg.tAuth;
      num = this.$store.state.userMsg.uNum;
    }
    getPowers(auth, num).then((res) => {
      this.powers = res.map.power;
      console.log(res.map.power);
    });
  },
};
</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  /* background-color: #545c64; */
  width: 216px;
  min-height: 400px;
}
</style>