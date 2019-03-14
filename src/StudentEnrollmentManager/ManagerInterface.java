package StudentEnrollmentManager;

import Model.Courses.Courses;
import Model.Semesters.Semesters;
import Model.Students.Students;

import java.util.*;

public interface ManagerInterface {
    void execute(Scanner sc, List<Semesters> semestersList, List<Students> studentsList, List<Courses> coursesList);
}
