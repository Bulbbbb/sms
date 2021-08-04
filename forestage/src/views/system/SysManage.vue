<template>
  <div>
    <el-tabs :tab-position="tabPosition" style="height: 200px;">
    <el-tab-pane label="权限查询">
      <sys-show></sys-show>
    </el-tab-pane>
    <el-tab-pane label="权限修改">
      <sys-update></sys-update>
    </el-tab-pane>
  </el-tabs>
  </div>
</template>

<script>
import SysShow from './SysShow.vue';
import SysUpdate from './SysUpdate.vue';
  export default {
  components: { SysShow ,SysUpdate},
    data() {
    SysUpdate
    SysUpdate
      return {
        tabPosition: 'left'
      };
    }
  };
</script>

<style>

</style>