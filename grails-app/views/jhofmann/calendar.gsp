<!DOCTYPE html>
<html lang="en">

<head>
    <title>Calendar</title>
    <meta charset="utf-8">
    <meta name="layout" content="main" />
    <meta name="nav" content="calendar" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-4"></div>
            <h1 class="text-center col-sm-4">Calendar</h1>
            <div class="col-sm-4"></div>
        </div>
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8 well">
                <table class="table-condensed table-bordered table-calendar">
                    <thead>
                        <tr>
                            <th colspan="7">
                                <h3 class="text-center">${calendar.month} ${calendar.year}</h3>
                            </th>
                        </tr>
                        <tr>
                            <th>Sun</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                        </tr>
                    </thead>
                    <tbody>
                        <g:each var="i" in="${0..5}">
                            <tr>
                                <g:each var="j" in="${0..6}">
                                    <g:if test="${ (i==5) && (j > calendar.nextMonth)}">
                                        <td class="text-muted not-current">${ calendar.table[i][j] == 0 ? null : calendar.table[i][j]}</td>
                                    </g:if>
                                    <g:else>
                                        <td <g:if test="${ calendar.table[i][j] == calendar.currentDay}"> class="btn-primary"</g:if>
                                            <g:elseif test="${ (i == 0) && (j < calendar.firstDayOfWeek-1)}">class="text-muted not-current"</g:elseif> >${ calendar.table[i][j] == 0 ? null : calendar.table[i][j]}</td>
                                    </g:else>
                                </g:each>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-2">
            </div>
        </div>

</body>

</html>
