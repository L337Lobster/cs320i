package cs320i

class CalendarEntry {

    int day
    Month month
    int year
    EntryType type
    String title
    double grade
    static belongsTo = [myCalendar: MyCalendar]
    CalendarEntry(String title, String type, int day, int month, int year)
    {
        this.day = day
        this.month = Month.APRIL.toString(month).toUpperCase() as Month
        this.year = year
        this.title = title
        this.type = type as EntryType
    }
    static constraints = {
        day max:31, min:1, blank: false
        year min:1000, blank: false
        month blank: false
    }
}
