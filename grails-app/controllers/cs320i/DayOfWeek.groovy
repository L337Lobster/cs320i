package cs320i

/**
 * Created by Jackson on 4/21/2017.
 */
enum DayOfWeek {

    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7)

    DayOfWeek(int dayValue)
    {
        this.dayValue = dayValue
    }

    private final int dayValue
    private static final Map<Integer, DayOfWeek> reverse = new HashMap<Integer, DayOfWeek>()

    static {
        for(DayOfWeek m : DayOfWeek.values())
            reverse.put(m.getDayValue(), m)
    }

    int getDayValue()
    {
        dayValue
    }

    String toString(int value)
    {
        return reverse.get(value).toString()
    }
    String toString()
    {
        return name().substring(0,1)+name().substring(1).toLowerCase()
    }
}