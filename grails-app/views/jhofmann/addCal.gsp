<!DOCTYPE html>
<html lang="en">

<head>
    <title>Add to Calendar</title>
    <meta charset="utf-8">
    <meta name="layout" content="main" />
    <meta name="nav" content="addCal" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
    <g:form name="saveAddCal" action="saveAddCal">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" class="form-control" autofocus>
            <label for="type">Entry Type:</label>
            <select class="form-control" name="type" id="type">
                <g:each in="${type}">
                    <option value="${it.toString()}">${it.toString()}</option>
                </g:each>
            </select>
            <label for="due">Date Due:</label>
            %{--<g:datePicker class="form-control" name="due" id="due" precision="day" relativeYears="[-2..7]"/>--}%
            <input type="date" value="${today}" name="due" id="due" class="form-control">
            <label for="grade">Grade</label>
            <input type="number" step="0.1" name="grade" id="grade" max="100" min="0" class="form-control">

        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </g:form>
</div>

</body>

</html>
