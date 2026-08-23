import type { Produto } from './produto';

export type TipoMovimentacao = 'ENTRADA' | 'SAIDA';
export type MotivoMovimentacao = 'COMPRA' | 'VENDA' | 'PERDA' | 'AJUSTE' | 'CANCELAMENTO';

export interface MovimentacaoEstoque {
  id: number;
  produto: Produto;
  tipo: TipoMovimentacao;
  motivo: MotivoMovimentacao;
  quantidade: number;
  saldoAnterior: number;
  saldoAtual: number;
  dataHora: string;
  observacao?: string;
}
