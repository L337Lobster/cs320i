package cs320i

class CalendarEntry {

    def day
    Month month
    def year
    EntryType type
    def calID

    static constraints = {
        day max:31, min:1, blank: false
        year min:1000, blank: false
        month blank: false
        type blank: false
    }
}
