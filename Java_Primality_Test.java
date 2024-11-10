
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Java_Primality_Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ;
        
        String n=br.readLine();
        br.close();
        BigInteger bi=new BigInteger(n);
        if(bi.isProbablePrime(10)){
            System.out.println("prime");
        }else{
                System.out.println("not prime");
            }
        

        
    }
    }


