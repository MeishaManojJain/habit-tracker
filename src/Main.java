import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Create a new scanner object
        Scanner input = new Scanner(System.in);

        //Input number of habits to keep track of.
        int noOfHabits;
        System.out.print("Enter number of habits: ");
        noOfHabits = input.nextInt();
        Habit[] habits = new Habit[noOfHabits];

        //Input habit names
        for (int i = 0; i < noOfHabits; i++) {
            System.out.print("Enter Habit: " + (i + 1) + ": ");
            String name = input.next();
            habits[i] = new Habit(name);
        }
        int day = 1;

        //Menu loop
        int choice = -1;
        while (choice != 0) {
            //Menu
            System.out.println("\nDay: " + day);
            System.out.println("**** MENU ****");
            System.out.println("1. See hours performed of all habits");
            System.out.println("2. Add hours");
            System.out.println("3. Next Day");
            System.out.println("4. See streaks of all habit");
            System.out.println("0. Quit the program\n");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    //Iterate through all habits and print hours performed
                    for (int i = 0; i < noOfHabits; i++) {
                        System.out.println("\nHabit " + (i + 1) + ": " + habits[i].getName());
                        System.out.println("Hours performed: " + habits[i].getHoursPerformed());
                    }
                    break;
                case 2:
                    int pickHabit;

                    for (int i = 0; i < noOfHabits; i++) {
                        System.out.println("Habit " + (i + 1) + ": " + habits[i].getName());
                    }
                    //Input the habit
                    System.out.println("Select the habit you want to add hours to: ");
                    pickHabit = input.nextInt();
                    if (pickHabit <= 0 || pickHabit > noOfHabits) {
                        System.out.println("Please enter a valid habit number.");
                    } else {
                        int hours;
                        System.out.print("Enter number of hours: ");
                        hours = input.nextInt();
                        habits[pickHabit - 1].addHours(hours, day);
                    }
                    break;
                case 3:
                    //Next day
                    day++;
                    break;
                case 4:
                    //Iterate thorugh all the elements and prink streak
                    for (int i = 0; i < noOfHabits; i++) {
                        System.out.println("\nHabit " + (i + 1) + ": " + habits[i].getName());
                        System.out.println("Streak: " + habits[i].getStreak());
                    }
                    break;
                case 0:
                    System.out.println("\n\nThank You for using the program");
                    System.out.println("Quiting");
                    break;
                default:
                    System.out.println("Please enter a number between 1-3");

            }


        }
    }
}
