<template>
  <div>
    <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />

    <el-table
      ref="filterTable"
      :data="
        tableData.filter(
          (data) =>
            !search ||
            data.uName.toLowerCase().includes(search.toLowerCase()) ||
            data.uNum.toLowerCase().includes(search.toLowerCase()) ||
            data.uSex.toLowerCase().includes(search.toLowerCase()) ||
            data.uJob.toLowerCase().includes(search.toLowerCase()) ||
            data.uEdu.toLowerCase().includes(search.toLowerCase()) ||
            data.uIn.toLowerCase().includes(search.toLowerCase()) 
        )
      "
      style="width: 100%"
      height="530"
    >
      <el-table-column prop="uName" label="姓名" width="160"></el-table-column>
      <el-table-column prop="uNum" label="工号" width="160"></el-table-column>
      <el-table-column prop="uSex" label="性别" width="160"></el-table-column>
      <el-table-column prop="uJob" label="职位" width="160"></el-table-column>
      <el-table-column prop="uEdu" label="学历" width="160"></el-table-column>
      <el-table-column prop="uIn" label="入职年份" width="160" ></el-table-column>
      <!-- <el-table-column prop="uIns" label="所属机构" width="200" ></el-table-column> -->
      <!-- <el-table-column prop="uPhone" label="电话" width="200"></el-table-column>
      <el-table-column prop="uEmail" label="邮箱" width="200"></el-table-column>
      <el-table-column prop="uBirth" label="出生年份" width="200"></el-table-column>
      <el-table-column prop="tAuth" label="权限" width="200"></el-table-column>
      <el-table-column prop="uPwd" label="密码" width="200"></el-table-column> -->
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
import { getUser } from "@/network/system.js";

export default {
  data() {
    return {
      users: [],
      tableData: [],
      search:"",
    };
  },
  methods: {
    open(index, row) {
      const h = this.$createElement;
      this.$msgbox({
        title: "教师信息",
        message: h("p", null, [
          h("i", { style: "color: teal;text-align:center" }, "姓名："+row.uName),
          h("br"),
          h("i", { style: "color: teal" }, "工号："+row.uNum),
          h("br"),
          h("i", { style: "color: teal" }, "性别："+row.uSex),
          h("br"),
          h("i", { style: "color: teal" }, "职位："+row.uJob),
          h("br"),
          h("i", { style: "color: teal" }, "学历："+row.uEdu),
          h("br"),
          h("i", { style: "color: teal" }, "所属机构："+row.uIns),
          h("br"),
          h("i", { style: "color: teal" }, "电话："+row.uPhone),
          h("br"),
          h("i", { style: "color: teal" }, "邮箱："+row.uEmail),
          h("br"),
          h("i", { style: "color: teal" }, "出生年份："+row.uBirth),
          h("br"),
          h("i", { style: "color: teal" }, "权限："+row.tAuth),
          h("br"),
          h("i", { style: "color: teal" }, "密码："+row.uPwd),
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
    getUser(this.$store.state.userMsg.uNum).then((res) => {
      // this.ableData=res.map.stus.list
      //   console.log(res.map.stus.list);
      this.tableData = res.map.user;
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