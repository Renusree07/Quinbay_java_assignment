
    import java.util.Scanner;

    public class Java_Anagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();
        int[] aFreq = new int[255];
        int[] bFreq = new int[255];
        
        for (int i = 0; i < a.length(); i++) {
            aFreq[(int) aLower.charAt(i)] += 1;
            bFreq[(int) bLower.charAt(i)] += 1;
        }
        
        for (int i = 0; i < a.length(); i++) {
            int cA = (int) aLower.charAt(i);
            int cB = (int) bLower.charAt(i);
            if (aFreq[cA] != bFreq[cA] || aFreq[cB] != bFreq[cB]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

