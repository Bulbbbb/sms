<template>
  <div>
    <template>
      <el-select v-model="optValue" filterable placeholder="请选择学年">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
      <span class="space"></span>
      <el-select v-model="schValue" filterable placeholder="请选择学期">
        <el-option
          v-for="item in school"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
      <el-button type="primary" icon="el-icon-search" @click="search"
        >搜索</el-button
      >
      <el-table :data="tableData" height="550" style="width: 100%">
        <el-table-column prop="courName" label="课程"> </el-table-column>
        <el-table-column prop="year" label="学年"> </el-table-column>
        <el-table-column prop="school" label="学期"> </el-table-column>
        <el-table-column prop="grade" label="成绩"> </el-table-column>
      </el-table>
    </template>
  </div>
</template>


<script>
import { getAGra } from "@/network/grade.js";

export default {
  data() {
    return {
      year: "",
      options: [
        {
          label: 1,
          value: 1,
        },
        {
          label: 2,
          value: 2,
        },
        {
          label: 3,
          value: 3,
        },
        {
          label: 4,
          value: 4,
        },
        {
          label: 5,
          value: 5,
        },
      ],
      school: [
        {
          label: 1,
          value: 1,
        },
        {
          label: 2,
          value: 2,
        },
        {
          label: 3,
          value: 3,
        },
      ],
      tableData: [],
      optValue: "",
      schValue: "",
    };
  },
  methods: {
    search() {
      this.tableData = [];
      getAGra(
        encodeURI(encodeURI(this.$store.state.userMsg.sName)),
        this.optValue,
        this.schValue,
        this.$store.state.userMsg.sNum
      ).then((res) => {
        this.tableData = res.map.gra;

        console.log(res);
      });
    },
  },
  // created() {
  //   this.year = this.$store.state.userMsg.sIn;
  //   for (let i = 0; i < 5; i++) {
  //     let option = {};
  //     option.label = this.year - -i;
  //     option.value = this.year - -i;
  //     this.options.push(option);
  //     // this.options[i].label=this.year-i;
  //     //  console.log(this.options[i].value);
  //   }
  //   console.log(this.year);
  // },
};
</script>

<style scoped>
.el-select {
  padding-left: 30px;
  padding-right: 30px;
}
</style>