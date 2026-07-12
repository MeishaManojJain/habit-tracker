import java.util.ArrayList;

public class HabitTracker {

    //Data Members
    private ArrayList<Habit> habits;

    HabitTracker() {
        habits = new ArrayList<>();
    }

    void addHabit(String name) {
        habits.add(new Habit(name));
    }

    void deleteHabit(int habitNumber) {
        if (habits.size() == 0) {
            System.out.println("No habits to delete!");
            return;
        }
        //Validate input
        if (habitNumber <= 0 || habitNumber > habits.size()) {
            System.out.println("Please enter a valid habit number.");
            return;
        }
        habits.remove(habitNumber - 1);
    }

    void renameHabit(String n, int habitNumber) {
        if (habits.size() == 0) {
            System.out.println("No habits to rename!");
            return;
        }
        //Validate input
        if (habitNumber <= 0 || habitNumber > habits.size()) {
            System.out.println("Please enter a valid habit number.");
            return;
        }
        habits.get(habitNumber - 1).changeName(n);
    }

    void displayHoursPerformed() {
        if (habits.size() == 0) {
            System.out.println("No habits to display!");
            return;
        }
        //Iterate through all habits and print hours performed
        for (int i = 0; i < habits.size(); i++) {
            System.out.println("\nHabit " + (i + 1) + ": " + habits.get(i).getName());
            System.out.println("Hours performed: " + habits.get(i).getHoursPerformed());
        }
    }

    void displayStreak() {
        if (habits.size() == 0) {
            System.out.println("No habits to display!");
            return;
        }
        for (int i = 0; i < habits.size(); i++) {
            System.out.println("\nHabit " + (i + 1) + ": " + habits.get(i).getName());
            System.out.println("Streak: " + habits.get(i).getStreak());
        }
    }

    void displayHabits() {
        if (habits.size() == 0) {
            System.out.println("No habits to display!");
            return;
        }
        int n = habits.size();
        for (int i = 0; i < n; i++) {
            System.out.println("Habit " + (i + 1) + ": " + habits.get(i).getName());
        }
    }

    void addHoursToAHabit(int habitNumber, int hours, int day) {
        if (habits.size() == 0) {
            System.out.println("No habits to add hours to! Create a habit first.");
            return;
        }
        int n = habits.size();
        //Validate input
        if (habitNumber <= 0 || habitNumber > n) {
            System.out.println("Please enter a valid habit number.");
        } else {
            habits.get(habitNumber - 1).addHours(hours, day);
        }
    }

    void displayStatistics() {
        int n = habits.size();
        if (n == 0) {
            System.out.println("No habits to display! Create a habit first.");
            return;
        }

        System.out.println("Total Habits: " + n);
        System.out.println("Total Hours: " + totalHours());
        System.out.println("Average Hours per Habit: " + (double) totalHours() / n);

        System.out.println("\nMost Time Spent:");
        ArrayList<Integer> maxHours = highestTimeSpent();
        for (int i = 0; i < maxHours.size(); i++) {
            int index = maxHours.get(i);
            System.out.println(habits.get(index).getName());
            System.out.println("Hours performed: " + habits.get(index).getHoursPerformed());
        }

        System.out.println("\nLongest Streak:");
        ArrayList<Integer> maxStreak = highestStreak();
        for (int i = 0; i < maxStreak.size(); i++) {
            int index = maxStreak.get(i);
            System.out.println(habits.get(index).getName());
            System.out.println("Streak: " + habits.get(index).getStreak());
        }
    }

    int totalHours() {
        int sum = 0;
        int n = habits.size();
        for (int i = 0; i < n; i++) {
            sum += habits.get(i).getHoursPerformed();
        }
        return sum;
    }

    ArrayList<Integer> highestTimeSpent() {
        ArrayList<Integer> ans = new ArrayList<>();

        if (habits.size() == 0) {
            return ans;
        }

        int maxHours = habits.get(0).getHoursPerformed();

        for (int i = 0; i < habits.size(); i++) {
            int currentHours = habits.get(i).getHoursPerformed();

            if (currentHours > maxHours) {
                maxHours = currentHours;
                ans.clear();
                ans.add(i);
            } else if (currentHours == maxHours) {
                ans.add(i);
            }
        }

        return ans;
    }

    ArrayList<Integer> highestStreak() {
        ArrayList<Integer> ans = new ArrayList<>();

        if (habits.size() == 0) {
            return ans;
        }

        int maxStreak = habits.get(0).getStreak();

        for (int i = 0; i < habits.size(); i++) {
            int currentStreak = habits.get(i).getStreak();

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                ans.clear();
                ans.add(i);
            } else if (currentStreak == maxStreak) {
                ans.add(i);
            }
        }

        return ans;
    }
}