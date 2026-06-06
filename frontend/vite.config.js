import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  server: {
    port: 5173,
    proxy: {
      // 前端请求以 /api 开头会被代理到后端根路径；不要去掉 /api 前缀，后端的 ApiPrefixController 会兼容 /api 前缀
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
        // rewrite: (path) => path.replace(/^\/api/, '')  // 已移除：保留 /api 前缀以便后端识别为 API 请求
      }
    }
  }
})
