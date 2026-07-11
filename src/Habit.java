public class Habit {
    private String name;
    private int hoursPerformed;


    //Constructor
    Habit(String n) {
        name = n;
        hoursPerformed = 0;
    }

    public String getName() {
        return name;
    }

    public int getHoursPerformed() {
        return hoursPerformed;
    }

    void addHours(int hours) {
        hoursPerformed += hours;
    }
}
