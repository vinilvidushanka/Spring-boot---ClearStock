/*


const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});



$(document).ready(function () {
  $(document).on("click", "#btn-login2", function () {
    console.log("Login button clicked");

    let email = $("#emailSignIn").val();
    let password = $("#passwordSignIn").val();

    if (!email || !password) {
      alert("Please enter both email and password.");
      return;
    }

    console.log("Email:", email);
    console.log("Password:", password);

    $.ajax({
      url: "http://localhost:8080/api/v1/auth/authenticate",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({ email, password }),

      success: (res) => {
        console.log(res.data.token);
        console.log(res.data);
        console.log(res.data.role);
        window.localStorage.setItem("token", res.data.token);
        if (res.message === "Success") {
          if (res.data.role === "admin") {
            window.location.href = "admin-home.html";
          } else if (res.data.role === "user") {
            window.location.href = "home.html";
          }
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
});





*/

const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});

$(document).ready(function () {
  $(document).on("click", "#btn-login2", function () {
    console.log("Login button clicked");

    let email = $("#emailSignIn").val();
    let password = $("#passwordSignIn").val();

    if (!email || !password) {
      alert("Please enter both email and password.");
      return;
    }

    console.log("Email:", email);
    console.log("Password:", password);

    // **Clear input fields after validation**
    $("#emailSignIn").val("");
    $("#passwordSignIn").val("");

    $.ajax({
      url: "http://localhost:8080/api/v1/auth/authenticate",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({ email, password }),

      success: (res) => {
        console.log(res.data.token);
        console.log(res.data);
        console.log(res.data.role);
        window.localStorage.setItem("token", res.data.token);

        if (res.message === "Success") {
          if (res.data.role === "admin") {
            window.location.href = "admin-home.html";
          } else if (res.data.role === "user") {
            window.location.href = "home.html";
          }
          alert("Login successful");
        } else {
          alert("Failed: " + (res.message || "Unknown error"));
        }
        $("#emailSignIn").val("");
        $("#passwordSignIn").val("");
      },

      error: (error) => {
        console.error(error);
        alert("Something went wrong");
      }
    });
  });
});

