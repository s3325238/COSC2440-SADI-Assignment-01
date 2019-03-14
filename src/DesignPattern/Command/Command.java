package DesignPattern.Command;

import Model.Courses.Courses;
import Model.Students.Students;

import java.util.List;

public interface Command {
    public void execute();
    public void restoreStudentList();
    public void restoreCourseList(List<Courses> coursesList);
}
