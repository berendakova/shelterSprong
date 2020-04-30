<!doctype html>
<html lang="en">
<head>
    <title>Sign Up</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <#include "include/links.ftlh">
</head>
<body>
<#include "include/header.ftlh">
<form action="/signIn" method="post" style="margin-top: 150px">
    <h1>Sign In</h1>
    <fieldset>
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="email" placeholder="example@example.com">
        <label for="password1">Password:</label>
        <input type="password" id="password" name="password">
    </fieldset>
    <button type="submit">Sign In</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
<#include "include/scripts.ftlh">
</html>
