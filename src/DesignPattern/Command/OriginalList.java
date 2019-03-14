package DesignPattern.Command;

import java.util.*;

import Model.Courses.Courses;
import Model.Students.Students;

public class OriginalList {

    private List<Students> originalStudentList;
    private List<Courses> originalCourseList;

    public OriginalList(List<Students> studentsList, List<Courses> coursesList) {
        this.originalStudentList = studentsList;
        this.originalCourseList = coursesList;
    }

    public List<Students> getStudentsList() {
        return originalStudentList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.originalStudentList = studentsList;
    }

    public List<Courses> getCoursesList() {
        return originalCourseList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.originalCourseList = coursesList;
    }
}
