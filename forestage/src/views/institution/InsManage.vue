<template>
  <el-tabs :tab-position="tabPosition" style="height: 200px">
    <el-tab-pane label="机构信息查询">
            <el-tabs @tab-click="handleClick">
        <el-tab-pane label="查询学院" name="first">
          <ins-show></ins-show>
        </el-tab-pane>
        <el-tab-pane label="查询专业" name="second">
          <maj-show></maj-show>
        </el-tab-pane>
        <el-tab-pane label="查询班级" name="third">
          <cla-show></cla-show>
        </el-tab-pane>
      </el-tabs>
    </el-tab-pane>
    <el-tab-pane label="机构信息录入">
      <el-tabs @tab-click="handleClick">
        <el-tab-pane label="创建学院" name="first">
          <ins-create></ins-create>
        </el-tab-pane>
        <el-tab-pane label="创建专业" name="second">
          <maj-create></maj-create>
        </el-tab-pane>
        <el-tab-pane label="创建班级" name="third">
         <cla-create></cla-create>
        </el-tab-pane>
      </el-tabs>
    </el-tab-pane>
    <!-- <el-tab-pane label="机构信息修改">机构信息修改</el-tab-pane> -->
  </el-tabs>
</template>

<script>
import InfShow from "../../components/content/infShow/InfShow.vue";
import ClaCreate from '../../components/content/insmanager/ClaCreate.vue';
import InsCreate from "../../components/content/insmanager/InsCreate.vue";
import MajCreate from '../../components/content/insmanager/MajCreate.vue';
import ClaShow from './ClaShow.vue';
import InsShow from './InsShow.vue';
import MajShow from './MajShow.vue';

export default {
  components: { InfShow, InsCreate,ClaCreate,MajCreate, InsShow, MajShow, ClaShow },
  data() {
       return {
      tabPosition: "left",
      activeName: "second",
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
};
</script scoped>

<style>
.el-tabs {
  height: 606px !important;
}
</style>