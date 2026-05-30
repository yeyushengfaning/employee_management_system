<template>
  <el-container style="height:100vh">
    <el-aside width="200px" style="background:#2d3a4b;color:#fff">
      <div class="logo">EMS</div>
      <el-menu :default-active="$route.path" class="el-menu-vertical-demo" background-color="transparent" text-color="#fff" active-text-color="#ffd04b" @select="onMenuSelect">
        <el-menu-item index="/">首页</el-menu-item>
        <el-menu-item index="/emps">员工管理</el-menu-item>
        <el-menu-item index="/depts">部门管理</el-menu-item>
        <el-menu-item index="/logs">操作日志</el-menu-item>
        <el-menu-item index="/reports">报表</el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header style="background:#fff;display:flex;justify-content:space-between;align-items:center;padding:0 16px">
        <div></div>
        <div style="display:flex;align-items:center;gap:12px">
          <span v-if="user">{{ user.name }}</span>
          <el-button type="text" @click="logout">退出</el-button>
        </div>
      </el-header>
      <el-main style="padding:16px;overflow:auto">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { useAuthStore } from '../store/auth'
import { useRouter } from 'vue-router'
const auth = useAuthStore()
const router = useRouter()
const user = auth.user
function logout(){
  auth.logout()
  router.push('/login')
}
function onMenuSelect(index){
  router.push(index)
}
</script>

<style scoped>
.logo{ font-size:20px; padding:16px; text-align:center; color:#ffd04b }
</style>
