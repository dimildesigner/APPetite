import type { Pedido } from './pedido';

export type FormaPagamento = 'PIX' | 'CREDITO' | 'DEBITO' | 'DINHEIRO';
export type StatusPagamento = 'PENDENTE' | 'APROVADO' | 'RECUSADO' | 'CANCELADO' | 'ESTORNADO';

export interface Pagamento {
  id: number;
  pedido: Pedido;
  formaPagamento: FormaPagamento;
  status: StatusPagamento;
  valor: number;
  dataHoraPagamento?: string;
  codigoTransacao?: string;
}
