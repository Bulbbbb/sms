<template>
  <div>
    <!--limit:最大上传数，on-exceed：超过最大上传数量时的操作  -->
    <el-upload
      class="upload-demo"
      action=""
      :on-change="handleChange"
      :on-remove="handleRemove"
      :on-exceed="handleExceed"
      :limit="limitUpload"
      accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
      :auto-upload="false"
    >
      <el-button @click="exportExcel" slot="tip" size="small" type="primary"
        >下载上传模板</el-button
      >
      <el-button slot="trigger" size="small" type="primary"
        >选取上传文件</el-button
      >
      <el-button
        style="margin-left: 10px"
        size="small"
        type="success"
        @click="update"
        >上传到服务器</el-button
      >
      <!-- <div slot="tip" class="el-upload__tip">只 能 上 传 xlsx / xls 文 件</div> -->
    </el-upload>

    <!-- 数据展示 -->
    <el-main>
      <el-table :data="da" class="mytable" height="530">
        <el-table-column prop="uName" label="姓名"> </el-table-column>
        <el-table-column prop="uNum" label="工号"> </el-table-column>
        <el-table-column prop="uSex" label="性别"> </el-table-column>
        <el-table-column prop="uJob" label="职位"> </el-table-column>
        <el-table-column prop="uEdu" label="学历"> </el-table-column>
        <el-table-column prop="uIns" label="所属机构"> </el-table-column>
      </el-table>
    </el-main>

    <!-- <div v-if="dalen>0" >
        <div v-for="(value, key) in da" :key="key" style="float: left;width: 30%;">
            <p>编号:{{value.code}}</p>
            <p>姓名:{{value.name}}</p>
            <p>省份:{{value.pro}}</p>
            <p>城市:{{value.cit}}</p>
            <p>区县:{{value.dis}}</p>   
            <p>区县:{{value.cla}}</p>   
        </div>
    </div> -->
  </div>
</template>
<script>
import { teacherBat } from "@/network/batchentry.js";

export default {
  props: {
    tHeader: {
      type: Array,
      default: function () {
        return ["姓名", "工号", "性别", "职位", "学历", "所属机构"];
      },
    },
  },
  data() {
    return {
      limitUpload: 1,
      fileTemp: null,
      file: null,
      da: [],
      dalen: 0,
      // tHeader : ['姓名', '学号','性别','学院','专业','班级']
    };
  },
  methods: {
    update() {
      teacherBat(this.da, this.$store.state.userMsg.uNum).then((res) => {
        // console.log(res);
        if (typeof res == "undefined") {
          this.$notify.error({
            title: "添加失败",
            message: "请检查录入信息",
          });
        } else if (res.code === "100") {
          this.$notify({
            title: "添加成功",
            type: "success",
          });
        } else if (typeof res == undefined) {
          this.$notify.error({
            title: "添加失败",
            message: "请检查录入信息",
          });
        }
      });
      // console.log(this.da);
    },
    exportExcel() {
      require.ensure([], () => {
        const { export_json_to_excel } = require("@/vendor/Export2Excel.js");
        const tHeader = this.tHeader;
        // 上面设置Excel的表格第一行的标题
        const filterVal = ["uName", "uNum", "uSex", "uJob", "uEdu", "uIns"];
        // 上面的index、nickName、name是tableData里对象的属性
        const list = this.da; //把data里的tableData存到list
        const data = this.formatJson(filterVal, list);
        export_json_to_excel(tHeader, data, "列表excel");
      });
    },

    formatJson(filterVal, jsonData) {
      return jsonData.map((v) => filterVal.map((j) => v[j]));
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleChange(file, fileList) {
      this.fileTemp = file.raw;
      if (this.fileTemp) {
        if (
          this.fileTemp.type ==
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" ||
          this.fileTemp.type == "application/vnd.ms-excel"
        ) {
          this.importfxx(this.fileTemp);
        } else {
          this.$message({
            type: "warning",
            message: "附件格式错误，请删除后重新上传！",
          });
        }
      } else {
        this.$message({
          type: "warning",
          message: "请上传附件！",
        });
      }
    },
    handleExceed() {
      this.$message({
        type: "warning",
        message: "超出最大上传文件数量的限制！",
      });
      return;
    },
    handleRemove(file, fileList) {
      this.fileTemp = null;
    },
    importfxx(obj) {
      let _this = this;
      let inputDOM = this.$refs.inputer;
      // 通过DOM取文件数据

      this.file = event.currentTarget.files[0];

      var rABS = false; //是否将文件读取为二进制字符串
      var f = this.file;

      var reader = new FileReader();
      //if (!FileReader.prototype.readAsBinaryString) {
      FileReader.prototype.readAsBinaryString = function (f) {
        var binary = "";
        var rABS = false; //是否将文件读取为二进制字符串
        var pt = this;
        var wb; //读取完成的数据
        var outdata;
        var reader = new FileReader();
        reader.onload = function (e) {
          var bytes = new Uint8Array(reader.result);
          var length = bytes.byteLength;
          for (var i = 0; i < length; i++) {
            binary += String.fromCharCode(bytes[i]);
          }
          var XLSX = require("xlsx");
          if (rABS) {
            wb = XLSX.read(btoa(fixdata(binary)), {
              //手动转化
              type: "base64",
            });
          } else {
            wb = XLSX.read(binary, {
              type: "binary",
            });
          }
          outdata = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]); //outdata就是你想要的东西
          console.log("未处理的原始数据如下：");
          console.log(outdata);
          //此处可对数据进行处理
          let arr = [];
          // ["姓名", "工号", "性别","职位", "机构"];
          outdata.map((v) => {
            let obj = {};
            obj.uName = v["姓名"];
            obj.uNum = v["工号"];
            obj.uSex = v["性别"];
            obj.uJob = v["职位"];
            obj.uEdu = v["学历"];
            obj.uIns = v["所属机构"];
            arr.push(obj);
          });
          _this.da = arr;
          _this.dalen = arr.length;
          return arr;
        };
        reader.readAsArrayBuffer(f);
      };
      if (rABS) {
        reader.readAsArrayBuffer(f);
      } else {
        reader.readAsBinaryString(f);
      }
    },
  },
};
</script>
