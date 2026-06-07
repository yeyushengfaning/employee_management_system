<template>
  <div>
    <div style="display:flex;gap:8px;margin-bottom:12px;align-items:center">
      <el-button type="primary" @click="openForm">新增</el-button>
    </div>

    <el-table :data="depts" style="width:100%">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="name" label="部门名称" />
      <el-table-column prop="createTime" label="创建时间">
        <template #default="{ row }">{{ formatDate(row.createTime) }}</template>
      </el-table-column>
      <el-table-column label="操作" width="160">
        <template #default="{ row }">
          <el-button size="small" @click="edit(row)">编辑</el-button>
          <el-button size="small" type="danger" @click="del(row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
<!--其次，v-model:visible 和 v-model="..." 并不是绝对的“错/对”关系——哪一种可用取决于组件对 v-model 的 API 定义（prop 名称和触发的 update 事件）。-->
<!--有些组件定义了 visible 作为其可绑定的 prop（支持 v-model:visible / update:visible），而很多 Vue 3 + 组件库（或其新版本）使用统一的 modelValue/update:modelValue，这时普通的 v-model 是正确的用法。-->
    <el-dialog v-model="formVisible" title="部门" @closed="onDialogClosed">
      <el-form :model="form" label-width="90px">
        <el-form-item label="名称"><el-input ref="nameInput" v-model="form.name" /></el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="formVisible=false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </template>
    </el-dialog>

  </div>

</template>

<script setup>
import { ref, reactive, onMounted, nextTick } from 'vue'
import { listDepts, saveDept, updateDept, deleteDept, getDept } from '../api/dept'
import { ElMessage } from 'element-plus'

const depts = ref([])
const formVisible = ref(false)
const form = reactive({ id: null, name: '' })
const nameInput = ref(null)

function formatDate(d){ if (!d) return ''; return (''+d).substring(0,19).replace('T',' ') }

async function fetch() {
  try {
    const res = await listDepts()
    if (res && res.code === 1) {
      depts.value = res.data || []
    }
  } catch (e) {
    ElMessage.error('取部门失败')
  }
}

function openForm(){
  form.id = null; form.name = '';
  formVisible.value = true;
  nextTick(() => {
    if (nameInput.value && nameInput.value.focus) nameInput.value.focus()
  })
 }

async function edit(row){
  try{
    const res = await getDept(row.id)
    if (res && res.code === 1){
      Object.assign(form, res.data);
      formVisible.value = true;
      // focus the input after dialog opens
      nextTick(() => {
        if (nameInput.value && nameInput.value.focus) nameInput.value.focus()
      })
    }
  }catch(e){ console.error('Depts: read error', e); ElMessage.error('读取失败') }
}

async function save(){
  try{
    let res
    if (form.id) res = await updateDept(form)
    else res = await saveDept(form)
    if (res && res.code === 1) {
      ElMessage.success('保存成功')
      formVisible.value = false
      fetch()
    } else {
      ElMessage.error((res && res.msg) || '保存失败')
    }
  }catch(e){ console.error('Depts: save error', e); ElMessage.error('保存失败') }
}

async function del(row){
  try{
    const res = await deleteDept(row.id)
    if (res && res.code === 1) {
      ElMessage.success('删除成功')
      fetch()
    } else {
      ElMessage.error((res && res.msg) || '删除失败')
    }
  }catch(e){ ElMessage.error('删除失败') }
}

function onDialogClosed(){
  form.id = null
  form.name = ''
}

onMounted(fetch)
</script>

<style scoped>
</style>
