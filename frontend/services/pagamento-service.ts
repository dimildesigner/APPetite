import { http } from './http';
import type { FormaPagamento, Pagamento } from '../models/pagamento';

export const pagamentoService = {
  getById: (id: number) => http.get<Pagamento>(`/pagamentos/${id}`),
  start: (pedidoId: number, formaPagamento: FormaPagamento) => http.post<Pagamento>(`/pagamentos/pedido/${pedidoId}`, { formaPagamento }),
  approve: (id: number) => http.post<Pagamento>(`/pagamentos/${id}/aprovar`),
  cancel: (id: number) => http.post<Pagamento>(`/pagamentos/${id}/cancelar`)
};
