//import DesignPattern.Command.OriginalList;
//import DesignPattern.Command.RestoreList;
//import DesignPattern.Decorator.ByeMessage;
//import DesignPattern.Decorator.Decorator;
//import DesignPattern.Decorator.Message;
import DesignPattern.Factory.GeneralInterfaceFactory;
import DesignPattern.Singleton.Singleton;
import General.DataInitiation;

import Model.Semesters.*;
import Model.Students.*;
import Model.Courses.*;
import StudentEnrollmentManager.StudentManager;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GeneralInterfaceFactory general_interface_factory = new GeneralInterfaceFactory();

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";

        // Welcome Message with Single Design Pattern
        Singleton singleton = Singleton.getInstance();
        singleton.hello();

        // Semester
        int semesterTotal = DataInitiation.dataInput(sc,"semester");
        List<Semesters> semesterList =  SemestersList.mySemesterList(semesterTotal);
        SemestersList.printSemesterList(semesterList,ANSI_RED,ANSI_RESET);

        // Student
        int studentTotal = DataInitiation.dataInput(sc,"student");
        general_interface_factory.printGeneralLine("student");

        List<Students> studentsList = StudentsList.myStudentList(studentTotal);
        StudentsList.printStudentList(studentsList,ANSI_RED,ANSI_RESET);

        // Course
        general_interface_factory.printGeneralLine("course");
        List<Courses> courseList = CoursesList.myCourseList();
        CoursesList.printCourseList(courseList,ANSI_RED,ANSI_RESET);

        // Student Manager Role
        StudentManager studentManager = new StudentManager();
        studentManager.execute(sc,semesterList,studentsList,courseList);

    }
}
