package General;

import Model.Courses.Courses;
import Model.Semesters.Semesters;
import Model.Students.Students;

import java.util.*;

public class DataInitiation {
    public static int dataInput(Scanner scanner, String role){

        int number = 0;

        if(role.equals("semester")) {

            do {

                System.out.print("How many semester for year " + Calendar.getInstance().get(Calendar.YEAR) + ": ");
                number = PositiveNegative.integer_number(scanner,number);

            } while (number <= 0);
            System.out.println();

            return number;
        }else{

            do {

                System.out.print("Enter number of students you want to generate ( positive number only ): ");
                number = PositiveNegative.integer_number(scanner,number);

            } while (number <= 0);
            System.out.println();

            return number;
        }
    }

    public static int enrollmentData(Scanner sc, String role, int number, List generalList, List<Semesters> semestersList, List<Students> studentsList, List<Courses> coursesList){
        switch (role){
            case "semester":
                System.out.println();
                System.out.println("Which semester do you want to add: ");
                for (int i = 0; i < semestersList.size(); i++){
                    System.out.println();
                    System.out.println( (i+1) + " - " + semestersList.get(i).getSemesterName() );
                }
                System.out.println();
                break;
            case "student":
                System.out.println();
                System.out.println("Which student do you want to add: ");
                for (int i = 0; i < studentsList.size(); i++){
                    System.out.println();
                    System.out.println( (i+1) + " - " + studentsList.get(i).getStudentName() +", student id: "+studentsList.get(i).getStudentID() );
                }
                System.out.println();
                break;
            case "course":
                System.out.println();
                System.out.println("Which course do you want to add: ");
                for (int i = 0; i < coursesList.size(); i++){
                    System.out.println();
                    System.out.println( (i+1) + " - "+ coursesList.get(i).getCourse_code()+ " " + coursesList.get(i).getCourse_name() );
                }
                System.out.println();
                break;
        }

        do{
            System.out.print("Enter your choice ( from 1 to " + generalList.size() +" ): ");

            number = PositiveNegative.integer_number(sc,number);

            if(number > generalList.size()){
                System.out.println("Input cannot larger than the size! Please enter again!");
                continue;
            }
        }while (number > generalList.size() || number <= 0);

        return number;
    }
}
