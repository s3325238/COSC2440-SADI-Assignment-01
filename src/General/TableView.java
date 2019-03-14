package General;

import Model.Courses.Courses;
import Model.Enrollments.Enrollments;
import Model.Students.Students;

import java.util.*;

public class TableView {
    public static void studentView(ArrayList<Enrollments> myEnrollmentList, List<Students> studentsList){
        System.out.println(
                "========== Student List In Enrollment Table =========="+"\n"
                +"|----------------------------------------------------|"+"\n"
                +"| Index | Student Name  | Student ID | Date of Birth |"+"\n"
                +"|----------------------------------------------------|"
        );
        for(int i = 0; i< myEnrollmentList.size();i++){
            for (int s = 0; s < studentsList.size(); s++){
                if(studentsList.get(s).getStudentIndex() == myEnrollmentList.get(i).getStudentIndex()){
                    System.out.println(
                            "\u001B[31m" + (i + 1) + "\t\t| "+
                                    studentsList.get(s).getStudentName()+" \t\t| "+
                                    studentsList.get(s).getStudentID()+" \t |  "+
                                    studentsList.get(s).getDateOfBirth() + "\u001B[0m"+
                                    "\n|----------------------------------------------------|"
                    );
                }
            }
        }
    }

    public static void courseView(ArrayList<Integer> specificCourseIndex, List<Courses> coursesList){
        System.out.println(
                "\n======================== Enrolled Course List ========================"+"\n"
                        +"|--------------------------------------------------------------------|"+"\n"
                        +"| Course Code\t| Course Name \t\t\t\t\t\t\t\t         |"+"\n"
                        +"|--------------------------------------------------------------------|"
        );
        // In courseIndex of EnrollmentList
        for (int c = 0; c < specificCourseIndex.size(); c++){

            for (int l = 0; l < coursesList.size(); l++){

                if(specificCourseIndex.get(c) == coursesList.get(l).getCourse_index()){
                    System.out.println("\u001B[31m  " + coursesList.get(l).getCourse_code()+" \t\t| " + coursesList.get(l).getCourse_name()+"\u001B[0m");
                    System.out.println("|--------------------------------------------------------------------|");
                }

            }

        }
    }
}
