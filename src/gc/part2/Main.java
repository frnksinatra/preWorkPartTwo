package gc.part2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//prompt for user input
        System.out.println("Enter in two dates (yyyy-mm-dd format), each followed by hitting enter. Enter the later date first and I can tell you the difference in time... ");
        Scanner input = new Scanner(System.in);

//setting the strings to the two inputs using the scanner

        String one = input.nextLine();
        String two = input.nextLine();

//splitting the input up into parts we can convert to integers

        String [] firstdate = one.split("-");
        String [] seconddate = two.split("-");

//integer conversion

        int year1 = Integer.parseInt(firstdate[0]);
        int month1 = Integer.parseInt(firstdate[1]);
        int day1 = Integer.parseInt(firstdate[2]);
        int year2 = Integer.parseInt(seconddate[0]);
        int month2 = Integer.parseInt(seconddate[1]);
        int day2 = Integer.parseInt(seconddate[2]);


        int yeardiff = year1 - year2;
        int monthdiff;
        int daydiff;

//loops used to calculate the difference

        if (month2>month1){
            yeardiff = yeardiff - 1;
            monthdiff = (month1 + 12) - month2;
        } else {
            monthdiff = month1 - month2;
        }
        if (day2>day1){
            if (month1 == 2){
                monthdiff = monthdiff - 1;
                daydiff = (day1 + 28) - day2;
            }else if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
                monthdiff = monthdiff - 1;
                daydiff = (day1 + 31) - day2;
            } else {
                monthdiff = monthdiff - 1;
                daydiff = (day1 + 30) - day2;
            }
        } else {
            daydiff = day1 - day2;
        }
//leap year check

        if (year2 % 4 == 0 && month2 <= 2) {
            daydiff = daydiff + 1;
        }  else if (year1 % 4 == 0 && month1 > 2){
            daydiff = daydiff + 1;
        }
        System.out.println("There are " + yeardiff + " year(s), " + monthdiff + " month(s), and " + daydiff + " day(s) between the two dates you have entered.");
        input.close();
    }
}
