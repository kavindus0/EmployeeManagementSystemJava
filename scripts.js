document.addEventListener("DOMContentLoaded", () => {
    const details = document.querySelectorAll(".fade-in");

    details.forEach((detail, index) => {
        detail.style.animationDelay = `${index * 0.3}s`;
    });

    const container = document.querySelector(".container");
    container.addEventListener("mouseenter", () => {
        container.style.transform = "scale(1.02)";
        container.style.transition = "transform 0.3s ease-in-out";
    });

    container.addEventListener("mouseleave", () => {
        container.style.transform = "scale(1)";
    });
});