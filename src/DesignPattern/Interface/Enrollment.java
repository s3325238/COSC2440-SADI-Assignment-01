package DesignPattern.Interface;

public class Enrollment implements EnrollmentInterface {
    @Override
    public void generalLine() {
        System.out.println(
            "Which action do you want to choose?\n\n" +
            "1 - View all enrollment course of student.\n"+
            "2 - View enrollment course of student at your choice.\n"+
            "3 - Update single student enrollment. ( not yet implemented )\n" +
            "4 - Delete single student enrollment.\n" +
            "5 - Exit the program.\n"
        );
    }

    @Override
    public void choiceLine(int choice) {
        switch (choice){
            case 1: // Print all
                System.out.println("\nYou choose to print all students' enrollment\n");
                break;
            case 2: // Print single student
                System.out.println("\nWhich student do you want to print his/her enrollment?\n");
                break;
            case 3: // Update
                System.out.println("\nYou choose to update student.\n");
                System.out.println("Which student do you want to update?\n");
                break;
            case 4: // Delete
                System.out.println("\nYou choose to delete student.\n");
                break;
            case 5:
                System.out.println("\nYou choose to exit the program.\n");
                break;
        }
    }
}
