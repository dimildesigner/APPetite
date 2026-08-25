const configuredApiUrl = window.APPETITE_API_URL || '/api';
const API_BASE_URL = configuredApiUrl.replace(/\/$/, '');

export class ApiError extends Error {
  constructor(message, status = 0) {
    super(message);
    this.name = 'ApiError';
    this.status = status;
  }
}

async function request(path, options = {}) {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    credentials: 'include',
    headers: { Accept: 'application/json', 'Content-Type': 'application/json', ...(options.headers || {}) },
    ...options
  });

  if (!response.ok) {
    let message = `Nao foi possivel concluir a solicitacao (${response.status}).`;
    try {
      const errorBody = await response.json();
      message = errorBody.message || errorBody.mensagem || message;
    } catch { /* Respostas sem JSON usam a mensagem padrao. */ }
    throw new ApiError(message, response.status);
  }

  if (response.status === 204) return null;
  return response.json();
}

export const http = {
  get: (path) => request(path),
  post: (path, body) => request(path, { method: 'POST', body: JSON.stringify(body) }),
  put: (path, body) => request(path, { method: 'PUT', body: JSON.stringify(body) }),
  delete: (path) => request(path, { method: 'DELETE' })
};

export { API_BASE_URL };
