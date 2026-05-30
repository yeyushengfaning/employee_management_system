<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 style="text-align:center;margin-bottom:16px;">EMS 登录</h2>
      <el-form :model="form" ref="formRef" label-width="0px">
        <el-form-item>
          <el-input v-model="form.username" placeholder="用户名" />
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.password" type="password" placeholder="密码" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit" style="width:100%">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { useAuthStore } from '../store/auth'
import { login } from '../api/auth'
import { ElMessage } from 'element-plus'

const router = useRouter()
const route = useRoute()
const auth = useAuthStore()
const formRef = ref(null)
const form = ref({ username: '', password: '' })

async function onSubmit() {
  if (!form.value.username || !form.value.password) {
    ElMessage.warning('请输入用户名和密码')
    return
  }
  try {
    const res = await login(form.value.username, form.value.password)
    // 后端返回格式：{ code: 1, msg: '', data: { token: '...', name: '...', id: 1 } }
    if (res && res.code === 1) {
      const info = res.data
      auth.setToken(info.token)
      auth.setUser(info)
      ElMessage.success('登录成功')
      const redirect = route.query.redirect || '/'
      router.push(redirect)
    } else {
      ElMessage.error(res.msg || '登录失败')
    }
  } catch (e) {
    ElMessage.error('请求失败')
  }
}
</script>

<style scoped>
.login-container{ display:flex; align-items:center; justify-content:center; height:100vh; background:#f5f7fa }
.login-card{ width:360px; padding:20px }
</style>
