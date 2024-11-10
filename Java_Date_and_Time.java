import java.io.*;
import java.util.*;

class Result { 

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

   public static String findDay(int month, int day, int year) {
       if (month < 3) {
           month += 12;
           year -= 1;   
       }
       int years = year % 100;
       int cyears = year / 100;
       int h = (day + (13 * (month + 1)) / 5 + years + (years / 4) + (cyears / 4) - 2 * cyears) % 7;
       if (h < 0) {
           h += 7;  // Ensure h is a positive number between 0 and 6
       }
       String[] weekday = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
       return weekday[h];
   }
}

public class Java_Date_and_Time { 
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        System.out.println(res);  // Print result to console instead of writing to a file

        bufferedReader.close();
    }
}
