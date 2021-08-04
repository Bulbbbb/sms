<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.cName.toLowerCase().includes(search.toLowerCase()) ||
            data.cNum.toLowerCase().includes(search.toLowerCase()) ||
            data.cIns.toLowerCase().includes(search.toLowerCase())||
            data.cGra.toLowerCase().includes(search.toLowerCase())||
            data.isSel.toLowerCase().includes(search.toLowerCase())||
            data.cTime.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
       height="530" 
    >
      <el-table-column prop="cName" label="课程名称" width="200"></el-table-column>
      <el-table-column prop="cNum" label="课程编号" width="160"></el-table-column>
      <el-table-column prop="cIns" label="开设学院" width="160"></el-table-column>
      <el-table-column prop="isSel" label="是否可选" width="160"></el-table-column>
      <el-table-column prop="cGra" label="学分" width="100"></el-table-column>
      <el-table-column prop="cTime" label="学时" width="100"></el-table-column>
      <el-table-column prop="week" label="星期" width="100"></el-table-column>
      <el-table-column prop="cla" label="节" width="100"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getStus } from "@/network/student.js";
import { getcours } from "@/network/cour.js";

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
    getcours(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      // console.log(res.map.stus.list);
      this.tableData = res.map.cours;
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