import java.util.Scanner;

public class Java_Substring_Comparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        String dummy = "";
        for(int i=0;i<s.length()-k;i++){
                dummy = s.substring(i+1,i+k+1);
                if(dummy.compareTo(smallest)<0) smallest = dummy;
                if(dummy.compareTo(largest)>0) largest = dummy;
            }
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}