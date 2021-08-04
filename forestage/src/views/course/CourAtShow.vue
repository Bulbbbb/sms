<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.majName.toLowerCase().includes(search.toLowerCase()) ||
            data.courName.toLowerCase().includes(search.toLowerCase()) ||
            data.courIns.toLowerCase().includes(search.toLowerCase())||
            data.year.toLowerCase().includes(search.toLowerCase())||
            data.school.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
       height="480"
    >
      <el-table-column prop="majName" label="专业名称" width="200"></el-table-column>
      <el-table-column prop="courName" label="课程名称" width="160"></el-table-column>
      <el-table-column prop="courIns" label="开课学院" width="160"></el-table-column>
      <el-table-column prop="year" label="开课学年" width="160"></el-table-column>
      <el-table-column prop="school" label="开课学期" width="160"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getCourAt } from "@/network/cour.js";

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
    getCourAt(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      // console.log(res.map.stus.list);
      this.tableData = res.map.courAt;
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