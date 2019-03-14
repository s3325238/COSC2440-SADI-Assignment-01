package General;

import java.util.*;

public class CheckList {

    public static int ListCheck(Scanner sc, List semestersList, List studentsList, List coursesList) {
        int choice = 0;
        boolean loop = true;
        System.out.println();
        if (coursesList.size() > 0) {

            if (studentsList.size() > 0 && semestersList.size() > 0) {

                System.out.println("Which action do you want to choose?\n" +
                        "\n1 - Continue adding more course" +
                        "\n2 - Choose new student to add" +
                        "\n3 - Choose new semester to add" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter your choice ( Only from 1 to 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice > 4);

            }else if(studentsList.size() > 0 && semestersList.size() == 0){


                System.out.println("Which action do you want to choose?\n" +
                        "\n1 - Continue adding more course" +
                        "\n2 - Choose new student to add" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter your choice ( Only number 1, 2, or 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice > 4 || choice == 3);


            } else if (studentsList.size() == 0 && semestersList.size() > 0) {

                System.out.println("Which action do you want to choose?\n" +
                        "\n1 - Continue adding more course" +
                        "\n3 - Choose new semester to add" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter your choice ( Only number 1, 3, or 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice > 4 || choice == 2);

            } else if (studentsList.size() == 0 && semestersList.size() == 0) {
                System.out.println("Which action do you want to choose?\n" +
                        "\n1 - Continue adding more course" +
                        "\n4 - Quit to enrollment system"
                );
                do {

                    System.out.print("\nEnter your choice ( Only number 1, or 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                    if (choice == 1 || choice == 4) {
                        loop = false;
                    }
                } while (loop);
            }

        } else { // No more course for current student
            System.out.println("\nNo more courses to add in current student.\n");

            if (studentsList.size() > 0 && semestersList.size() > 0) {

                System.out.println("Which action do you want to choose?\n" +
                        "\n2 - Choose new student to add" +
                        "\n3 - Choose new semester to add" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter your choice ( Only number 3 or 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice < 2 || choice > 4);

            } else if (studentsList.size() == 0 && semestersList.size() > 0) {

                System.out.println("\nNo more students to add in this semester.\n");
                System.out.println("Which action do you want to choose?\n" +
                        "\n3 - Choose new semester to add" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter your choice ( Only number 3 or 4 ): ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice < 3 || choice > 4);

            } else if (studentsList.size() == 0 && semestersList.size() == 0) {

                System.out.println("\nYou cannot either add more students or semester.\n");
                System.out.println("Only one choice available for you.\n" +
                        "\n4 - Quit to enrollment system"
                );
                do {
                    System.out.print("\nEnter number 4 only: ");
                    choice = PositiveNegative.integer_number(sc, 0);
                } while (choice != 4);

            }

        }
        return choice;
    }

}
