<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertEmp</title>
<style>
    body {
        background: linear-gradient(to right, #1e3c72, #2a5298); /* Blue gradient background */
        color: white;
        font-family: Arial, sans-serif;
        text-align: center;
        padding: 50px;
    }
    h1 {
        margin-bottom: 50px;
        font-size: 36px;
    }
    form {
        background-color: rgba(255, 255, 255, 0.1); /* Slight transparency */
        padding: 30px;
        border-radius: 10px;
        display: inline-block;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
    }
    p {
        font-size: 18px;
        margin-bottom: 20px;
    }
    input[type="text"] {
        padding: 10px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        width: 250px;
    }
    input[type="submit"] {
        background-color: #1e3c72;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 18px;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #2a5298;
    }
</style>
</head>
<body>
    <h1>Add New Employee</h1>
    <form method="post" action="Insert">
        <p>Employee Name: <input type="text" name="ename"></p>
        <p>Employee Salary: <input type="text" name="esal"></p>
        <p>Employee Designation: <input type="text" name="edes"></p>
        <input type="submit" value="Add Emp">
    </form>
</body>
</html>
