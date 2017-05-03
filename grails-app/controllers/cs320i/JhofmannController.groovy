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
        def currentCalendar
        def userPrincipal = request.getUserPrincipal()
        def user = Player.findByUsername(userPrincipal.name)
        if(params.option != null && params.month != null && params.year != null)
        {
            currentCalendar = new CurCal((MyCalendar) user.calendar, (String)params.option, (Month)((String)params.month.toUpperCase()), (String)params.year)
        }
        else{
            currentCalendar = new CurCal((MyCalendar) user.getCalendar())
        }
        [calendar: currentCalendar]
    }
    @Secured('ROLE_USER')
    def student() {
       def entries = Player.findByUsername(request.userPrincipal.name).calendar.entries
        [entries: entries]
    }

    @Secured('ROLE_USER')
    def addCal()
    {
        def dateNow
        dateNow = Calendar.getInstance()
        def day = dateNow.get(Calendar.DAY_OF_MONTH)
        def month = dateNow.get(Calendar.MONTH)+1
        def year = dateNow.get(Calendar.YEAR)
        if(day < 10)
        {
            day = "0"+day
        }
        if(month < 10)
        {
            month = "0"+month
        }
        def today = year + "-" + month + "-" + day
        [type: EntryType.values(), today: today]
    }
    @Secured('ROLE_USER')
    def saveAddCal()
    {
        def date = params.due.split('-') // format year-month-day
        def entry = new CalendarEntry((String)params.title,(String) params.type, Integer.parseInt((String)date[2]), Integer.parseInt((String)date[1])-1, Integer.parseInt((String)date[0]))
        def userPrincipal = request.getUserPrincipal()
        def user = Player.findByUsername(userPrincipal.name)
        def myCal = user.getCalendar().addToEntries(entry)
        entry.save(flush: true)
        myCal.save(flush: true)
        user.save(flush: true)
        render (view:'saveAddCal.gsp')

    }



}
