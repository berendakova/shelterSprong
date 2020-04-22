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
    <link rel="stylesheet" href="../normalize.css">
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<header id="header">
    <div class="container">
        <div class="logo float-left">
            <h1 class="text-light"><a href="#intro" class="scrollto"><span>Shelter</span></a></h1>
        </div>
        <nav class="main-nav float-right d-none d-lg-block">
            <ul>
                <li><a href="/shelter">Home</a></li>
                <li><a href="#about">About Us</a></li>
                <#if authentication?has_content>
                    <li><a href="/pets">Pets</a></li>
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
</body>
</html>
