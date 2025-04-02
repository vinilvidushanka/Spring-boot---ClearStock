const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});

// Handle form submissions
document.querySelector(".sign-in-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  const username = document.querySelector(".sign-in-form input[type='text']").value;
  const password = document.querySelector(".sign-in-form input[type='password']").value;

  const response = await fetch("http://localhost:8080/api/v1/auth/login", { // Update the URL to the correct backend URL
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, password }),
  });

  const result = await response.json().catch(() => {
    alert("Invalid response from server");
  });

  if (response.ok) {
    if (result === "user") {
      window.location.href = "home.html";
    } else if (result === "designer") {
      window.location.href = "designer-home.html";
    } else if (result === "admin") {
      window.location.href = "admin-home.html";
    }
  } else {
    alert(result);
  }
});

document.querySelector(".sign-up-form").addEventListener("submit", async (e) => {
  e.preventDefault();
  const username = document.querySelector("#username").value;
  const email = document.querySelector("#email").value;
  const password = document.querySelector("#password").value;
  const role = document.querySelector("#role").value;

  const response = await fetch("http://localhost:8080/api/auth/register", { // Update the URL to the correct backend URL
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, email, password, role }),
  });

  const result = await response.json().catch(() => {
    alert("Invalid response from server");
  });

  alert(result);
});
