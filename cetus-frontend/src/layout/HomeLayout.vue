<script setup>
import '@/style/el.css'
</script>

<template>
  <div>
    <el-container>
      <el-header class="el-header">Header</el-header>
      <router-view></router-view>
      <el-footer class="el-footer">Footer</el-footer>
    </el-container>
  </div>
</template>

<style scoped>

</style>