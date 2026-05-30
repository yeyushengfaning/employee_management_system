<template>
  <div>
    <div style="display:flex;gap:8px;margin-bottom:12px;align-items:center">
      <el-input v-model="query.name" placeholder="姓名/用户名" style="width:200px" />
      <el-select v-model="query.gender" placeholder="性别" style="width:120px">
        <el-option :label="'全部'" :value="null"></el-option>
        <el-option label="男" :value="1"></el-option>
        <el-option label="女" :value="2"></el-option>
      </el-select>
      <el-input v-model="query.begin" placeholder="入职时间" style="width:200px" />
      <el-input v-model="query.end" placeholder="离职时间" style="width:200px"/>
      <el-button type="primary" @click="fetchData">查询</el-button>
      <el-button @click="openForm">新增</el-button>
      <el-button type="danger" @click="batchDelete">删除选中</el-button>
    </div>

    <el-table :data="emps" style="width:100%" @selection-change="onSelectionChange">
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="ID" width="70" />
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="deptName" label="部门" />
      <el-table-column prop="job" label="职位">
        <template #default="{ row }">{{ jobMap[row.job] || row.job }}</template>
      </el-table-column>
      <el-table-column prop="phone" label="电话" />
      <el-table-column prop="entryDate" label="入职日期">
        <template #default="{ row }">{{ formatDate(row.entryDate) }}</template>
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="{ row }">
          <el-button size="small" @click="edit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="del(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin-top:12px;display:flex;justify-content:flex-end">
      <el-pagination layout="prev, pager, next" :total="total" v-model:current-page="query.page" :page-size="query.pageSize" @current-change="onPageChange" />
    </div>

    <el-dialog v-model="formVisible" title="员工" width="820px" custom-class="emp-dialog">
      <el-form :model="form" label-width="90px">
        <el-form-item label="用户名"><el-input v-model="form.username" /></el-form-item>
        <el-form-item label="姓名"><el-input v-model="form.name" /></el-form-item>
        <el-form-item label="性别"><el-select v-model="form.gender"><el-option label="男" :value="1"/><el-option label="女" :value="2"/></el-select></el-form-item>
        <el-form-item label="电话"><el-input v-model="form.phone"/></el-form-item>
        <el-form-item label="职位"><el-select v-model="form.job" placeholder="请选择职位">
          <el-option label="班主任" :value="1" />
          <el-option label="讲师" :value="2" />
          <el-option label="学工主管" :value="3" />
          <el-option label="教研主管" :value="4" />
          <el-option label="咨询师" :value="5" />
        </el-select></el-form-item>
        <el-form-item label="部门"><el-select v-model="form.deptId" placeholder="请选择部门">
          <el-option v-for="d in depts" :key="d.id" :label="d.name" :value="d.id" />
        </el-select></el-form-item>

        <!-- 员工经历 -->
        <el-form-item label="经历">
          <div v-for="(expr, idx) in form.exprList" :key="expr.id || idx" class="expr-row">
            <el-date-picker v-model="expr.begin" type="date" value-format="YYYY-MM-DD" placeholder="开始" style="width:130px" />
            <el-date-picker v-model="expr.end" type="date" value-format="YYYY-MM-DD" placeholder="结束" style="width:130px" />
            <el-input v-model="expr.company" placeholder="公司" style="width:220px" />
            <el-input v-model="expr.job" placeholder="职位" style="width:180px" />
            <el-button type="text" @click="removeExpr(idx)">删除</el-button>
          </div>
          <el-button type="primary" size="small" @click="addExpr">新增经历</el-button>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="formVisible=false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { pageEmps, getEmp, saveEmp, updateEmp, deleteEmps } from '../api/emp'
import { ElMessage } from 'element-plus'
import {listDepts} from "../api/dept";

const emps = ref([])
const total = ref(0)
const selected = ref([])
const depts = ref([])

const query = reactive({ name: '', gender: null, begin: null, end: null, page: 1, pageSize: 10})

const formVisible = ref(false)
const form = reactive({ id: null, username: '', name: '', gender: 1, phone: '', job: null, deptId: null, exprList: [] })

const jobMap = { 1: '班主任', 2: '讲师', 3: '学工主管', 4: '教研主管', 5: '咨询师' }

function onSelectionChange(val) { selected.value = val }

function formatDate(d){
  if (!d) return ''
  // 服务器可能返回 LocalDate（yyyy-MM-dd）或 ISO 字符串，简单截取前 10 字符
  return (''+d).substring(0,10)
}

async function fetchData() {
  try {
    const res = await pageEmps({ ...query })
    if (res && res.code === 1) {
      const data = res.data
      emps.value = data.rows || []
      total.value = data.total || 0
    }
  } catch (e) {
    ElMessage.error('取数据失败')
  }
}

async function fetchDepts() {
  try {
    const res = await listDepts()
    if (res && res.code === 1) {
      depts.value = res.data || []
    }
  } catch (e) {
    ElMessage.error('取部门失败')
  }
}

function onPageChange(p) { query.page = p; fetchData() }

function openForm() {
  form.id = null
  form.username = ''
  form.name = ''
  form.gender = 1
  form.phone = ''
  form.job = null
  form.deptId = null
  form.exprList = []
  formVisible.value = true
}

async function edit(row) {
  try {
    const res = await getEmp(row.id)
    if (res && res.code === 1) {
      // ensure exprList exists
      const data = res.data || {}
      data.exprList = data.exprList || []
      Object.assign(form, data)
    } else {
      // fallback: shallow copy
      Object.assign(form, row)
    }
    formVisible.value = true
  } catch (e) {
    // fallback
    Object.assign(form, row)
    formVisible.value = true
    ElMessage.error('加载员工详情失败')
  }
}

async function save() {
  try {
    if (form.id) {
      await updateEmp(form)
    } else {
      await saveEmp(form)
    }
    ElMessage.success('保存成功')
    formVisible.value = false
    fetchData()
  } catch (e) {
    ElMessage.error('保存失败')
  }
}

async function del(row) {
  try {
    await deleteEmps([row.id])
    ElMessage.success('删除成功')
    fetchData()
  } catch (e) {
    ElMessage.error('删除失败')
  }
}

async function batchDelete() {
  if (!selected.value.length) return ElMessage.warning('请选择要删除的记录')
  const ids = selected.value.map(i => i.id)
  try {
    await deleteEmps(ids)
    ElMessage.success('删除成功')
    fetchData()
  } catch (e) {
    ElMessage.error('删除失败')
  }
}

function addExpr() {
  form.exprList.push({ begin: null, end: null, company: '', job: '' })
}

function removeExpr(idx) {
  form.exprList.splice(idx, 1)
}

onMounted(()=>{
fetchData();fetchDepts()
})
</script>

<style scoped>
.expr-row{
  display:flex;
  flex-wrap:wrap;
  gap:8px;
  align-items:center;
  margin-bottom:8px;
}
.expr-row > *{ flex: 0 1 auto; }
.expr-row .el-input__inner, .expr-row .el-date-editor, .expr-row .el-picker-panel{ min-width:0; }
::v-deep .emp-dialog .el-dialog__body{max-height:50vh;overflow:auto}
</style>
