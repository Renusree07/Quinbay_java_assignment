import java.io.*;
import java.util.*;

public class Java_Strings_Introduction {

    public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    String A=sc.next();
    String B=sc.next();
    int a = A.length() + B.length();
    int b = A.compareTo(B);

    String s1 = A.replace(A.charAt(0), A.toUpperCase().charAt(0));
    String s2 = B.replace(B.charAt(0), B.toUpperCase().charAt(0));

    System.out.println(a);
    if(b>0){
        System.out.println("Yes");
    }
    else{
        System.out.println("No");
    }
    System.out.println(s1 + " " +s2);


        
    }
}



