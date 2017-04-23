package cs320i

/**
 * Created by Jackson on 4/21/2017.
 */
class CurCal {

    DayOfWeek dayOfWeek
    int lastDay
    def currentDay
    def firstDayOfWeek
    Month month
    def year
    def table = new int[6][7]
    Calendar calendar

    CurCal()
    {
        //get current date
        calendar = Calendar.getInstance()
        //get and set current day to today's numerical day
        this.currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        //get and set the current month
        Month month = Month.JANUARY.toString(calendar.get(Calendar.MONTH)).toUpperCase() as Month
        this.month = month
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
        generateTable()
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
                    table[i][j] = 0
                    count2++
                }
                else
                {
                    table[i][j] = count++
                }
                if(count > lastDay)
                {
                    count = 1
                }
            }
            println count

        }
        println table

    }

}
