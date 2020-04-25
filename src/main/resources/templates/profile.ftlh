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
                <h3>Your pets</h3>
                <p>Here you can see our animals, affectionate dogs, beloved cats</p>
                <#list pets as pet>
                    <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s" style="margin-bottom: 30px">
                        <div class="about-img">
                            <img src="${pet.getImg()}" style="width:27em; height:17em;" alt="">
                        </div>
                    </div>
                    <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s">
                        <div class="box">
                            <h4 class="title"><a href="">${pet.getName()}</a></h4>
                            <p class="description">${pet.getDescription()}</p>
                        </div>
                    </div>
                </#list>
            </header>
        </div>
    </section>
</main>
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
<#include "include/scripts.ftlh">