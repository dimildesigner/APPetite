import { http } from './http';
import type { MovimentacaoEstoque } from '../models/movimentacao-estoque';

export const estoqueService = {
  listByProduct: (produtoId: number) => http.get<MovimentacaoEstoque[]>(`/estoque/${produtoId}`),
  entry: (produtoId: number, quantidade: number, observacao?: string) => http.post<MovimentacaoEstoque>(`/estoque/${produtoId}/entrada`, { quantidade, observacao }),
  loss: (produtoId: number, quantidade: number, observacao?: string) => http.post<MovimentacaoEstoque>(`/estoque/${produtoId}/perda`, { quantidade, observacao }),
  adjust: (produtoId: number, novoSaldo: number, observacao?: string) => http.put<MovimentacaoEstoque>(`/estoque/${produtoId}/ajuste`, { novoSaldo, observacao })
};
