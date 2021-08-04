<template>
  <div>
    <el-tabs :tab-position="tabPosition" style="height: 200px">
      <el-tab-pane label="成绩查询">
        <gra-show></gra-show>
      </el-tab-pane>
      <el-tab-pane label="成绩录入">
        <el-tabs @tab-click="handleClick">
          <el-tab-pane label="成绩单人录入" name="first">
            <gread-create></gread-create>
          </el-tab-pane>
          <el-tab-pane label="成绩批量录入" name="second">
            <grade></grade>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
      <!-- <el-tab-pane label="成绩修改">成绩修改</el-tab-pane> -->
    </el-tabs>
  </div>
</template>

<script>
import Grade from '../../components/content/batchentry/Grade.vue';
import GraShow from "./GraShow.vue";
import greadCreate from "./greadCreate.vue";
export default {
  components: { greadCreate, GraShow, Grade },
  data() {
    return {
      tabPosition: "left",
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
};
</script>

<style>
</style>