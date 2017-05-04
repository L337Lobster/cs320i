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
                            <th colspan="2">
                                <g:link action="calendar" controller="jhofmann" params="[option: 'prev', month: calendar.month, year: calendar.year]">
                                    <button type="button" class="btn btn-default btn-sm">
                                        <span class="glyphicon glyphicon-circle-arrow-left"></span>
                                    </button>
                                </g:link>
                            </th>
                            <th colspan="3">
                                <h3 class="text-center">${calendar.month} ${calendar.year}</h3>
                            </th>
                            <th colspan="2">
                                <g:link action="calendar" controller="jhofmann" params="[option: 'next', month: calendar.month, year: calendar.year]">
                                    <button type="button" class="btn btn-default btn-sm">
                                        <span class="glyphicon glyphicon-circle-arrow-right"></span>
                                    </button>
                                </g:link>
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
                                    <g:set var="cellClass" value="" />
                                    <g:if test="${
                                                    (
                                                        (calendar.table[i][j] < calendar.lastDay && i > calendar.lastRowOfMonth) ||
                                                        (calendar.table[i][j] < calendar.lastDay && i == 5 && j > calendar.nextMonth) ||
                                                        (calendar.table[i][j] < calendar.lastDay && j > calendar.nextMonth && i >= calendar.lastRowOfMonth)
                                                     ) ||
                                                    (
                                                        (i == 0 && j < calendar.firstDayOfWeek-1) ||
                                                        (i == 0 && j == 0 && calendar.table[i][i] > 1)
                                                    )
                                                }">
                                        <g:set var="cellClass" value="text-muted not-current" />
                                    </g:if>
                                    <g:else>
                                        <g:if test="${ (calendar.table[i][j] == calendar.currentDay) && (calendar.month == calendar.curMonth) && (calendar.table[i][j] < 20 && i < 2)}">
                                            <g:set var="cellClass" value="btn-primary" />
                                        </g:if>
                                        <g:each var="m" in="${0..calendar.monthMyCal.size()}">
                                            <g:if test="${ calendar.monthMyCal[m]?.day == calendar.table[i][j]}">
                                                <g:set var="cellClass" value="btn-success" />
                                            </g:if>
                                        </g:each>
                                    </g:else>
                                    <td class="${cellClass}">${ calendar.table[i][j] == 0 ? null : calendar.table[i][j]}</td>
                                </g:each>
                                <!-- ${calendar.firstDayOfWeek} ${calendar.prevMonth}-->
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
