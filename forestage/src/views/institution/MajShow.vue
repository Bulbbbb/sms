<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.mName.toLowerCase().includes(search.toLowerCase()) ||
            data.mIns.toLowerCase().includes(search.toLowerCase()) ||
            data.mNum.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column
        prop="mName"
        label="专业名称"
        width="220"
      ></el-table-column
      >year
      <el-table-column
        prop="mIns"
        label="所属学院"
        width="160"
      ></el-table-column>
      <el-table-column
        prop="mNum"
        label="专业编号"
        width="160"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getMaj } from "@/network/ins.js";

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
    getMaj(this.$store.state.userMsg.uNum).then((res) => {
      this.tableData = res.map.maj;
    });
  },
};
</script>
<style scoped>
.el-tab-pane {
  height: 100%;
}
</style>