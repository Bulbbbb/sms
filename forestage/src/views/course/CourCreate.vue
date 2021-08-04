<template>
  <el-form label-width="80px" size="mini" :model="cour" :ref="cour">
    <el-form-item
      label="课程名称"
      prop="cName"
      :rules="[{ required: true, message: '请输入课程姓名', trigger: 'blur' }]"
    >
      <el-input v-model="cour.cName"></el-input>
    </el-form-item>
    <el-form-item
      label="课程编号"
      prop="cNum"
      :rules="[{ required: true, message: '请输入课程编号', trigger: 'blur' }]"
    >
      <el-input v-model="cour.cNum"></el-input>
    </el-form-item>
    <el-form-item label="开设机构">
      <el-select v-model="cour.cIns" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in ins"
          :key="index"
          :label="value.iName"
          :value="value.iName"
          :major="value.iName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="是否可选"  prop="isSel" 
    :rules="[{ required: true, message: '请输入课程编号', trigger: 'blur' }]">
      <el-select v-model="isSel" placeholder="请选择活动区域">
        <el-option label='是' value="是" major="是" ></el-option>
        <el-option label='否' value="否" major="否" ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item
      label="学分"
      prop="cGra"
      :rules="[{ required: true, message: '请输入学分', trigger: 'blur' }]"
    >
      <el-input v-model="cour.cGra"></el-input>
    </el-form-item>
    <el-form-item
      label="学时"
      prop="cTime"
      :rules="[{ required: true, message: '请输入学时', trigger: 'blur' }]"
    >
      <el-input v-model="cour.cTime"></el-input>
    </el-form-item>
    <!-- <el-form-item label="所属专业">
      <el-select v-model="majName" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in majs"
          :key="index"
          :label="value.mName"
          :value="value.mName"
          :major="value.mName"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="所属班级">
      <el-select v-model="className" placeholder="请选择活动区域">
        <el-option
          v-for="(value, index) in clas"
          :key="index"
          :label="value.cName"
          :value="value.cName"
          :major="value.cName"
        ></el-option>
      </el-select>
    </el-form-item> -->
    <el-form-item label="星期"  prop="week" 
    :rules="[{ required: isTrue, message: '请输入课程时间', trigger: 'blur' }]" >
      <el-select v-model="cour.week" placeholder="请选择" >
        <el-option label='1'  value="1"  major="1" ></el-option>
        <el-option label='2'  value="2"  major="2" ></el-option>
        <el-option label='3'  value="3"  major="3" ></el-option>
        <el-option label='4'  value="4"  major="4" ></el-option>
        <el-option label='5'  value="5"  major="5" ></el-option>
        <el-option label='六' value="六" major="六" ></el-option>
        <el-option label='天' value="天" major="天" ></el-option>
      </el-select>
    </el-form-item>   
    <el-form-item label="节"  prop="cla" 
    :rules="[{ required: isTrue, message: '请输入上课时间', trigger: 'blur' }]" >
      <el-select v-model="cour.cla" placeholder="请选择" >
        <el-option label='1'  value="1"  major="1" ></el-option>
        <el-option label='2'  value="2"  major="2" ></el-option>
        <el-option label='3'  value="3"  major="3" ></el-option>
        <el-option label='4'  value="4"  major="4" ></el-option>
        <el-option label='5'  value="5"  major="5" ></el-option>
      </el-select>
    </el-form-item>   
    <el-form-item size="large">
      <el-button type="primary" @click="onSubmit(cour)"
        >立即创建</el-button
      >
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { getIns } from "@/network/cour.js";
import { getMajs } from "@/network/cour.js";
import { getcla } from "@/network/cour.js";
import { courCreate } from "@/network/cour.js";
export default {
  components: {},
  data() {
    return {
      cour:{
        cName:"",
        cNum:"",
        cIns:"",
        isSel:"",
        cGra:"",
        cTime:"",
        week:"",
        cla:""
      },
      ins: [],
      isSel:"",
      isTrue:false
    };
  },
  watch: {
    isSel(val,oldval){
      this.cour.isSel=val;
      if (val==='是') {
        this.isTrue=true
      }else{
        this.isTrue=false
      }
    },
    institution(val, oldval) {
      console.log(val);
      getMajs(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.majs = res.map.majs;
          console.log(res);
        }
      );
      this.className = "";
      this.majName="";
    },
    majName(val, oldval) {
      console.log(val);
      getcla(encodeURI(encodeURI(val)), this.$store.state.userMsg.uNum).then(
        (res) => {
          this.clas = res.map.cla;
          console.log(res);
        }
      );
      this.className = "";
    },
  },
  methods: {
    onSubmit(formName) {
      // console.log(formName);
      // console.log(res);
      this.$refs[formName].validate((valid) => {
        if (valid) {
          courCreate(this.cour,this.$store.state.userMsg.uNum).then((res) => {
            console.log(res);
            if (typeof res == "undefined") {
              this.$notify.error({
                title: "提交失败",
                // message: "请检查该专业编号是否已存在",
              });
            } else if (res.code == "100") {
              console.log(res);
              this.$notify({
                title: "成功",
                type: "success",
              });
            } else {
              console.log(this.sizeForm.num);
              this.$notify.error({
                title: "提交失败",
                // message: "请检查是否登录",
              });
            }
          });
        } else {
          this.$notify.error({
            title: "提交失败",
            message: "请检查提交信息是否为空",
          });
          return false;
        }
      });
    },
  },
  created() {
    getIns(this.$store.state.userMsg.uNum).then((res) => {
      this.ins = res.map.ins;
      console.log(res);
    });
  },
};
</script>

<style scoped> 
.el-form {
  margin-left: 25%;
}
.el-input {
  width: 300px;
}
.el-button {
  padding: 8px 20px;
}
</style>