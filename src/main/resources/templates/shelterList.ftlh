<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <title>Our pets</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <#include "include/links.ftlh">
</head>
<body>
<#include "include/header.ftlh">
<main>
    <section id="pets" class="section-bg">
        <div class="container">
            <header class="section-header" style="margin-top: 60px">
                <h3>Our shelters</h3>

            </header>
            <#list shelters as shelter>
            <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s" style="margin-bottom: 30px">
            <div class="about-img">
                <h4 class="title">${shelter.getName()}</h4>
                <br>
                <p class="description" style="margin-bottom: 20px">${shelter.getDescription()}</p>
                <br>
                <p class="description" style="margin-bottom: 20px">${shelter.getAddress()}</p>
                <br>
            </div>
        </div>
            </#list>


        </div>
    </section><!-- #services -->
</main>
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
<#include "include/scripts.ftlh">
</body>