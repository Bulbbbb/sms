<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.sName.toLowerCase().includes(search.toLowerCase()) ||
            data.sNum.toLowerCase().includes(search.toLowerCase()) ||
            data.sCla.toLowerCase().includes(search.toLowerCase()) ||
            data.sIn.toLowerCase().includes(search.toLowerCase()) ||
            data.sIns.toLowerCase().includes(search.toLowerCase()) ||
            data.sMaj.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
      height="530"
    >
      <el-table-column prop="sName" label="姓名" width="160"></el-table-column>
      <el-table-column prop="sNum" label="学号" width="160"></el-table-column>
      <el-table-column prop="sCla" label="班级" width="160"></el-table-column>
      <el-table-column prop="sIn" label="年级" width="160"></el-table-column>
      <el-table-column prop="sIns" label="学院" width="160"></el-table-column>
      <el-table-column prop="sMaj" label="专业" width="200"></el-table-column>
            <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="open(scope.$index, scope.row)"
            >详情</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getStus } from "@/network/student.js";

export default {
  data() {
    return {
      users: [],
      tableData: [],
      search: "",
    };
  },
  methods: {
    open(index, row) {
      const h = this.$createElement;
      this.$msgbox({
        title: "学生信息",
        message: h("p", null, [
          h("i", { style: "color: teal;text-align:center" }, "姓名："+row.sName),
          h("br"),
          h("i", { style: "color: teal" }, "学号："+row.sNum),
          h("br"),
          h("i", { style: "color: teal" }, "性别："+row.sSex),
          h("br"),
          h("i", { style: "color: teal" }, "入学年份："+row.sIn),
          h("br"),
          h("i", { style: "color: teal" }, "所属学院："+row.sIns),
          h("br"),
          h("i", { style: "color: teal" }, "所属专业："+row.sMaj),
          h("br"),
          h("i", { style: "color: teal" }, "所属班级："+row.sCla),
          h("br"),
          h("i", { style: "color: teal" }, "电话："+row.sPhone),
          h("br"),
          h("i", { style: "color: teal" }, "出生年份："+row.sBirth),
          h("br"),
          h("i", { style: "color: teal" }, "地址："+row.sAddr),
          h("br"),
          h("i", { style: "color: teal" }, "邮箱："+row.sEmail),
          h("br"),
          h("i", { style: "color: teal" }, "权限："+row.sAuth),
          h("br"),
          h("i", { style: "color: teal" }, "密码："+row.sPwd),
          h("br"),
          h("i", { style: "color: teal" }, "状态："+row.sState),
          h("br"),
        ]),
        // showCancelButton: true,
        cancelButtonText: "确定",
        cancelButtonText: "取消",
        beforeClose: (action, instance, done) => {
          // if (action === "confirm") {
          //   instance.confirmButtonLoading = true;
          //   instance.confirmButtonText = "执行中...";
          //   setTimeout(() => {
          //     done();
          //     setTimeout(() => {
          //       instance.confirmButtonLoading = false;
          //     }, 300);
          //   }, 3000);
          // } else {
            done();
          // }
        },
      }).then((action) => {
        // this.$message({
        //   type: "info",
        //   message: "action: " + action,
        // });
      });
    },
  },
  created() {
    getStus(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      console.log(res.map.stus.list);
      this.tableData = res.map.stus.list;
      // console.log(res);
    });
  },
};
</script>
<style scoped>
.el-tab-pane {
  height: 100%;
}
</style>