// const sign_in_btn = document.querySelector("#sign-in-btn");
// const sign_up_btn = document.querySelector("#sign-up-btn");
// const container = document.querySelector(".container");
//
// sign_up_btn.addEventListener("click", () => {
//   container.classList.add("sign-up-mode");
// });
//
// sign_in_btn.addEventListener("click", () => {
//   container.classList.remove("sign-up-mode");
// });
//
// // Handle form submissions
// document.querySelector(".sign-in-form").addEventListener("submit", async (e) => {
//   e.preventDefault();
//   const username = document.querySelector(".sign-in-form input[type='text']").value;
//   const password = document.querySelector(".sign-in-form input[type='password']").value;
//
//   try {
//     const response = await fetch("http://localhost:8080/api/v1/auth/login", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify({ username, password }),
//     });
//
//     if (response.ok) {
//       const result = await response.text();
//       if (result === "user") {
//         window.location.href = "home.html";
//       } else if (result === "designer") {
//         window.location.href = "designer-home.html";
//       } else if (result === "admin") {
//         window.location.href = "admin-home.html";
//       }
//     } else {
//       const error = await response.text();
//       alert(error);
//     }
//   } catch (error) {
//     console.error("Error:", error);
//     alert("Failed to fetch");
//   }
// });
//
// document.querySelector(".sign-up-form").addEventListener("submit", async (e) => {
//   e.preventDefault();
//   const username = document.querySelector("#username").value;
//   const email = document.querySelector("#email").value;
//   const password = document.querySelector("#password").value;
//   const role = document.querySelector("#role").value;
//
//   try {
//     const response = await fetch("http://localhost:8080/api/v1/auth/register", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify({ username, email, password, role }),
//     });
//
//     const result = await response.text();
//     alert(result);
//   } catch (error) {
//     console.error("Error:", error);
//     alert("Failed to fetch");
//   }
// });

$("#btn-login2").click(function () {
  $.ajax({
    url: "http://localhost:8080/api/v1/auth/authenticate",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify({
      "password": $("#passwordSignIn").val(),
      "email": $("#emailSignIn").val()
    }),
    success: (res) => {
      console.log(res.data.token);
      window.localStorage.setItem("token", res.data.token);
      if (res.message === "Success") {
        window.location.href = "index.html";
        console.log("Login successful");
        alert("Login successful");
      } else {
        alert("Failed: " + (res.message || "Unknown error"));
      }
    },
    error: (error) => {
      console.error(error);
      alert("Something went wrong");
    }
  });
});

