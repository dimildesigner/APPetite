import { http } from './http';
import type { CadastroUsuario, Usuario } from '../models/usuario';

export const usuarioService = {
  list: () => http.get<Usuario[]>('/usuarios'),
  getById: (id: number) => http.get<Usuario>(`/usuarios/${id}`),
  register: (usuario: CadastroUsuario) => http.post<Usuario>('/usuarios', usuario),
  update: (id: number, usuario: Partial<Usuario>) => http.put<Usuario>(`/usuarios/${id}`, usuario),
  remove: (id: number) => http.delete<void>(`/usuarios/${id}`)
};
