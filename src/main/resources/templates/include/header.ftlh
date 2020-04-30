<header id="header">
    <div class="container">
        <div class="logo float-left">
            <h1 class="text-light"><a href="#intro" class="scrollto"><span>Shelter</span></a></h1>
        </div>
        <nav class="main-nav float-right d-none d-lg-block">
            <ul>
                <li><a href="/shelter">Home</a></li>
                <li><a href="/pets">Pets</a></li>
                <li><a href="/inhand">In HAND</a> </li>
                <li><a href="/shelters">Shelters</a></li>
                <#if authentication?has_content>
                    <li><a href="/pets/upload">Upload Img</a></li>
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