<!DOCTYPE html>
<html lang="en">
<head>
    <title>Entry: ${entry.title}</title>
    <meta charset="utf-8">
    <meta name="layout" content="main"/>
    <meta name="nav" content="self"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6 well text-center">
            <h1><small>Title: </small>${entry.title}</h1>
            <h4><small>Due:</small> ${entry.day} ${entry.month} ${entry.year}</h4>
            <h4><small>Type:</small> ${entry.type}</h4>
            <h4><small>Grade:</small> ${(entry.grade != null) ? entry.grade : 'N/A'}</h4>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

</body>
</html>