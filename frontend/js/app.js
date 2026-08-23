import { ApiError } from './api.js';
import { productService } from './services/product-service.js';

const state = { products: [], category: '', query: '', cart: [] };
const currency = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' });
const elements = {
  grid: document.querySelector('#product-grid'), count: document.querySelector('#product-count'),
  feedback: document.querySelector('#feedback'), search: document.querySelector('#search-input'),
  filters: document.querySelector('#category-filters'), cartItems: document.querySelector('#cart-items'),
  cartCount: document.querySelector('#cart-count'), cartTotal: document.querySelector('#cart-total-value'),
  checkout: document.querySelector('#checkout-button'), clear: document.querySelector('#clear-cart')
};

const categoryLabels = { LANCHE: 'Lanche', SALGADO: 'Salgado', SNACK: 'Snack', BEBIDA: 'Bebida', SOBREMESA: 'Sobremesa', ADICIONAL: 'Adicional', OUTROS: 'Outros' };

function filteredProducts() {
  const query = state.query.toLocaleLowerCase('pt-BR');
  return state.products.filter((product) => (!state.category || product.categoria === state.category) && (!query || `${product.nome} ${product.descricao || ''}`.toLocaleLowerCase('pt-BR').includes(query)));
}

function renderFilters() {
  const categories = [...new Set(state.products.map((product) => product.categoria).filter(Boolean))];
  elements.filters.innerHTML = ['<button class="filter-button selected" type="button" data-category="">Todos</button>', ...categories.map((category) => `<button class="filter-button" type="button" data-category="${category}">${categoryLabels[category] || category}</button>`)].join('');
  elements.filters.querySelectorAll('[data-category]').forEach((button) => button.addEventListener('click', () => {
    state.category = button.dataset.category;
    elements.filters.querySelectorAll('.filter-button').forEach((item) => item.classList.toggle('selected', item === button));
    renderProducts();
  }));
}

function renderProducts() {
  const products = filteredProducts();
  elements.count.textContent = `${products.length} ${products.length === 1 ? 'opcao' : 'opcoes'}`;
  elements.grid.innerHTML = products.length ? products.map((product) => `<article class="product-card"><div class="product-art" aria-hidden="true">${(product.nome || '?').slice(0, 1).toUpperCase()}</div><span class="product-category">${categoryLabels[product.categoria] || product.categoria || 'Produto'}</span><h3>${product.nome}</h3><p class="product-description">${product.descricao || 'Uma escolha gostosa para o seu intervalo.'}</p><div class="product-bottom"><span class="product-price">${currency.format(Number(product.precoVenda || 0))}</span><button class="add-button" type="button" data-add="${product.id}" aria-label="Adicionar ${product.nome}">+</button></div></article>`).join('') : '<p>Nenhum produto encontrado com esses filtros.</p>';
  elements.grid.querySelectorAll('[data-add]').forEach((button) => button.addEventListener('click', () => addToCart(Number(button.dataset.add))));
}

function addToCart(id) { const product = state.products.find((item) => item.id === id); if (!product) return; const item = state.cart.find((entry) => entry.product.id === id); item ? item.quantity += 1 : state.cart.push({ product, quantity: 1 }); renderCart(); }
function changeQuantity(id, amount) { const item = state.cart.find((entry) => entry.product.id === id); if (!item) return; item.quantity += amount; state.cart = state.cart.filter((entry) => entry.quantity > 0); renderCart(); }
function renderCart() { const count = state.cart.reduce((sum, item) => sum + item.quantity, 0); const total = state.cart.reduce((sum, item) => sum + Number(item.product.precoVenda || 0) * item.quantity, 0); elements.cartCount.textContent = count; elements.cartTotal.textContent = currency.format(total); elements.checkout.disabled = !count; elements.cartItems.innerHTML = state.cart.length ? state.cart.map(({ product, quantity }) => `<div class="cart-item"><div class="cart-item-info"><strong>${product.nome}</strong><span>${currency.format(Number(product.precoVenda || 0))}</span></div><div class="quantity-control"><button type="button" data-change="${product.id}" data-amount="-1" aria-label="Diminuir quantidade">-</button><span>${quantity}</span><button type="button" data-change="${product.id}" data-amount="1" aria-label="Aumentar quantidade">+</button></div></div>`).join('') : '<p class="empty-cart">Sua sacola esta vazia.</p>'; elements.cartItems.querySelectorAll('[data-change]').forEach((button) => button.addEventListener('click', () => changeQuantity(Number(button.dataset.change), Number(button.dataset.amount)))); }

async function loadProducts() { elements.feedback.textContent = 'Carregando produtos...'; try { state.products = await productService.listActive(); renderFilters(); renderProducts(); elements.feedback.textContent = ''; } catch (error) { const message = error instanceof ApiError ? error.message : 'Nao foi possivel carregar o cardapio.'; elements.feedback.className = 'feedback error'; elements.feedback.textContent = `${message} Verifique se o backend REST esta em execucao.`; elements.count.textContent = 'Indisponivel'; } }

elements.search.addEventListener('input', (event) => { state.query = event.target.value; renderProducts(); });
elements.clear.addEventListener('click', () => { state.cart = []; renderCart(); });
elements.checkout.addEventListener('click', () => { elements.feedback.className = 'feedback'; elements.feedback.textContent = 'O checkout sera conectado ao fluxo de pedidos da API.'; document.querySelector('#cardapio').scrollIntoView({ behavior: 'smooth' }); });
renderCart();
loadProducts();
