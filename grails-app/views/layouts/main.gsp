<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <g:layoutHead/>
</head>
<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="${g.createLink(controller:'jhofmann', action:'home')}" class="navbar-brand">7 Days to Die Stats</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="<g:if test="${page == 'home'}">active</g:if>"><g:link controller="jhofmann" action="home">Home</g:link></li>
                    <li class="<g:if test="${page == 'players'}">active</g:if>"><g:link controller="jhofmann" action="players">Players</g:link></li>
                    <li class="<g:if test="${page == 'self'}">active</g:if>"><g:link controller="jhofmann" action="self">Self</g:link></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="<g:if test="${page == 'login'}">active</g:if>"><g:link controller="jhofmann" action="self"><span class="glyphicon glyphicon-log-in"></span> Login</g:link></li>
                </ul>
            </div>
        </div>
    </nav>

    <g:layoutBody/>

</body>
</html>