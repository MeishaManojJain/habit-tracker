import java.util.*;

public class Main {

    //Create a new scanner object
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        //Object which stores all the habit
        HabitTracker h1 = new HabitTracker();

        //Variable to track day
        int day = 1;

        //Menu loop
        int choice = -1;
        while (choice != 0) {
            //Menu
            System.out.println("\nDay: " + day);
            System.out.println("**** MAIN MENU ****");
            System.out.println("1. Manage Habits\n" +
                    "2. Track Progress\n" +
                    "3. Next Day\n" +
                    "0. Exit");

            //Input the choice
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    manageHabitsMenu(h1);
                    break;

                case 2:
                    trackProgressMenu(h1, day);
                    break;
                case 3:
                    //Next day
                    day++;
                    break;
                case 0:
                    System.out.println("\n\nThank You for using the program");
                    System.out.println("Quiting");
                    break;
                default:
                    System.out.println("Please enter a number between 0-3");

            }


        }
    }

    static void manageHabitsMenu(HabitTracker h1) {
        System.out.println("\n--- MANAGE HABITS ---");
        System.out.println("1. Add Habit\n" +
                "2. Delete Habit\n" +
                "3. Rename Habit\n" +
                "4. Back");
        int choice;
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter Habit name: ");
                String name = input.next();
                h1.addHabit(name);
                break;

            case 2:
                //Display all habits to choose from
                h1.displayHabits();

                //Input the habit number
                int choose;
                System.out.println("Select the habit you want to delete: ");
                choose = input.nextInt();
                h1.deleteHabit(choose);
                break;
            case 3:
                //Display all habits to choose from
                h1.displayHabits();

                //Input the habit number
                int choose1;
                System.out.println("Select the habit you want to rename: ");
                choose1 = input.nextInt();

                //input habit name
                System.out.print("Enter new habit name: ");
                String name1 = input.next();

                //Rename
                h1.renameHabit(name1, choose1);
                break;
            case 4:
                System.out.println("Returning to the main menu");
                break;
            default:
                System.out.println("Please enter a number b/w 1-4");
                break;
        }

    }

    static void trackProgressMenu(HabitTracker h1, int day) {
        System.out.println("\n--- TRACK PROGRESS ---");
        System.out.println("1. Add Hours");
        System.out.println("2. View All Habits");
        System.out.println("3. View Hours");
        System.out.println("4. View Streaks");
        System.out.println("5. Statistics");
        System.out.println("6. Back");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                h1.displayHabits();

                System.out.print("Select the habit: ");
                int habitNumber = input.nextInt();

                System.out.print("Enter number of hours: ");
                int hours = input.nextInt();

                h1.addHoursToAHabit(habitNumber, hours, day);
                break;

            case 2:
                h1.displayHabits();
                break;

            case 3:
                h1.displayHoursPerformed();
                break;

            case 4:
                h1.displayStreak();
                break;

            case 5:
                // Statistics
                System.out.println("Coming soon");
                break;

            case 6:
                System.out.println("Returning to the main menu");
                break;

            default:
                System.out.println("Please enter a number between 1-6");
        }
    }
}
