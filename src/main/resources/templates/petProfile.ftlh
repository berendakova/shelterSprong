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
<#include "include/header.ftlh">
<main>
    <section id="pets" class="section-bg">
        <div class="container" style="height: 100%">
            <header class="section-header" style="margin-top: 60px">
                <h3>Our pets</h3>
                <p>Here you can see our animals, affectionate dogs, beloved cats</p>
            </header>
            <div class="row">
                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s">
                    <div class="about-img">
                        <img src="${pet.getImg()}" style="width:27em; height:17em; margin-bottom: 430px" alt="">
                    </div>
                </div>
                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s">
                    <div class="box">
                        <h4 class="title">${pet.getName()}</h4>
                        <p class="description">${pet.getDescription()}</p>
                        <h6 class="description">sex : ${pet.getSex()}</h6>
                        <h6 class="description">breed : ${pet.getBreed()}</h6>
                        <h6 class="description">disease : ${pet.getDisease()}</h6>
                        <#if authentication?has_content>
                            <#if statusPet == "SHELTER">
                            <a href="/pets/${pet.getId()}/take"><h4>TAKE pet</h4></a>
                            </#if>
                            <#if statusPet == "IN_HAND">
                                <p>This pet in hand!</p>
                            </#if>
                            <#else>
                                <a href="/signIn"><h4>Sign In to take pets at home</h4></a>

                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<#include "include/scripts.ftlh">
</html>
