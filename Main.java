/*This program is designed to
find all prime numbers within
a given range.
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello there! This program is designed to find all prime numbers within a given range.");
        System.out.println("Please input a integer greater than 1:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean isInt = false;
        int range = 0;

        //Handle invalid input.
        while (!isInt) {
            try {
                range = Integer.parseInt(input);
                if (range>2) {
                    isInt = true;
                    break;
                };
                isInt = false;
                System.out.println("Invalid input. Please try again");
                System.out.println("Please input a integer greater than 1:");
                input = sc.nextLine();
            }  catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
                System.out.println("Please input a integer greater than 1:");
                input = sc.nextLine();
                isInt = false;
            }
        }

        //Use index as numbers and true means it is not a prime number.
        boolean[]  primeList;
        primeList = new boolean[range+1];
        primeList[0] = true;
        primeList[1] = true;


        for (int i=2; i<range+1; i++) {
            for(int j=2; j*j<=i; j++) {
                if ((i % j == 0)&&(!primeList[i]))  {
                    primeList[i] = true;
                    break;
                }
            }

            //remove all multiples of i.
            for (int j = 2; j<range/i; j++) {
                if (!primeList[i*j]) primeList[i*j] = true;
            }
        }

        int size = 0;
        System.out.println("The prime numbers are:");
        for (int i = 0; i<range+1; i++) {
            if (!primeList[i]) {
                System.out.print(i+" ");
                size++;
                System.out.println();
            }
        }
        System.out.println("There are in total "+size+" prime numbers.");




    }
}
