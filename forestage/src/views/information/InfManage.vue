<template>
  <div>
    <el-tabs :tab-position="tabPosition" style="height: 200px">
      <el-tab-pane label="信息查询">
        <el-tabs @tab-click="handleClick">
          <el-tab-pane label="学生信息查询" name="first">
            <inf-show></inf-show>
          </el-tab-pane>
          <el-tab-pane label="教师信息查询" name="second">
            <tea-info-show></tea-info-show>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
      <el-tab-pane
        label="信息录入"
        :disabled="this.$store.state.userMsg.tAuth == '2' ? true : false"
      >
        <el-tabs @tab-click="handleClick">
          <el-tab-pane label="老师信息单人录入" name="first">
            <tea-create></tea-create>
          </el-tab-pane>
          <el-tab-pane label="学生信息单人录入" name="second">
            <stu-create></stu-create>
          </el-tab-pane>
          <el-tab-pane label="老师信息批量录入" name="three">
            <teacher></teacher>
          </el-tab-pane>
          <el-tab-pane label="学生信息批量录入" name="four">
            <student></student>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
      <!-- <el-tab-pane label="信息修改">信息修改</el-tab-pane> -->
    </el-tabs>
  </div>
</template>

<script>
import student from "../../components/content/batchentry/student.vue";
import teacher from "../../components/content/batchentry/teacher.vue";
import StuCreate from "../../components/content/infcreate/StuCreate.vue";
import TeaCreate from "../../components/content/infcreate/TeaCreate.vue";
import InfShow from "../../components/content/infShow/InfShow.vue";
import InfoCreate from "./InfoCreate.vue";
import TeaInfoShow from './teaInfoShow.vue';

export default {
  components: { InfShow, StuCreate, student, teacher, TeaCreate, TeaInfoShow },

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
  created() {
    console.log(this.$store.state.userMsg.tAuth == "2");
  },
};
</script>

<style>
</style>