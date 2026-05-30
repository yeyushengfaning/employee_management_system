<template>
  <div>
    <el-table :data="rows" style="width:100%">
      <el-table-column prop="id" label="ID" width="80"/>
      <el-table-column prop="operateEmpName" label="用户"/>
      <el-table-column label="操作">
        <template #default="{ row }">{{ (row.className ? row.className + '.' : '') + (row.methodName || '') }}</template>
      </el-table-column>
      <el-table-column prop="operateTime" label="时间">
        <template #default="{ row }">{{ formatDate(row.operateTime) }}</template>
      </el-table-column>
    </el-table>
    <div style="margin-top:12px;display:flex;justify-content:flex-end">
      <el-pagination layout="prev, pager, next" :total="total" v-model:current-page="page" :page-size="pageSize" @current-change="onPageChange" />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { pageLogs } from '../api/log'
import { ElMessage } from 'element-plus'

const rows = ref([])
const total = ref(0)
const page = ref(1)
const pageSize = ref(10)

function formatDate(d){ if (!d) return ''; return (''+d).substring(0,19).replace('T',' ') }

async function fetch(){
  try{
    const res = await pageLogs(page.value, pageSize.value)
    if (res && res.code === 1){
      const data = res.data
      rows.value = data.rows || []
      total.value = data.total || 0
    }
  }catch(e){ ElMessage.error('取日志失败') }
}

function onPageChange(p){ page.value = p; fetch() }

onMounted(fetch)
</script>

<style scoped></style>
