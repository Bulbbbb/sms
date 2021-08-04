<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.authNum.toLowerCase().includes(search.toLowerCase()) ||
            data.powName.toLowerCase().includes(search.toLowerCase()) 
        )
      "
      style="width: 100%"
      height="500px"
    >
      <el-table-column prop="authNum" label="用户权限编号" width="160"></el-table-column>
      <el-table-column prop="powName" label="拥有的功能" width="160"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getStus } from "@/network/student.js";
import { getcours } from "@/network/cour.js";
import { getAuth } from "@/network/system.js";

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
    getAuth(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      // console.log(res.map.stus.list);
      this.tableData = res.map.auth;
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