// ...existing code...
import api from './index'

export function empJobData() {
  return api.get('/report/empJobData')
}

export function empGenderData() {
  return api.get('/report/empGenderData')
}

