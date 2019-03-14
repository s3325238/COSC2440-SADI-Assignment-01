package General;

import java.util.Scanner;

public class PositiveNegative {
    public static int integer_number(Scanner scanner, int number){

        while (!scanner.hasNextInt()) {
            System.out.print("\u001B[31mThat's not a number! Please enter again:\u001B[0m ");
            scanner.next(); // this is important!
        }
        number = scanner.nextInt();

        if(number < 0){
            System.out.println("\u001B[31mPlease enter positive number only!\u001B[0m");
        } else if(number == 0){
            System.out.println("\u001B[31mYou cannot enter number 0!\u001B[0m");
        }
        return number;

    }

}
