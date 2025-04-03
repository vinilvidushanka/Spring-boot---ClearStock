

const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});


/*$("#btn-login2").click(function () {
  console.log("csdvsdv")
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
});*/

/*$(document).ready(function () {
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
        console.log("Success response:", res);
        if (res.token) {
          localStorage.setItem("token", res.token);
          alert("Login successful!");
          window.location.href = "index.html";
        } else {
          alert("Login failed: " + (res.message || "Unknown error"));
        }
      },
      error: (xhr) => {
        console.error("AJAX Error:", xhr);
        alert(`Error: ${xhr.status} - ${xhr.responseText}`);
      }
    });
  });
});*/

/*$(document).ready(function () {
  $(document).on("click", "#btn-login2", function () {
    let email = $("#emailSignIn").val();
    let password = $("#passwordSignIn").val();

    if (!email || !password) {
      alert("Please enter both email and password.");
      return;
    }

    console.log("Sending AJAX request:", { email, password });

    $.ajax({
      url: "http://localhost:8080/api/v1/auth/authenticate",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({ email, password }),
      success: function (res) {
        console.log("AJAX Success:", res);
        if (res.token) {
          localStorage.setItem("token", res.token);
          alert("Login successful!");
          window.location.href = "index.html";
        } else {
          alert("Login failed: " + (res.message || "Unknown error"));
        }
      },
      error: function (xhr) {
        console.error("AJAX Error:", xhr);
        alert(`Login failed: ${xhr.status} - ${xhr.responseText}`);
      }
    });
  });
});*/

/*$(document).ready(function () {
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
        console.log("Success response:", res);

        if (res.statusCode === 201) {
          // Handle success, maybe the login was successful
          localStorage.setItem("token", res.data.token);
          alert("Login successful!");
          window.location.href = "home.html";
        } else {
          alert("Login failed: " + (res.message || "Unknown error"));
        }
      },
      error: (xhr) => {
        console.error("AJAX Error:", xhr);
        alert(`Error: ${xhr.status} - ${xhr.responseText}`);
      }
    });
  });
});*/

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
      /*success: (res) => {
        console.log("Success response:", res);

        if (res.statusCode === 201) {
          // Save token
          localStorage.setItem("token", res.data.token);

          // Check user role
          let role = res.data.role;
          console.log("User role:", role);

          alert("Login successful!");

          // Redirect based on role
          if (role === "admin") {
            window.location.href = "admin-home.html";
          } else if (role === "designer") {
            window.location.href = "designer-home.html";
          } else if (role === "user") {
            window.location.href = "home.html";
          } else {
            alert("Unknown role, redirecting to default home page.");
            window.location.href = "home.html";
          }
        } else {
          alert("Login failed: " + (res.message || "Unknown error"));
        }
      },*/
      /*success: (res) => {
        console.log("Full Response:", res);
        console.log("Response Data:", res.data);
        console.log("User Object:", res.data.user);
        console.log("User Role:", res.data.user?.role);

        if (res.statusCode === 201) {
          localStorage.setItem("token", res.data.token);

          let role = res.data.user.role;
          console.log("User role:", role);

          if (role === "ADMIN") {
            window.location.href = "admin-home.html";
          } else {
            window.location.href = "home.html";
          }
        } else {
          alert("Login failed: " + (res.message || "Unknown error"));
        }
      },
      error: (xhr) => {
        console.error("AJAX Error:", xhr);
        alert(`Error: ${xhr.status} - ${xhr.responseText}`);
      }*/
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





