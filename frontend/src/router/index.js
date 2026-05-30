import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Dashboard from '../views/Dashboard.vue'
import Layout from '../components/Layout.vue'
import { useAuthStore } from '../store/auth'

// 新增路由组件懒加载
const Emps = () => import('../views/Emps.vue')
const Depts = () => import('../views/Depts.vue')
const Logs = () => import('../views/Logs.vue')
const Reports = () => import('../views/Reports.vue')

const routes = [
  { path: '/login', component: Login },
  {
    path: '/',
    component: Layout,
    children: [
      { path: '', component: Dashboard },
      { path: 'emps', component: Emps },
      { path: 'depts', component: Depts },
      { path: 'logs', component: Logs },
      { path: 'reports', component: Reports }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 简单路由守卫：未登录跳转到 /login，并带上 redirect 参数
router.beforeEach((to, from, next) => {
  const auth = useAuthStore()
  if (to.path !== '/login' && !auth.token) return next({ path: '/login', query: { redirect: to.fullPath } })
  next()
})

export default router
