package DesignPattern.Factory;

import DesignPattern.Interface.BasicInterface;
import DesignPattern.Interface.CourseInterface;
import DesignPattern.Interface.StudentInterface;

public class GeneralInterfaceFactory {

    public BasicInterface getPrintLine(String type){
        if(type.equals("course")){
            return new CourseInterface();
        }else {
            return new StudentInterface();
        }
    }

    public static void printGeneralLine(String type){
        if(type.equals("student")){

            GeneralInterfaceFactory general_interface_factory = new GeneralInterfaceFactory();

            BasicInterface student_interface = general_interface_factory.getPrintLine("student");

            student_interface.printLine();

        }else{

            GeneralInterfaceFactory general_interface_factory = new GeneralInterfaceFactory();

            BasicInterface course_interface = general_interface_factory.getPrintLine("course");

            course_interface.printLine();
        }
    }

}
