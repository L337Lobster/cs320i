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
        if(params.option != null && params.month != null && params.year != null)
        {
            currentCalendar = new CurCal((String)params.option, (Month)((String)params.month.toUpperCase()), (String)params.year)
        }
        else{
            currentCalendar = new CurCal()
        }
        [calendar: currentCalendar]
    }
    @Secured('ROLE_USER')
    def student() {
       def users = Player.list()
        [users:users]
    }

}
