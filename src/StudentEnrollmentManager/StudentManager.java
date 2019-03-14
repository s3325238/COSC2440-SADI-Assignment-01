package StudentEnrollmentManager;

import DesignPattern.Command.OriginalList;
import DesignPattern.Command.RestoreList;
import DesignPattern.Decorator.ByeMessage;
import DesignPattern.Decorator.Decorator;
import DesignPattern.Decorator.Message;
import DesignPattern.Interface.Enrollment;
import General.CheckList;
import General.DataInitiation;
import General.PositiveNegative;
import General.TableView;
import Model.Courses.Courses;
import Model.Enrollments.Enrollments;
import Model.Semesters.Semesters;
import Model.Students.Students;

import java.util.*;

public class StudentManager implements ManagerInterface {

    @Override
    public void execute(Scanner sc, List<Semesters> semestersList, List<Students> studentsList, List<Courses> coursesList) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_PURPLE = "\u001B[35m";

        // Initiate start-up data
        int choice,semesterChoice, studentChoice, courseChoice;

        ArrayList<Integer> courseSelection = new ArrayList<Integer>(); // for adding course of user choice
        ArrayList<Integer> backupCourseSelection = new ArrayList<Integer>(); // for adding course of user choice
        ArrayList<Enrollments> myEnrollmentList = new ArrayList<Enrollments>();

        boolean new_course = false;
        boolean new_student = false;
        boolean new_semester = false;

        // Initiate original & backup list for student & course
        // Using command design pattern
        List<Courses> backupCourseList = new ArrayList<>();
        backupCourseList.addAll(coursesList);

        List<Students> backupStudentList = new ArrayList<>();
        backupStudentList.addAll(studentsList);
//        OriginalList originalList = new OriginalList(studentsList,coursesList);
//        RestoreList command = new RestoreList(originalList,studentsList,coursesList);
//        command.execute();

        do{

            // Remove old arrayList of studentList and add backup back to original list
            // Only happen if user choose to add new semester
            studentsList.clear();
            studentsList.addAll(backupStudentList);

            // Add new semester - return number
            semesterChoice = DataInitiation.enrollmentData(
                    sc,
                    "semester",
                    0,
                    semestersList, // input list
                    semestersList,studentsList,coursesList);

            int insertedSemesterChoice = semestersList.get(semesterChoice-1).getSemesterIndex();

            semestersList.remove(semesterChoice-1);

            do{

                // Clear previous course selection if user wants to add new students
                courseSelection.clear();

                // Remove old arrayList of courseList and add backup back to original list
                // Only happen if user chooses to add new student within current semester
                coursesList.clear();
                coursesList.addAll(backupCourseList);

                studentChoice = DataInitiation.enrollmentData(
                        sc,
                        "student",
                        0,
                        studentsList, // input list
                        semestersList,studentsList,coursesList);
                int insertStudentChoice = studentsList.get(studentChoice-1).getStudentIndex();

                studentsList.remove(studentChoice-1);

                do{

                    courseChoice = DataInitiation.enrollmentData(
                            sc,
                            "course",
                            0,
                            coursesList, // input list
                            semestersList,studentsList,coursesList);

                    courseSelection.add( coursesList.get(courseChoice-1).getCourse_index() );

                    coursesList.remove(courseChoice-1);


                    // Select action to continue
                    choice = CheckList.ListCheck(sc,semestersList, studentsList, coursesList);

                    switch (choice){
                        case 1:

                            new_course = true;
                            new_semester = false;
                            new_student = false;

                            System.out.println("\nYou choose to continue adding more courses.\n");
                            break;
                        case 2:

                            new_course = false;
                            new_semester = false;
                            new_student = true;

                            backupCourseSelection.addAll(courseSelection);

                            Enrollments enrollment2 = new Enrollments(
                                    insertStudentChoice,
                                    backupCourseSelection,
                                    insertedSemesterChoice
                            );
                            myEnrollmentList.add(enrollment2);

//                            courseSelection.clear();

                            System.out.println("\nYou choose to add new student.\n");
                            break;
                        case 3:

                            new_course = false;
                            new_student = false;
                            new_semester = true;

                            backupCourseSelection.addAll(courseSelection);

                            Enrollments enrollment3 = new Enrollments(
                                    insertStudentChoice,
                                    backupCourseSelection,
                                    insertedSemesterChoice
                            );
                            myEnrollmentList.add(enrollment3);

                            System.out.println("\nYou choose to add new semester.\n");
                            break;
                        case 4:

                            new_course = false;
                            new_student = false;
                            new_semester = false;

                            backupCourseSelection.addAll(courseSelection);

                            Enrollments enrollment4 = new Enrollments(
                                    insertStudentChoice,
                                    backupCourseSelection,
                                    insertedSemesterChoice
                            );
                            myEnrollmentList.add(enrollment4);
                            boolean continue_add_boolean = false;
                            System.out.println("\nWarning! You cannot add more students if you choose this option.\n");

                            do{
                                System.out.println(
                                        "\nDo you want to continue?\n" + "\n1 - Yes\n\n2 - No"
                                );

                                int continue_add = PositiveNegative.integer_number(sc,0);
                                switch (continue_add){
                                    case 1:
                                        continue_add_boolean = false;
                                        break;
                                    case 2:
                                        System.out.println("You will be redirect back to beginning.");
                                        continue_add_boolean = false;
                                        new_semester = true;
                                        break;
                                    default:
                                        System.out.println("Input cannot be larger than options! Please try again");
                                        continue_add_boolean = true;
                                        break;
                                }
                            } while(continue_add_boolean);
                            System.out.println("\nYou will be redirect to enrollment printing system.\n");
                            break;
                    }

                }while (new_course);

            }while (new_student);

        }while (new_semester);

        studentsList.clear();
        studentsList.addAll(backupStudentList);

        coursesList.clear();
        coursesList.addAll(backupCourseList);

        viewEnrollmentList(sc, studentsList, coursesList, semestersList, myEnrollmentList);
//        enrollmentListQuery(myEnrollmentList);
    }

    private static void viewEnrollmentList(Scanner sc, List<Students> studentsList, List<Courses> coursesList, List<Semesters> semestersList, ArrayList<Enrollments> myEnrollmentList){
        int enrollmentChoice;
        boolean choice = false;

        System.out.println("Currently, there is/are "+myEnrollmentList.size()+" student(s) in the enrollment system.\n");

        TableView.studentView(myEnrollmentList,studentsList);

        Enrollment enrollmentLine = new Enrollment();

        do{
            enrollmentLine.generalLine();
            do {
                System.out.print("\nEnter your choice: ");
                enrollmentChoice = PositiveNegative.integer_number(sc, 0);
                if (enrollmentChoice > 5){
                    System.out.println("You cannot enter number larger than the available action. Please try again.");
                }
            } while (enrollmentChoice > 5);

            enrollmentLine.choiceLine(enrollmentChoice); // print specific line for each choice through interface

            ArrayList<Integer> specificCourseIndex = new ArrayList<Integer>();

            switch (enrollmentChoice){
                case 1: // print all students enrollment
                    choice = true;
                    totalView(myEnrollmentList,studentsList,coursesList);
                    break;
                case 2: // Choose student to print
                    choice = true;
                    specificStudentView(myEnrollmentList,studentsList,coursesList);
                    break;
                case 3: // Update student
                    choice = true;
                    System.out.println("\n\u001B[35mNot yet implement. Please choose another option.\u001B[0m\n");
                    break;
                case 4: // delete student
                    choice = true;
//                    System.out.println("\n\u001B[35mNot yet implement. Please choose another option.\u001B[0m\n");
                    deleteStudent(myEnrollmentList,studentsList,coursesList);
                    break;
                case 5: // Exit program
                    choice = false;
                    Decorator byeMessage = new ByeMessage(new Message());
                    byeMessage.byeMessage("Mr Thanh");
                    break;

            }
        }while (choice);


    }
    private static void totalView(List<Enrollments> myEnrollmentList, List<Students> studentsList, List<Courses> coursesList){
        ArrayList<Integer> specificCourseIndex = new ArrayList<Integer>();

        for (int i = 0;i < myEnrollmentList.size(); i++){

            studentDependentView(i,myEnrollmentList,studentsList);

            specificCourseIndex.clear();
            specificCourseIndex.addAll(myEnrollmentList.get(i).getCourseIndex());

            TableView.courseView(specificCourseIndex,coursesList);

        }
    }

    private static void specificStudentView(ArrayList<Enrollments> myEnrollmentList, List<Students> studentsList, List<Courses> coursesList){

        Scanner sc = new Scanner(System.in);
        boolean specific_loop = false;
        boolean continue_loop = false;
        int end_loop, student_selection;
        ArrayList<Enrollments> singleEnrollment = new ArrayList<>();

        do{
//            System.out.println("\nWhich student do you want to print his/her enrollment?\n");

            TableView.studentView(myEnrollmentList,studentsList);

            // Choosing student
            do{
                System.out.print("\nEnter your choice ( from 1 to " + myEnrollmentList.size() + " ): ");

                student_selection = PositiveNegative.integer_number(sc,0);

                if(student_selection > myEnrollmentList.size()){
                    System.out.println("\n\u001B[31mYou cannot enter number larger than the size. Please try again.\u001B[0m\n");
                    continue_loop = true;
                }else{
                    continue_loop = false;
                }
            } while (continue_loop);

            // Append single item into new list
            // View single student -- not finished
            singleEnrollment.clear();
            singleEnrollment.add(myEnrollmentList.get(student_selection-1));

            totalView(singleEnrollment,studentsList,coursesList);

            // Continue or not
            do{
                System.out.println("\nDo you want to continue printing other students at your choice?\n\n1 - Yes\n2 - No\n");
                System.out.print("\nEnter your choice: ");
                end_loop = PositiveNegative.integer_number(sc,0);
                if(end_loop == 1){
                    specific_loop = true;
                    continue_loop = false;
                }else if(end_loop == 2){
                    specific_loop = false;
                    continue_loop = false;
                }else{
                    System.out.println("\n\u001B[31mWrong input. Please try again.\u001B[0m\n");
                    continue_loop = true;
                }
            }while (continue_loop);

        } while (specific_loop);
    }

    // Update
    private static void updateStudent(){

    }

    // Delete
    private static void deleteStudent(ArrayList<Enrollments> myEnrollmentList, List<Students> studentsList, List<Courses> coursesList){

        Scanner sc = new Scanner(System.in);
        int deleteIndex;

        System.out.println("\nWhich student do you want to remove?\n");

        TableView.studentView(myEnrollmentList,studentsList);

        do{
            System.out.print("Enter your choice ( from 1 to " + myEnrollmentList.size() + " ): ");

            deleteIndex = PositiveNegative.integer_number(sc,0);

            if(deleteIndex > myEnrollmentList.size()){
                System.out.println("Input is out of bound. Please try again.");
            }
        }while (deleteIndex > myEnrollmentList.size());


        // listIndex 1-2-3 ( array 0-1-2 ), input 3 -> array will be 2
        myEnrollmentList.remove(deleteIndex-1);

    }


    // For student table
    private static void studentDependentView(int i, List<Enrollments> myEnrollmentList, List<Students> studentsList){

        for (int s =0; s < studentsList.size();s++){

            if(studentsList.get(s).getStudentIndex() == myEnrollmentList.get(i).getStudentIndex()){
                System.out.println(
                        "\n========== Student List In Enrollment Table =========="+"\n"
                                +"|----------------------------------------------------|"+"\n"
                                +"| Student Name  | Student ID | Date of Birth |"+"\n"
                                +"|----------------------------------------------------|"
                );
                System.out.println(
                        "\u001B[31m  "+studentsList.get(s).getStudentName()+" \t\t| "+
                                studentsList.get(s).getStudentID()+" \t |  "+
                                studentsList.get(s).getDateOfBirth() + "\u001B[0m"+
                                "\n|----------------------------------------------------|"
                );
            }

        }

    }

//    private static void enrollmentListQuery(ArrayList<Enrollments> myEnrollmentList){
////        Enrollments enrollment = new Enrollments();
//        for(int i = 0; i < myEnrollmentList.size(); i++){
//
//            Enrollments enrollment = myEnrollmentList.get(i);
//
//            System.out.println("Semester Index: " + enrollment.getSemesterIndex() +
//                    ", Student Index: " + enrollment.getStudentIndex() +
//                    ", and Course List: " + enrollment.getCourseIndex()
//            );
//        }
//    }
}
