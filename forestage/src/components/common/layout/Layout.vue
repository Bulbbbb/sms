<template>
  <div id="layout">
    <el-header>
      <top-bar></top-bar>
    </el-header>
    <el-container>
      <el-aside width="217px">
        <a-menu></a-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import aMenu from "../amenu/AMenu.vue";
// import TopBar from "@/components/content/topBar/TopBar.vue";
import TopBar from '../../content/topBar/TopBar.vue';
export default {
  components: { aMenu ,TopBar},
};
</script>
<style scoped>
.el-header {
  /* background-color: #545c64; */
  color: #333;
  text-align: center;
  line-height: 15px;
  box-shadow: 0 2px 8px 0 rgba(16, 207, 198, 0.2);

}

.el-aside {
  /* background-color: rgba(16, 137, 207, 0.2); */
  /* background-color: #545c64; */

  color: #333;
  text-align: center;
  line-height: 70px;
  height: calc(91.6vh);

}
.el-container {
  height:100%;
}
.el-main {
  color: #333;
  /* text-align: center; */
  line-height: 40px;
}

</style>