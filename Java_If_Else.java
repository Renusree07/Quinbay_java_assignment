import java.util.*;
public class Java_If_Else {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        if(N%2!=0){
            System.out.println("Weird");}
        else{
         if (2<=N&& N<=5){
            System.out.println("Not Weird");}
         if(6<=N && N<=20){
             System.out.println("Weird");
         }
         else if(N>20){
             System.out.println("Not Weird");
         }
        }
       scanner.close(); 
        
    }
}