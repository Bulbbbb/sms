<template>
  <div>
    <el-tabs :tab-position="tabPosition" style="height: 200px">
      <el-tab-pane label="课程查询">
        <el-tabs @tab-click="handleClick">
          <el-tab-pane label="所有课程查询" name="first">
            <cour-show></cour-show>
          </el-tab-pane>
          <el-tab-pane label="课程安排查询" name="second">
            <cour-at-show></cour-at-show>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
      <el-tab-pane label="课程录入" :disabled="this.$store.state.userMsg.tAuth=='2'?true:false">
        <el-tabs @tab-click="handleClick">
          <el-tab-pane label="单个课程录入" name="first">
            <cour-create></cour-create>
          </el-tab-pane>
          <el-tab-pane label="批量课程录入" name="second">
            <cour></cour>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
      <el-tab-pane label="课程安排">
        <cour-at></cour-at>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Cour from '../../components/content/batchentry/Cour.vue';
import CourAt from './CourAt.vue';
import CourAtShow from './CourAtShow.vue';
import CourCreate from "./CourCreate.vue";
import CourShow from "./CourShow.vue";
export default {
  components: {
    CourCreate,
    CourShow,
    Cour,
    CourAt,
    CourAtShow
  },
  data() {
    return {
      tabPosition: "left",
    };
  },
};
</script>

<style>
</style>