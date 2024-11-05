package study_10_22;
import java.util.*;
import java.io.*;
public class bj_15927{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer=str.length();
        if(palin(str)){
            answer = str.length()-1;
        }
        if(allSame(str)){
            answer=-1;
        }
        System.out.println(answer);
    }
    static boolean palin(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    static boolean allSame(String str){
        char c = str.charAt(0);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=c){
                return false;
            }
        }
        return true;
    }
}