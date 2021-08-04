<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.iName.toLowerCase().includes(search.toLowerCase()) ||
            data.iNum.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column
        prop="iName"
        label="学院名称"
        width="160"
      ></el-table-column
      >year
      <el-table-column
        prop="iNum"
        label="学院编号"
        width="160"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getIns } from "@/network/ins.js";

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
    getIns(this.$store.state.userMsg.uNum).then((res) => {
      this.tableData = res.map.ins;
    });
  },
};
</script>
<style scoped>
.el-tab-pane {
  height: 100%;
}
</style>