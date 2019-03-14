package DesignPattern.Interface;

public class StudentInterface implements BasicInterface {
    @Override
    public void printLine() {
        System.out.println(
            "==================== Student List ===================="+"\n"
            +"|----------------------------------------------------|"+"\n"
            +"| Index | Student Name  | Student ID | Date of Birth |"+"\n"
            +"|----------------------------------------------------|"
        );
    }
}
