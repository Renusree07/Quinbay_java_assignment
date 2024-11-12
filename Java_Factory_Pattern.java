import java.io.*; 
import java.util.*;

interface Food {

public String getType();
}

class Cake implements Food{ public String getType(){

    return"The factory returned class Cake\nSomeone ordered a Dessert!";
}
}

class Pizza implements Food{ public String getType(){

    return"The factory returned class Pizza\nSomeone ordered a Fast Food!";
}
}

public class Java_Factory_Pattern {

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner s = new Scanner(System.in);
    String str =s.next();
    if(str.compareTo("cake") ==0){
        Food obj = new Cake();
    System.out.println(obj.getType());

    }
  if(str.compareTo("pizza") ==0){
      Food obj = new Pizza();
        System.out.println(obj.getType());

    }



}
}