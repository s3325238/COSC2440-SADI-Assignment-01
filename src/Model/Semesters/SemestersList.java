package Model.Semesters;

import java.util.*;

public class SemestersList {

    public static List<Semesters> mySemesterList(int number){

        int year = Calendar.getInstance().get(Calendar.YEAR);

        ArrayList<Semesters> mySemester = new ArrayList<Semesters>();

        for (int i = 65; i < (65 + number); i++) {
            String s = year+String.valueOf((char)i);
            Semesters ss = new Semesters();
            ss.setSemesterIndex( i-64 );
            ss.setSemesterName(s);
            mySemester.add(ss);
        }
        return mySemester;
    }

    public static void printSemesterList(List<Semesters> semesterList, String encode, String decode){
        // Not insert encode and decode ANSI
        Semesters ss = new Semesters();
        for (int i = 0; i < semesterList.size() ; i++) {

            ss = semesterList.get(i);

            System.out.println(encode + "Semester list: " + decode + ss.getSemesterName());

            System.out.println();
        }
    }

}
