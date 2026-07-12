import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Create a new scanner object
        Scanner input = new Scanner(System.in);
        HabitTracker h1 = new HabitTracker();

        //Variable to track day
        int day = 1;

        //Menu loop
        int choice = -1;
        while (choice != 0) {
            //Menu
            System.out.println("\nDay: " + day);
            System.out.println("**** MENU ****");
            System.out.println("1. Add a habit");
            System.out.println("2. Delete a habit");
            System.out.println("3. See hours performed of all habits");
            System.out.println("4. Add hours");
            System.out.println("5. Next Day");
            System.out.println("6. See streaks of all habit");
            System.out.println("0. Quit the program\n");

            //Input the choice
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
                    h1.displayHoursPerformed();
                    break;
                case 4:
                    //Display all habits to choose from
                    h1.displayHabits();
                    //Input the habit number
                    int pickHabit;
                    System.out.println("Select the habit you want to add hours to: ");
                    pickHabit = input.nextInt();

                    //Input habit hours
                    int hours;
                    System.out.println("Enter number of hours: ");
                    hours = input.nextInt();

                    h1.addHoursToAHabit(pickHabit, hours, day);
                    break;
                case 5:
                    //Next day
                    day++;
                    break;
                case 6:
                    h1.displayStreak();
                    break;
                case 0:
                    System.out.println("\n\nThank You for using the program");
                    System.out.println("Quiting");
                    break;
                default:
                    System.out.println("Please enter a number between 0-6");

            }


        }
    }
}
