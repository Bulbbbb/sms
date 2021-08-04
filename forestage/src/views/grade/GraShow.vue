<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.courName.toLowerCase().includes(search.toLowerCase()) ||
            data.cla.toLowerCase().includes(search.toLowerCase()) ||
            data.stuName.toLowerCase().includes(search.toLowerCase())||
            data.year.toLowerCase().includes(search.toLowerCase())||
            data.school.toLowerCase().includes(search.toLowerCase())||
            data.grade.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column prop="courName" label="课程" width="160"></el-table-column>year
      <el-table-column prop="cla" label="班级" width="160"></el-table-column>
      <el-table-column prop="stuName" label="学生姓名" width="160"></el-table-column>
      <el-table-column prop="year" label="学年" width="160"></el-table-column>
      <el-table-column prop="school" label="学期" width="160"></el-table-column>
      <el-table-column prop="grade" label="成绩" width="160"></el-table-column>
    </el-table>
  </div>
</template>

<script>
// import { getStus } from "@/network/student.js";
// import { getcours } from "@/network/cour.js";
import { getGra } from "@/network/grade.js";

export default {
  data() {
    return {
      users: [],
      tableData: [],
      search: "",
    };
  },
  methods: {},
  created() {
    getGra(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      // console.log(res.map.stus.list);
      this.tableData = res;
      console.log(res);
    });
  },
};
</script>
<style scoped>
.el-tab-pane {
  height: 100%;
}
</style>