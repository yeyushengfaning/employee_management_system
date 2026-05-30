// ...existing code...
import api from './index'

export function pageEmps(params) {
  // params: { name, gender, begin, end, page, pageSize }
  return api.get('/emps', { params })
}

export function getEmp(id) {
  return api.get(`/emps/${id}`)
}

export function saveEmp(emp) {
  return api.post('/emps', emp)
}

export function updateEmp(emp) {
  return api.put('/emps', emp)
}

export function deleteEmps(ids) {
  // ids: array
  return api.delete('/emps', { params: { ids } })
}

