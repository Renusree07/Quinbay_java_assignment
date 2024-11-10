import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tag_Content_Extractor {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    for(int i=0; i<n; i++){ 
        String input = scanner.nextLine();
        String reg = "<([^<>]+)>([^<>]+)</\\1>";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);

            if(!(matcher.find())){
                System.out.println("None");
            }
            matcher = pattern.matcher(input);
            while(matcher.find()){
                String matchStr = matcher.group(2);
                Matcher matcher2 = pattern.matcher(matchStr);
                while(matcher2.find()){
                    matchStr = matcher2.group(2);
                    matcher2 = pattern.matcher(matchStr);
                }
                System.out.println(matchStr);
            
		}
	}
}
}




