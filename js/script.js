  // Navigation functions
  function showSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.style.display = 'flex';
}

function hideSidebar() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.style.display = 'none';
}

// Carousel functionality
let currentSlide = 0;
const slides = document.querySelectorAll('.carousel-slide');
const indicators = document.querySelectorAll('.indicator');

function updateCarousel() {
    const carousel = document.querySelector('.carousel');
    carousel.style.transform = `translateX(-${currentSlide * 100}%)`;
    
    // Update indicators
    indicators.forEach((indicator, index) => {
        indicator.classList.toggle('active', index === currentSlide);
    });
}

function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;
    updateCarousel();
}

function prevSlide() {
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    updateCarousel();
}

function goToSlide(index) {
    currentSlide = index;
    updateCarousel();
}
function goToSlide(index) {
    currentSlide = index;
    updateCarousel();
}
// Auto-rotate carousel
setInterval(nextSlide, 5000);
// Your existing JavaScript code
        
        // Optional: Add to cart functionality
        document.querySelectorAll('.add-to-cart').forEach(button => {
            button.addEventListener('click', function() {
                const productName = this.closest('.product-card').querySelector('.product-name').textContent;
                alert(`${productName} added to cart!`);
            });
        });
        
        // Optional: Wishlist functionality
        document.querySelectorAll('.wishlist-btn').forEach(button => {
            button.addEventListener('click', function() {
                const icon = this.querySelector('i');
                icon.classList.toggle('far');
                icon.classList.toggle('fas');
                icon.style.color = icon.classList.contains('fas') ? '#ff0000' : '#ccc';
            });
        });
        const observer = new IntersectionObserver(entries => {
            entries.forEach(entry => {
              if (entry.isIntersecting) {
                entry.target.classList.add('visible');
              }
            });
          });
      
          observer.observe(document.getElementById('img-sec'));
          function showData() {
            const dataBox = document.getElementById('dataBox');
            dataBox.style.display = 'flex';
          }