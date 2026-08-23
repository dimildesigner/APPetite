export type CategoriaProduto =
  | 'LANCHE' | 'SALGADO' | 'SNACK' | 'BEBIDA'
  | 'SOBREMESA' | 'ADICIONAL' | 'OUTROS';

export interface Produto {
  id: number;
  nome: string;
  descricao?: string;
  categoria: CategoriaProduto;
  precoCusto: number;
  precoVenda: number;
  estoqueAtual: number;
  estoqueMinimo: number;
  perecivel: boolean;
  ativo: boolean;
}

export type ProdutoInput = Omit<Produto, 'id' | 'estoqueAtual' | 'ativo'> & {
  estoqueAtual?: number;
  ativo?: boolean;
};
