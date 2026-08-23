import { http } from './http';
import type { Pedido } from '../models/pedido';

export const pedidoService = {
  getById: (id: number) => http.get<Pedido>(`/pedidos/${id}`),
  listMine: () => http.get<Pedido[]>('/pedidos/meus'),
  create: (pedido: Partial<Pedido>) => http.post<Pedido>('/pedidos', pedido),
  addItem: (id: number, produtoId: number, quantidade: number) => http.post<Pedido>(`/pedidos/${id}/itens`, { produtoId, quantidade }),
  updateItemQuantity: (id: number, itemId: number, quantidade: number) => http.put<Pedido>(`/pedidos/${id}/itens/${itemId}`, { quantidade }),
  removeItem: (id: number, itemId: number) => http.delete<Pedido>(`/pedidos/${id}/itens/${itemId}`),
  confirm: (id: number) => http.post<Pedido>(`/pedidos/${id}/confirmar`)
};
