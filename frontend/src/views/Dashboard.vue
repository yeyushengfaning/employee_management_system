<template>
  <div class="dashboard page-container">
    <section class="hero">
      <div class="hero-left">
        <h1>欢迎使用 EMS 管理系统</h1>
        <p class="lead">轻量化、可扩展的员工管理后台。试试侧边栏导航中的各项功能。</p>
        <div class="quick-actions">
          <router-link to="/emps" class="btn">员工管理</router-link>
          <router-link to="/depts" class="btn outline">部门管理</router-link>
          <router-link to="/reports" class="btn">报表中心</router-link>
          <router-link to="/logs" class="btn outline">系统日志</router-link>
        </div>
      </div>
      <div class="hero-right">
        <div class="stats-grid">
          <div class="stat-card">
            <div class="stat-num">{{ stats.emps }}</div>
            <div class="stat-label">在职员工</div>
          </div>
          <div class="stat-card">
            <div class="stat-num">{{ stats.depts }}</div>
            <div class="stat-label">部门数</div>
          </div>
          <div class="stat-card">
            <div class="stat-num">{{ stats.reports }}</div>
            <div class="stat-label">报表</div>
          </div>
          <div class="stat-card">
            <div class="stat-num">{{ stats.logs }}</div>
            <div class="stat-label">操作日志</div>
          </div>
        </div>
      </div>
    </section>

    <section class="panel">
      <h2>最近操作日志</h2>
      <ul class="log-list">
        <li v-for="(l, i) in recentLogs" :key="i">
          <span class="time">{{ l.time }}</span>
          <span class="text">{{ l.text }}</span>
          <span class="user">{{ l.user }}</span>
        </li>
      </ul>
    </section>

    <section class="panel">
      <h2>快速提示</h2>
      <ul class="tips">
        <li>使用员工管理可以新增、编辑和导出员工数据。</li>
        <li>部门管理用于设置组织结构与岗位选项。</li>
        <li>系统日志记录所有重要操作，便于审计与回溯。</li>
      </ul>
    </section>
  </div>
</template>

<script setup>
import { reactive } from 'vue'

const stats = reactive({ emps: 31, depts: 6, reports: 2, logs: 24 })
const recentLogs = [
  { time: '2026-05-19 09:12', text: '新增员工：张三（岗位：开发）', user: 'admin' },
  { time: '2026-05-18 15:40', text: '更新部门：市场部 -> 市场与品牌部', user: 'lihua' },
  { time: '2026-05-17 11:03', text: '导出员工报表（全部）', user: 'admin' },
]
</script>

<style scoped>
.dashboard{ padding:20px }

.page-container { max-width:1100px; margin: 28px auto; }
.hero { display:flex; gap:24px; align-items:stretch; margin-bottom:20px; }
.hero-left { flex:1; background: rgba(255,255,255,0.9); padding:24px; border-radius:12px; box-shadow: 0 6px 18px rgba(16,24,40,0.06); }
.hero-right { width:360px; }
.lead { color:var(--muted, #6b7280); margin-top:6px }
.quick-actions { margin-top:14px; display:flex; gap:10px; flex-wrap:wrap }
.btn{ display:inline-block; padding:8px 14px; background:var(--primary, #3b82f6); color:#fff; border-radius:8px; text-decoration:none }
.btn.outline{ background:transparent; color:var(--primary, #3b82f6); border:1px solid rgba(0,0,0,0.08) }

.stats-grid{ display:grid; grid-template-columns:repeat(2,1fr); gap:12px }
.stat-card{ background: linear-gradient(180deg, #fff, #fbfbff); padding:16px; border-radius:10px; text-align:center; box-shadow: 0 4px 12px rgba(16,24,40,0.04) }
.stat-num{ font-size:20px; font-weight:700; color:var(--primary, #3b82f6) }
.stat-label{ color:var(--muted, #6b7280); margin-top:6px }

.panel{ background:rgba(255,255,255,0.9); padding:16px; border-radius:10px; margin-bottom:16px; box-shadow: 0 6px 18px rgba(16,24,40,0.04) }
.log-list{ list-style:none; padding:0; margin:0 }
.log-list li{ display:flex; gap:12px; padding:8px 0; border-bottom:1px dashed #eee; align-items:center }
.log-list .time{ color:var(--muted, #6b7280); width:150px; font-size:13px }
.log-list .text{ flex:1 }
.log-list .user{ color:var(--muted, #6b7280); font-size:13px }

.tips{ margin:0; padding-left:18px }
.tips li{ margin:8px 0 }

/* responsive */
@media (max-width:900px){
  .hero{ flex-direction:column }
  .hero-right{ width:100% }
}
</style>
