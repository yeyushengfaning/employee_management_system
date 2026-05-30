// ...existing code...
import api from './index'

export function listDepts() {
  return api.get('/depts')
}

export function getDept(id) {
  return api.get(`/depts/${id}`)
}

export function saveDept(dept) {
  return api.post('/depts', dept)
}

export function updateDept(dept) {
  return api.put('/depts', dept)
}

export function deleteDept(id) {
  return api.delete('/depts', { params: { id } })
}

