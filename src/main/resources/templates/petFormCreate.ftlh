<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <title>Shelter</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <#include "include/links.ftlh">

</head>

<body>

<#include "include/header.ftlh">

<form method="post" style="margin-top: 250px" action="/pets/created">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name ="name" placeholder="Name">
        </div>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name ="description" placeholder="Text about pet">
    </div>
    <div class="form-group">
        <label for="breed">Breed</label>
        <input type="text" class="form-control" id="breed" name="breed" placeholder="Unknown breed">
    </div>
    <div class="form-group">
        <label for="pet_disease">Disease</label>
        <input type="text" class="form-control" id="pet_disease" name="disease" placeholder="Disease">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="img">IMG</label>
            <input type="text" class="form-control" id="pet_img" name = "img">
        </div>
        <div class="form-group col-md-4">
            <label for="sex">Sex</label>
            <select id="sex" name ="sex" class="form-control">
                <option selected>Choose...</option>
                <option>girl</option>
                <option>boy</option>
            </select>
        </div>
        <div class="form-group col-md-2">

            <label for="age">Age</label>
            <input type="text" class="form-control" id="age" name ="age" placeholder="1">
        </div>
    </div>
    <#if nullEx?has_content>
        <p style="color: red">${nullEx}</p>
    </#if>
    <button type="submit" class="btn btn-primary">Add pet</button>
</form>
</body>
<#include "include/scripts.ftlh">

</html>
