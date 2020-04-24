<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <title>Our pets</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,500,600,700,700i|Montserrat:300,400,500,600,700"
          rel="stylesheet">

    <link href="../lib/bootstrap/css/bootstrap.css" rel="stylesheet">


    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet">


    <link href="../css/style.css" rel="stylesheet">

</head>
<header id="header">
    <div class="container">
        <div class="logo float-left">
            <h1 class="text-light"><a href="#intro" class="scrollto"><span>Shelter</span></a></h1>
        </div>
        <nav class="main-nav float-right d-none d-lg-block">
            <ul>
                <li><a href="/shelter">Home</a></li>
                <li><a href="/shelter">About Us</a></li>
                <li><a href="/pets">Pets</a></li>
                <#if authentication?has_content>

                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Log Out</a></li>
                <#else>
                    <li><a href="/signIn">Sign In</a></li>
                    <li><a href="/signUp">Sign Up</a></li>
                </#if>
            </ul>
        </nav>
    </div>
</header>
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
                        <img src="/${pet.getImg()}" style="width:27em; height:17em; margin-bottom: 430px" alt="">

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

                        <form method="post">
                            <button type="submit">Take home</button>
                        </form>
                            <#if statusPet == "IN_HAND">
                                <p>This pet in hand!</p>
                            </#if>
                        </#if>

                    </div>

                </div>
            </div>
        </div>
    </section>
</main>
<script src="../lib/jquery/jquery.min.js"></script>
<script src="../lib/jquery/jquery-migrate.min.js"></script>
<script src="../lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../lib/easing/easing.min.js"></script>
<script src="../lib/mobile-nav/mobile-nav.js"></script>
<script src="../lib/wow/wow.min.js"></script>
<script src="../lib/waypoints/waypoints.min.js"></script>
<script src="../lib/counterup/counterup.min.js"></script>
<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../lib/isotope/isotope.pkgd.min.js"></script>
<script src="../lib/lightbox/js/lightbox.min.js"></script>
<!-- Contact Form JavaScript File -->
<script src="../contactform/contactform.js"></script>

<!-- Template Main Javascript File -->
<script src="../js/main.js"></script>

</html>
