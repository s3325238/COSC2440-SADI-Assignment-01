package General;

import java.util.*;

public class StudentSample {

    private Random defaultRandom = new Random();

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    private String getRandomList(List<String> list) {

        int index = defaultRandom.nextInt(list.size());

        return list.get(index);

    }

    public static String idGenerate(){
        Random idRand = new Random();
        return "s" + (idRand.nextInt(9000000) + 1000000); // return string
    }

    public static String dateOfBirth(){

        String completeDOB;

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1980, 2000);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        completeDOB = gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) + "-" +gc.get(gc.YEAR);

        return completeDOB;

    }

    public static String nameGenerate(){

        String finalLastName;
        String finalFirstName;

        List<String> sampleLastName = Arrays.asList("Phạm","Phan", "Trần");
        List<String> sampleFirstName = Arrays.asList("Trí", "Nhi", "Lộc");

        StudentSample obj = new StudentSample();

        // Last Name
        finalLastName = obj.getRandomList(sampleLastName);
        // First Name
        finalFirstName = obj.getRandomList(sampleFirstName);
        // Combine
        return finalFirstName + " " + finalLastName ;
    }
}
