import { http } from '../api.js';

export const productService = {
  list: () => http.get('/produtos'),
  listActive: () => http.get('/produtos?ativo=true'),
  getById: (id) => http.get(`/produtos/${id}`),
  create: (product) => http.post('/produtos', product),
  update: (id, product) => http.put(`/produtos/${id}`, product),
  remove: (id) => http.delete(`/produtos/${id}`),
  changeStatus: (id, ativo) => http.put(`/produtos/${id}/status?ativo=${ativo}`)
};
