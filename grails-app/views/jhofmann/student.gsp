<!DOCTYPE html>
<html lang="en">
<head>
    <title>Players</title>
    <meta charset="utf-8">
    <meta name="layout" content="main"/>
    <meta name="nav" content="players"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Players</h1>
    <table class="table table-hover">
        <thead>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
        </thead>
        <tbody>
            <g:each in="${users}" var="user" status="i">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>