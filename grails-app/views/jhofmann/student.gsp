<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Overview</title>
    <meta charset="utf-8">
    <meta name="layout" content="main" />
    <meta name="nav" content="student" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

    <div class="container">
        <h1>Entries</h1>
        <g:link action="addCal" controller="jhofmann">
            <button type="button" class="btn btn-success btn-sm">
                Add Entry
            </button>
        </g:link>
        <table class="table table-hover">
            <thead>
                <g:sortableColumn property="title" title="Entry" />
                <g:sortableColumn property="month" title="Month" />
                <g:sortableColumn property="day" title="Day" />
                <g:sortableColumn property="year" title="Year" />
                <g:sortableColumn property="grade" title="Grade" />
            </thead>
            <tbody>
                <g:each in="${entries}" var="entry" status="i">
                    <tr>
                        <td>${entry.title}</td>
                        <td>${entry.month}</td>
                        <td>${entry.day}</td>
                        <td>${entry.year}</td>
                        <td>${entry.grade}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>

</body>

</html>
