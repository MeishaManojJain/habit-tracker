public class Habit {
    //Data Members
    private String name;
    private int hoursPerformed;
    private int lastPerformed;
    private int streak;


    //Constructor
    Habit(String n) {
        name = n;
        hoursPerformed = 0;
        lastPerformed = 0;
        streak = 0;
    }

    public String getName() {
        return name;
    }

    public int getHoursPerformed() {
        return hoursPerformed;
    }

    public int getStreak() {
        return streak;
    }

    void addHours(int hours, int currentDay) {
        if (hours < 0) {
            System.out.println("Please enter a valid number.");
            return;
        }
        //Streak logic
        hoursPerformed += hours;
        if (lastPerformed + 1 == currentDay) {
            streak++;
        } else if (lastPerformed != currentDay) {
            streak = 1;
        }
        lastPerformed = currentDay;


    }
}
