<!doctype html>
<html lang="en" class="no-js">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>
        <g:layoutTitle default="Grails" />
    </title>
    <asset:stylesheet src="application.css" />

    <g:layoutHead/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="${g.createLink(controller:'jhofmann', action:'home')}" class="navbar-brand">Student Calendar</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="${ pageProperty(name:'meta.nav').equals( 'home' ) ? 'active' : null }">
                        <g:link controller="jhofmann" action="home">Home</g:link>
                    </li>
                    <sec:ifLoggedIn>
                        <li class="${ pageProperty(name:'meta.nav').equals( 'Student' ) ? 'active' : null }">
                            <g:link controller="jhofmann" action="student">Student</g:link>
                        </li>
                        <li class="${ pageProperty(name:'meta.nav').equals( 'MyCalendar' ) ? 'active' : null }">
                            <g:link controller="jhofmann" action="calendar">Calendar</g:link>
                        </li>
                    </sec:ifLoggedIn>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:ifLoggedIn>
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li class="${ pageProperty(name:'meta.nav').equals( 'login' ) ? 'active' : null }">
                            <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                        </li>
                    </sec:ifNotLoggedIn>
                </ul>
            </div>
        </div>
    </nav>
    <g:layoutBody/>

</body>

</html>
