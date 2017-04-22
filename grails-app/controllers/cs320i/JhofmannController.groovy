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
        def Currentmonth = Month.JANUARY.toString(calendar.get(Calendar.MONTH))
        def currentDayOfWeek = DayOfWeek.FRIDAY.toString(calendar.get(Calendar.DAY_OF_WEEK))
        def currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        def maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1)
        String firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        println Currentmonth
        [month:maxDay]
    }
    @Secured('ROLE_USER')
    def student() {
       def users = Player.list()
        [users:users]
    }

}
