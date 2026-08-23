import type { ItemPedido } from './item-pedido';
import type { Usuario } from './usuario';

export type TipoPedido = 'RESERVA' | 'PRESENCIAL';
export type StatusPedido = 'AGUARDANDO_PAGAMENTO' | 'PAGO' | 'EM_PREPARO' | 'PRONTO' | 'RETIRADO' | 'CANCELADO';

export interface Pedido {
  id: number;
  usuario: Usuario;
  dataHoraPedido: string;
  horarioRetirada?: string;
  tipoPedido: TipoPedido;
  valorTotal: number;
  status: StatusPedido;
  observacao?: string;
  codigoRetirada?: string;
  itens: ItemPedido[];
}
