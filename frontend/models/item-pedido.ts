import type { Pedido } from './pedido';
import type { Produto } from './produto';

export interface ItemPedido {
  id: number;
  pedido: Pedido;
  produto: Produto;
  quantidade: number;
  precoUnitario: number;
  subtotal?: number;
}
