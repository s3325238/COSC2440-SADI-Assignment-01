package Model.Courses;

import java.util.*;

public class CoursesList {

    public static List<Courses> myCourseList(){
        String[] sampleCode = {
                "COSC2083","COSC2429","COSC2500","COSC2081","COSC2174"
        };
        String[] sampleName = {
                "Introduction to Information Technology",
                "Introduction To Programming",
                "Intro to Computer Systems and Platform Technologies",
                "Programming 1",
                "Data communication & Net-Centric Computing"
        };

        int arrayLength = sampleCode.length;

        ArrayList<Courses> myCourse = new ArrayList<Courses>();

        for (int i = 0; i < arrayLength; i++){

            Courses courses = new Courses();

            courses.setCourse_index(i+1);
            courses.setCourse_code(sampleCode[i]);
            courses.setCourse_name(sampleName[i]);

            myCourse.add(courses);
        }

        return myCourse;
    }

    public static void printCourseList(List<Courses> courseList, String encode, String decode ){
        Courses courses = new Courses();
        for(int counterx = 0; counterx < courseList.size();counterx++){
            courses = courseList.get(counterx);

            System.out.println(encode + (counterx + 1) + "\t\t| " + courses.getCourse_code()+" \t\t| " + courses.getCourse_name()+ decode);
            System.out.println("|------------------------------------------------------------------------------|");
        }
    }

}
