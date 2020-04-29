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
                <h3>Our pets in HAND!</h3>
                <p>Here you can see our animals, affectionate dogs, beloved cats</p>
            </header>
            <div class="row">
                <#list imgs as img>
                    <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s" style="margin-bottom: 30px">
                        <div class="about-img">
                            <img src="${img}" style="width:27em; height:17em;" alt="">
                        </div>
                    </div>

                </#list>

            </div>

        </div>
    </section><!-- #services -->

</main>


<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
<#include "include/scripts.ftlh">
</body>