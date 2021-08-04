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
            data.courIns.toLowerCase().includes(search.toLowerCase()) ||
            data.school.toLowerCase().includes(search.toLowerCase()) ||
            data.year.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
      height="560px"
    >
      <el-table-column prop="courName" label="课程名" width="160"></el-table-column>
      <el-table-column prop="courIns" label="开课机构" width="160"></el-table-column>
      <el-table-column prop="year" label="上课学年" width="160"></el-table-column>
      <el-table-column prop="school" label="上课学期" width="160"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getCour } from "@/network/cour.js";

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
    getCour(encodeURI(encodeURI(this.$store.state.userMsg.sMaj)),this.$store.state.userMsg.sNum).then((res) => {
      this.tableData = res.map.cour;
      console.log(this.$store.state.userMsg.sMaj);
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