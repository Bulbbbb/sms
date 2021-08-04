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
            data.cMajor.toLowerCase().includes(search.toLowerCase()) ||
            data.cIns.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column
        prop="cName"
        label="班级名称"
        width="160"
      ></el-table-column
      >year
      <el-table-column
        prop="cNum"
        label="班级编号"
        width="160"
      ></el-table-column>
      <el-table-column
        prop="cMajor"
        label="所属专业"
        width="220"
      ></el-table-column>
      <el-table-column
        prop="cIns"
        label="所属学院"
        width="160"
      ></el-table-column>
      <!-- <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
        </template>
      </el-table-column> -->
    </el-table>
  </div>
</template>

<script>
import { getCla } from "@/network/ins.js";

export default {
  data() {
    return {
      users: [],
      tableData: [],
      search: "",
    };
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
  },
  created() {
    getCla(this.$store.state.userMsg.uNum).then((res) => {
      this.tableData = res.map.cla;
    });
  },
};
</script scoped>
<style scoped>
.el-tab-pane {
  height: 100%;
}
</style>