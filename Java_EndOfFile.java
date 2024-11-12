import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Java_EndOfFimplements {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
          int i = 0;
        while(scanner.hasNext()){
           String frase = scanner.nextLine();
            i++;
               System.out.println(i + " " + frase);
           }
       scanner.close();
    }
}
