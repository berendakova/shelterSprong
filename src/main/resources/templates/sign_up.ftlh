<!doctype html>
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
    <#include "include/links.ftlh">
</head>
<body>
<#include "include/header.ftlh">
<form method="post"style="margin-top: 150px" action="/signUp">
    <h1>Sign Up</h1>
    <fieldset>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Ivan Petrov">
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="email" placeholder="example@example.com">
        <label for="password1">Password:</label>
        <input type="password" id="password1" name="password">
        <label for="password2">Password replay:</label>
        <input type="password" id="password2" name="repeatedPassword">
        <br>
        <br>
    </fieldset>
    <button type="submit" id="reg">Sign Up</button>
</form>
<#include "include/scripts.ftlh">
</body>
</html>
