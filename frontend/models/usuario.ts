export type TipoUsuario = 'CLIENTE' | 'FUNCIONARIO' | 'GERENTE';

export interface Usuario {
  id: number;
  nome: string;
  email: string;
  telefone: string;
  tipoUsuario: TipoUsuario;
  ativo: boolean;
}

export interface CadastroUsuario extends Omit<Usuario, 'id' | 'ativo'> {
  senha: string;
}
