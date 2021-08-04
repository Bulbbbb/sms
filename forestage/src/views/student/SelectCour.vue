<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.week.toLowerCase().includes(search.toLowerCase()) ||
            data.cName.toLowerCase().includes(search.toLowerCase()) ||
            data.cNum.toLowerCase().includes(search.toLowerCase()) ||
            data.cIns.toLowerCase().includes(search.toLowerCase()) ||
            data.cla.toLowerCase().includes(search.toLowerCase()) ||
            data.cGra.toLowerCase().includes(search.toLowerCase()) ||
            data.cTime.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
      height="560px"
    >
      <el-table-column
        prop="cName"
        label="课程名"
        width="160"
      ></el-table-column>
      <el-table-column prop="cNum" label="编号" width="160"></el-table-column>
      <el-table-column
        prop="cIns"
        label="开课机构"
        width="200"
      ></el-table-column>
      <el-table-column prop="week" label="星期" width="100"></el-table-column>
      <el-table-column prop="cla" label="节" width="100"></el-table-column>
      <el-table-column prop="cTime" label="学时" width="100"></el-table-column>
      <el-table-column prop="cGra" label="学分" width="100"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mxini"
            @click="handleEdit(scope.$index, scope.row)"
            type="primary"
            >选课</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getSelectCour } from "@/network/cour.js";
import { addXuanke } from "@/network/xuanke.js";
// import { getXuanke } from "@/network/xuanke.js";

export default {
  computed: {},
  data() {
    return {
      users: [],
      tableData: [],
      search: "",
      caozuo: "选课",
      isS: [],
    };
  },
  methods: {
    // a(index,row) {
    //   console.log(this.tableData[index]);
    //   getXuanke(
    //     this.$store.state.userMsg.sNum,
    //     row.cNum,
    //     this.$store.state.userMsg.sNum
    //   ).then((res) => {
    //     if (res.map.xuanKe.length == 0) {
    //       this.$refs.singleTable.setCurrentRow(this.tableData[index]);
    //       // console.log(res.map.xuanKe.length == 0);
    //     }else{
    //     }
    //   });
    //   console.log(this.isS[index]);
    // },
    handleEdit(index, row, a) {
      let xuanke = {};
      xuanke = row;
      xuanke.sName = this.$store.state.userMsg.sName;
      xuanke.sNum = this.$store.state.userMsg.sNum;

      console.log(index, xuanke);
      addXuanke(xuanke, this.$store.state.userMsg.sNum).then((res) => {
        console.log(res);
      });
    },
  },
  created() {
    getSelectCour(this.$store.state.userMsg.sNum).then((res) => {
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
.el-table .warning-row {
  background: oldlace;
}
</style>