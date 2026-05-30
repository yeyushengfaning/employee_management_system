// ...existing code...
import api from './index'

export function pageLogs(page=1, pageSize=10) {
  return api.get('/log/page', { params: { page, pageSize } })
}

