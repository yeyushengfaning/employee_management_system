<template>
  <div>
    <h3>按职位统计</h3>
    <div style="display:flex;gap:24px;align-items:flex-start">
      <div style="width:480px;">
        <div ref="jobChart" style="width:100%;height:300px"></div>
        <el-table :data="jobTable" style="width:100%;margin-top:8px">
          <el-table-column prop="job" label="职位"/>
          <el-table-column prop="count" label="人数"/>
        </el-table>
      </div>

      <div style="width:360px;">
        <div ref="genderChart" style="width:100%;height:300px"></div>
        <el-table :data="genderTable" style="width:100%;margin-top:8px">
          <el-table-column prop="gender" label="性别"/>
          <el-table-column prop="count" label="人数"/>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { empJobData, empGenderData } from '../api/report'
import { ElMessage } from 'element-plus'

const jobTable = ref([])
const genderTable = ref([])
const jobChart = ref(null)
const genderChart = ref(null)
let jobChartInst = null
let genderChartInst = null

function renderJobChart(){
  if (!jobChart.value) return
  jobChartInst = echarts.init(jobChart.value)
  const categories = jobTable.value.map(i => i.job)
  const counts = jobTable.value.map(i => i.count)
  const option = {
    title: { text: '职位人数统计', left: 'center' },
    tooltip: {},
    xAxis: { type: 'category', data: categories },
    yAxis: { type: 'value' },
    series: [{ type: 'bar', data: counts }]
  }
  jobChartInst.setOption(option)
}

function renderGenderChart(){
  if (!genderChart.value) return
  genderChartInst = echarts.init(genderChart.value)
  const option = {
    title: { text: '性别分布', left: 'center' },
    tooltip: { trigger: 'item' },
    series: [{ type: 'pie', radius: '55%', data: genderTable.value.map(i=>({ name:i.gender, value:i.count })) }]
  }
  genderChartInst.setOption(option)
}

async function fetchJobs(){
  try{
    const res = await empJobData()
    if (res && res.code === 1){
      const data = res.data || {}
      const jobList = data.jobList || []
      const dataList = data.dataList || []
     jobTable.value = jobList.map((j, idx) => ({ job: j, count: dataList[idx] || 0 }))
      renderJobChart()
    }
  }catch(e){ ElMessage.error('取职位数据失败') }
}

async function fetchGender(){
  try{
    const res = await empGenderData()
    if (res && res.code === 1){
      const data = res.data || {}
      // 后端返回 [{ name: '男性员工', value: 10 }, { name: '女性员工', value: 5 }]
      if (Array.isArray(data)){
        genderTable.value = data.map(item => ({ gender: item.name || item.gender || item.label, count: item.value || item.count || 0 }))
      } else if (data.male !== undefined){
        genderTable.value = [{ gender: '男', count: data.male }, { gender: '女', count: data.female }]
      } else {
        genderTable.value = Object.keys(data).map(k=>({ gender:k, count: data[k] }))
      }
      renderGenderChart()
    }
  }catch(e){ ElMessage.error('取性别数据失败') }
}

onMounted(()=>{ fetchJobs(); fetchGender() })

window.addEventListener('resize', ()=>{
  try{ jobChartInst && jobChartInst.resize(); genderChartInst && genderChartInst.resize() }catch(e){}
})
</script>

<style scoped></style>
