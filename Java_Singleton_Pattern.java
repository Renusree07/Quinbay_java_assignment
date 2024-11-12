import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Java_Singleton_Pattern{
    private static Java_Singleton_Pattern instance = null;
    private Java_Singleton_Pattern(){};
    public String str;
    public static Java_Singleton_Pattern getSingleInstance(){
        if (instance == null){
            instance = new Java_Singleton_Pattern();
            return instance;
        }
        return instance;
    }
}