package Model.Students;

import General.StudentSample;

import java.util.*;

public class StudentsList {

    public static List<Students> myStudentList(int number){

        ArrayList<Students> myStudent = new ArrayList();

        for(int counter = 0; counter < number; counter ++){
            Students xx = new Students();

            xx.setStudentIndex(counter+1);
            xx.setStudentName(StudentSample.nameGenerate());
            xx.setStudentID(StudentSample.idGenerate());
            xx.setDateOfBirth(StudentSample.dateOfBirth());

            myStudent.add(xx);
        }
        return myStudent;

    }

    public static void printStudentList(List<Students> studentsList, String encode, String decode ){

        Students sts = new Students();
        for(int counterx = 0; counterx < studentsList.size();counterx++){
            sts = studentsList.get(counterx);

            System.out.println(encode + (counterx + 1) + "\t\t| " + sts.getStudentName()+" \t\t| " + sts.getStudentID()+" \t |  "+sts.getDateOfBirth() + decode);
            System.out.println("|----------------------------------------------------|");

        }
        System.out.print("\n\n");
    }

}
