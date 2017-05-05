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
                <g:sortableColumn property="type" title="Type" />
                <g:sortableColumn property="month" title="Month" />
                <g:sortableColumn property="day" title="Day" />
                <g:sortableColumn property="year" title="Year" />
                <g:sortableColumn property="grade" title="Grade" />
                <th></th>
            </thead>
            <tbody>
                <g:each in="${entries}" var="entry" status="i">
                    <tr>
                        <td><g:link action="entry" params="[entryID: entry.id]">${entry.title}</g:link></td>
                        <td>${entry.type}</td>
                        <td>${entry.month}</td>
                        <td>${entry.day}</td>
                        <td>${entry.year}</td>
                        <td>${entry.grade}</td>
                        <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete${entry.title}"><span class="glyphicon glyphicon-remove"></span></button></td>
                    </tr>
                    <!-- Modal begin-->
                    <div id="delete${entry.title}" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Are you Sure?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Delete ${entry.title}? <br /><small>This cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <g:form name="deleteEntry" action="saveDelCal">
                                        <input type="hidden" name="entryID" id="entryID" value="${entry.id}">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                        <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-warning-sign"></span> Delete <span class="glyphicon glyphicon-warning-sign"></span></button>
                                    </g:form>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- Modal end-->
                </g:each>
            </tbody>
        </table>
    </div>
</body>

</html>
