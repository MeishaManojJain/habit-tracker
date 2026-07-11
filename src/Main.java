import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int noOfHabits;
        System.out.print("Enter number of habits: ");
        noOfHabits = input.nextInt();
        Habit[] habits = new Habit[noOfHabits];

        for (int i = 0; i < noOfHabits; i++) {
            System.out.print("Enter Habit: " + (i + 1) + ": ");
            String name = input.next();
            habits[i] = new Habit(name);
        }

        int choice = -1;
        while (choice != 3) {
            //Menu
            System.out.println("\n**** MENU ****");
            System.out.println("1. See hours performed of all habits");
            System.out.println("2. Add hours");
            System.out.println("3. Quit the program\n");

            choice = input.nextInt();
            switch (choice) {
                case 1:
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
                    System.out.println("Select the habit you want to add hours to: ");
                    pickHabit = input.nextInt();
                    if (pickHabit <= 0 || pickHabit > noOfHabits) {
                        System.out.println("Please enter a valid habit number.");
                    } else {
                        int hours;
                        System.out.print("Enter number of hours: ");
                        hours = input.nextInt();
                        habits[pickHabit - 1].addHours(hours);
                    }
                    break;
                case 3:
                    System.out.println("\n\nThank You for using the program");
                    System.out.println("Quiting");
                    break;
                default:
                    System.out.println("Please enter a number between 1-3");

            }


        }
    }
}
