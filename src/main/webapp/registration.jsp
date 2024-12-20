<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
  
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: Arial, sans-serif;
      background-color: #f3f4f6;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .registration-container {
      background-color: #ffffff;
      border-radius: 10px;
      padding: 30px;
      width: 100%;
      max-width: 400px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .registration-container h2 {
      text-align: center;
      color: #333333;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      font-weight: bold;
      color: #555555;
      margin-bottom: 5px;
    }

    input, select {
      width: 100%;
      padding: 10px;
      font-size: 14px;
      border: 1px solid #cccccc;
      border-radius: 5px;
      background-color: #f9f9f9;
    }

    input:focus, select:focus {
      outline: none;
      border-color: #4CAF50;
      background-color: #ffffff;
    }

    .submit-button {
      width: 100%;
      padding: 12px;
      font-size: 16px;
      color: #ffffff;
      background-color: #4CAF50;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      margin-top: 10px;
    }

    .submit-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="registration-container">
    <h2>Registration Form</h2>
    <form>
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required>
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
      </div>
      <div class="form-group">
        <label for="dob">Date of Birth</label>
        <input type="date" id="dob" name="dob" required>
      </div>
      <div class="form-group">
        <label for="college">College Name</label>
        <input type="text" id="college" name="college" placeholder="Enter your college name" required>
      </div>
      <div class="form-group">
        <label for="course">Course</label>
        <select id="course" name="course" required>
          <option value="" disabled selected>Select Course</option>
          <option value="BTech">BTech</option>
          <option value="BBA">BBA</option>
          <option value="BCA">BCA</option>
          <option value="MBA">MBA</option>
        </select>
      </div>
      <button type="submit" class="submit-button">Register</button>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  <script sr="scipt.js"></script>
</body>
</html>