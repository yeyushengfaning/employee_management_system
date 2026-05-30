import axios from 'axios'
import { useAuthStore } from '../store/auth'

const api = axios.create({
  baseURL: '/api', // 通过 Vite proxy 转发到后端
  timeout: 8000
})

api.interceptors.request.use((config) => {
  try {
    const store = useAuthStore()
    if (store && store.token) {
      config.headers['token'] = store.token
    } else {
      // 如果在非组件环境或 Pinia 未激活，尝试从 localStorage 读取
      const token = localStorage.getItem('token')
      if (token) config.headers['token'] = token
    }
  } catch (e) {
    // 在非组件环境调用时可能失败，退回到 localStorage
    const token = localStorage.getItem('token')
    if (token) config.headers['token'] = token
  }
  // 调试日志：打印请求信息，便于在浏览器或终端定位请求是否发送
  try { console.log('axios request ->', config.method, config.baseURL + config.url, config) } catch(e){}
  return config
})

api.interceptors.response.use(
  (res) => res.data,
  (err) => {
    // 统一处理 401 未授权，清除本地登录信息并跳转到登录页
    if (err && err.response && err.response.status === 401) {
      try { localStorage.removeItem('token'); localStorage.removeItem('user') } catch(e){}
      // 使用 location 替代 router 以避免循环依赖
      window.location.href = '/login'
      return Promise.reject({ message: '请重新登录' })
    }
    return Promise.reject(err)
  }
)

export default api
