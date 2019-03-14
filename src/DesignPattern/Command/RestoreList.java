package DesignPattern.Command;
import java.util.*;

import Model.Courses.Courses;
import Model.Students.Students;

public class RestoreList implements Command {

    private OriginalList originalList;

    private List<Students> newStudentList;
    private List<Courses> newCourseList;

    private List<Students> backupStudentList;
    private List<Courses> backupCourseList;

    public RestoreList(OriginalList originalList, List<Students> newStudentList, List<Courses> newCourseList) {
        this.originalList = originalList;
        this.newStudentList = newStudentList;
        this.newCourseList = newCourseList;
    }

    @Override
    public void execute() {
        backupStudentList = originalList.getStudentsList();
        backupCourseList = originalList.getCoursesList();

        originalList.setStudentsList(newStudentList);
        originalList.setCoursesList(newCourseList);
    }

    @Override
    public void restoreStudentList() {
        originalList.setStudentsList(backupStudentList);
//        originalList.setStudentsList(studentsList);
    }

    @Override
    public void restoreCourseList(List<Courses> coursesList) {
//        originalList.setCoursesList(backupCourseList);
        originalList.setCoursesList(coursesList);
    }
}
