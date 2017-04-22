package cs320i

import grails.plugin.springsecurity.annotation.Secured

class JhofmannController {

    def index() {
    }

    def home()
    {
        render (view:'index.gsp')
    }

    @Secured('ROLE_USER')
    def calendar()
    {
        Calendar calendar = Calendar.getInstance()
        def currentCalendar = new CurCal()
        currentCalendar.currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        currentCalendar.month = Month.JANUARY.toString(calendar.get(Calendar.MONTH))
        currentCalendar.dayOfWeek = DayOfWeek.FRIDAY.toString(calendar.get(Calendar.DAY_OF_WEEK))
        currentCalendar.lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        currentCalendar.year = calendar.get(Calendar.YEAR)
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1)
        currentCalendar.firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        [calendar: currentCalendar]
    }
    @Secured('ROLE_USER')
    def student() {
       def users = Player.list()
        [users:users]
    }

}
