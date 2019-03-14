package DesignPattern.Interface;

public class CourseInterface implements BasicInterface {
    @Override
    public void printLine() {
        System.out.println(
            "================================== Course List ================================="+"\n"
            +"|------------------------------------------------------------------------------|"+"\n"
            +"| Index | Course Code\t| Course Name \t\t\t\t\t\t\t\t\t\t   |"+"\n"
            +"|------------------------------------------------------------------------------|"
        );
    }
}
