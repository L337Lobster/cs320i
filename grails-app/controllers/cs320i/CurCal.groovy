package cs320i

/**
 * Created by Jackson on 4/21/2017.
 */
class CurCal {

    DayOfWeek dayOfWeek
    int lastDay
    int lastDayPrevMonth
    def currentDay
    int firstDayOfWeek
    int lastRowOfMonth
    Month month
    Month curMonth
    def year
    def table = new int[6][7]
    int nextMonth
    int prevMonth
    Calendar calendar
    MyCalendar myCalendar
    def monthMyCal = new ArrayList<CalendarEntry>()

    CurCal(MyCalendar myCal, String option, Month current, String year)
    {
        myCalendar = myCal
        //get current date
        if(option.equalsIgnoreCase("current")) {
            calendar = Calendar.getInstance()
            Month curMonth = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
            this.curMonth = curMonth
        }
        else if(option.equalsIgnoreCase("prev"))
        {
            calendar = Calendar.getInstance()
            Month curMonth = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
            this.curMonth = curMonth
            calendar.set(Calendar.MONTH, current.getMonthValue()-2)
            calendar.set(Calendar.YEAR, year.toInteger())
        }
        else if(option.equalsIgnoreCase("next"))
        {
            calendar = Calendar.getInstance()
            Month curMonth = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
            this.curMonth = curMonth
            calendar.set(Calendar.MONTH, ((int)current.getMonthValue() < 12 ? current.getMonthValue() : 0))
            calendar.set(Calendar.YEAR, (current.getMonthValue() == 12 ? year.toInteger()+1 : year.toInteger()))
        }
        //get and set current day to today's numerical day
        this.currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        //get and set the current month
        Month month = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
        this.month = month
        getCurrentMonthEntries()
        //get and set the current day of the week eg. Monday
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY.toString(calendar.get(Calendar.DAY_OF_WEEK)).toUpperCase() as DayOfWeek
        this.dayOfWeek = dayOfWeek
        //get and set the last numerical day of the month
        this.lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        //get and set the current year
        this.year = calendar.get(Calendar.YEAR)
        //set the calendar to the first day of the month
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1)
        //get the first day of the week of the month
        this.firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        prevMonth = firstDayOfWeek - 1
        //set the calendar to last month
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1)
        //add one to last day for ease of calculations later
        lastDayPrevMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        generateTable()
    }
    CurCal(MyCalendar myCal)
    {
        myCalendar = myCal
        //get current date
        calendar = Calendar.getInstance()
        //get and set current day to today's numerical day
        this.currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        //get and set the current month
        Month month = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
        this.month = month
        this.curMonth = month
        getCurrentMonthEntries()
        //get and set the current day of the week eg. Monday
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY.toString(calendar.get(Calendar.DAY_OF_WEEK)).toUpperCase() as DayOfWeek
        this.dayOfWeek = dayOfWeek
        //get and set the last numerical day of the month
        this.lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        //get and set the current year
        this.year = calendar.get(Calendar.YEAR)
        //set the calendar to the first day of the month
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1)
        //get the first day of the week of the month
        this.firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        prevMonth = firstDayOfWeek - 1
        //set the calendar to last month
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1)
        //add one to last day for ease of calculations later
        lastDayPrevMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        generateTable()
    }
    def getCurrentMonthEntries()
    {
        for(int i = 0; i < myCalendar.entries.size(); i++)
        {
            if(myCalendar.entries[i].month == this.month)
            {
                monthMyCal.add(myCalendar.entries[i])
            }
        }
    }
    def generateTable()
    {
        int start = firstDayOfWeek-1
        int count = 0, count2 = 0
        for(int i = 0; i < 6; i++)
        {
            for(int j =0; j < 7; j++)
            {
                if(count2 < start-1)
                {
                    println("Count2: " + count2 +" start: " + start)
                    table[i][j] = 0
                    count2++
                }
                else
                {
                    table[i][j] = count++
                }
                if(count > lastDay)
                {
                    nextMonth = j
                    if(lastRowOfMonth  == 0 || lastRowOfMonth == null)
                    {
                        lastRowOfMonth = i
                    }
                    count = 1
                }
            }

        }
        if(prevMonth > 0)
        {
            for(int i = prevMonth-1; i >= 0; i--)
            {
                table[0][i] = lastDayPrevMonth--
            }
        }
        else if(prevMonth == 0)
        {
            if (table[0][0] == 0)
            {
                table[0][0] = lastDayPrevMonth
            }
        }

        println("" + month + ": " + table)

    }

}
