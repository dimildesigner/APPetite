const slides = [
  {
    src: 'https://images.unsplash.com/photo-1580863621684-c99fa617804a?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
    alt: 'Prato apetitoso servido para o intervalo'
  },
  {
    src: 'https://images.unsplash.com/photo-1652101270782-7b9187a6dafb?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
    alt: 'Refeicao da cantina pronta para servir'
  },
  {
    src: 'https://images.unsplash.com/photo-1769138885126-701ffae94ee3?q=80&w=1169&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
    alt: 'Comida fresca apresentada em um prato'
  },
  {
    src: 'https://images.unsplash.com/photo-1633118759442-4cd4a829976e?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
    alt: 'Opcao saborosa para o intervalo'
  },
  {
    src: 'https://images.unsplash.com/photo-1773409297331-d80af59a912a?q=80&w=1169&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',
    alt: 'Prato colorido da cantina'
  }
];

const image = document.querySelector('#hero-carousel-image');
const previousButton = document.querySelector('#carousel-previous');
const nextButton = document.querySelector('#carousel-next');
const indicators = document.querySelector('#carousel-indicators');
let currentIndex = 0;
let rotationTimer;

function showSlide(index) {
  currentIndex = (index + slides.length) % slides.length;
  image.src = slides[currentIndex].src;
  image.alt = slides[currentIndex].alt;
  indicators.querySelectorAll('button').forEach((indicator, indicatorIndex) => {
    indicator.classList.toggle('active', indicatorIndex === currentIndex);
    indicator.setAttribute('aria-current', indicatorIndex === currentIndex ? 'true' : 'false');
  });
}

function restartRotation() {
  window.clearInterval(rotationTimer);
  if (slides.length > 1) {
    rotationTimer = window.setInterval(() => showSlide(currentIndex + 1), 5000);
  }
}

indicators.innerHTML = slides.map((slide, index) => `<button type="button" aria-label="Ir para foto ${index + 1}" aria-current="${index === 0 ? 'true' : 'false'}"></button>`).join('');
indicators.querySelectorAll('button').forEach((indicator, index) => indicator.addEventListener('click', () => {
  showSlide(index);
  restartRotation();
}));

previousButton.hidden = slides.length < 2;
nextButton.hidden = slides.length < 2;
indicators.hidden = slides.length < 2;
previousButton.addEventListener('click', () => { showSlide(currentIndex - 1); restartRotation(); });
nextButton.addEventListener('click', () => { showSlide(currentIndex + 1); restartRotation(); });
showSlide(0);
restartRotation();
