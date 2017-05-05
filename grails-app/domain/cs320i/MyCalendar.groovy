package cs320i

class MyCalendar {

    static hasMany = [entries: CalendarEntry]
    static belongsTo = [student: Player]

    static constraints = {
    }
}