import java.io.*;
import java.util.*;

public class Java_String_Reverse{

    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    String A=sc.nextLine();
    int i =0;
    int j =A.length()-1;
    while(i<j){
        if(A.charAt(i)!=A.charAt(j)){
            System.out.println("No");
            System.exit(0);

        }
        i++;
        j--;

    }
    System.out.println("Yes");

}
}





