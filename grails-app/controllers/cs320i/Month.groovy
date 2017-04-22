package cs320i

/**
 * Created by Jackson on 4/21/2017.
 */
enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12)

    Month(int value)
    {
        this.monthValue = value
    }
    private  final int monthValue
//Reverse look up map for int into String
    private static final Map<Integer, Month> reverse = new HashMap<Integer, Month>()

    static {
        for(Month m : Month.values())
            reverse.put(m.getMonthValue(), m)
    }
    int getMonthValue()
    {
        monthValue
    }
    String toString(int value)
    {
        //adding one to dayValue due to java MyCalendar starting at 0 and mine starting at 1
        value++
        return reverse.get(value).toString()
    }
    String toString()
    {
        return name().substring(0,1)+name().substring(1).toLowerCase()
    }
}
