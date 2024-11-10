import java.util.*;
public class Java_Stdin_and_Stdout_II {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double j=scan.nextDouble();
        scan.nextLine();
        String k=scan.nextLine();
        
        

        System.out.println("String: " + k);
        System.out.println("Double: " + j);
        System.out.println("Int: " + i);
    }
}
