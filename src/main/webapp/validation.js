function validateForm() {
    // Get form field values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
  
    // Validate name
    if (name.trim() === '') {
      alert('Name is required');
      return false;
    }
  
    // Validate email
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(email)) {
      alert('Please enter a valid email');
      return false;
    }
  
    // Validate password length
    if (password.length < 6) {
      alert('Password must be at least 6 characters long');
      return false;
    }
  
    // Check if passwords match
    if (password !== confirmPassword) {
      alert('Passwords do not match');
      return false;
    }
  
    // If everything is valid
    alert('Registration successful');
    return true; // Allow form submission
  }
  function loginCheck() {
    // Sample login credentials for checking
    const validUsername = "user123";
    const validPassword = "password123";
  
    // Get input values
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
  
    // Check if username and password match the valid credentials
    if (username === validUsername && password === validPassword) {
      alert("Login successful!");
      return true; // Allow form submission
    } else {
      alert("Invalid username or password");
      return false; // Prevent form submission
    }
  }