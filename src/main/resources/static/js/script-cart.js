// Lấy tham chiếu đến nút và lightbox
var showLightboxButton = document.getElementById("showLightboxButton");
var lightbox = document.getElementById("lightbox");
var closeLightbox = document.getElementById("closeLightbox");

// Khi người dùng nhấp vào nút, hiển thị lightbox
showLightboxButton.addEventListener("click", function() {
    lightbox.style.display = "block";
});

// Khi người dùng nhấp vào nút đóng hoặc bất kỳ nơi nào trên nền xám, ẩn lightbox
closeLightbox.addEventListener("click", function() {
    lightbox.style.display = "none";
});

window.addEventListener("click", function(event) {
    if (event.target === lightbox) {
        lightbox.style.display = "none";
    }
});
