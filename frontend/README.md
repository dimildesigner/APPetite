# APPetite frontend

Front-end inicial em HTML, CSS e JavaScript modular. Abra `index.html` por um servidor estatico para usar a tela de cardapio.

## Contrato esperado

O cliente usa `http://localhost:8080/api` por padrao. Para trocar a origem antes do modulo carregar, defina `window.APPETITE_API_URL` em um script anterior ao `js/app.js`.

O backend mantem os controladores MVC (`@Controller`) e renderiza Thymeleaf, mas agora tambem expoe controllers REST paralelos. A tela consome:

- `GET /api/produtos?ativo=true`
- `GET /api/produtos/{id}`
- `POST /api/produtos`
- `PUT /api/produtos/{id}`
- `DELETE /api/produtos/{id}` (desativacao logica)

Os arquivos TypeScript em `models/` refletem as entidades Java e os arquivos em `services/` organizam as operacoes de produtos, pedidos, pagamentos, usuarios e estoque.

Pedidos e pagamentos exigem autenticacao por sessao. O CORS de desenvolvimento aceita `localhost:3000` e `localhost:5500`.

O backend usa `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` como variaveis de ambiente. Consulte o `.env.example`; nunca publique valores reais de senha.
