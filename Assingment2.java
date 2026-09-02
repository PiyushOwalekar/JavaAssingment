import java.util.Scanner;

public class Assingment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Activity Management System ---");
            System.out.println("1. Check Attendance Eligibility");
            System.out.println("2. View Performance Category");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            // Using switch statement for menu selection
            switch (choice) {
                case 1:
                    System.out.print("Enter student attendance percentage: ");
                    double attendance = scanner.nextDouble();

                    // Using if, if-else, and nested if
                    if (attendance >= 0 && attendance <= 100) {
                        if (attendance >= 75) {
                            System.out.println("Result: Student is ELIGIBLE to appear for the examination.");
                        } else {
                            System.out.println(
                                    "Result: Student is NOT ELIGIBLE for the examination (Requires at least 75%).");
                        }
                    } else {
                        System.out.println("Invalid entry! Attendance percentage must be between 0 and 100.");
                        continue; // Skip to next iteration for invalid entry
                    }
                    break;

                case 2:
                    System.out.print("Enter student marks (0-100): ");
                    double marks = scanner.nextDouble();

                    // Using conditional statements for performance evaluation
                    if (marks >= 0 && marks <= 100) {
                        if (marks >= 90) {
                            System.out.println("Performance Category: Excellent");
                        } else if (marks >= 75) {
                            System.out.println("Performance Category: Very Good");
                        } else if (marks >= 50) {
                            System.out.println("Performance Category: Satisfactory");
                        } else {
                            System.out.println("Performance Category: Needs Improvement");
                        }
                    } else {
                        System.out.println("Invalid entry! Marks must be between 0 and 100.");
                        continue; // Skip to next iteration for invalid entry
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break; // Break out of switch

                default:
                    System.out.println("Invalid option! Please enter a choice between 1 and 3.");
                    continue; // Skip invalid entry and repeat menu
            }

            // Terminate loop if user chose Exit
            if (choice == 3) {
                break; // Break out of loop
            }

        } while (true);

        scanner.close();
    }
}