import api from './index'

export function login(username, password) {
  return api.post('/login', { username, password })
}
