package study_10_22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_12904 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer str = new StringBuffer(br.readLine());
        StringBuffer target = new StringBuffer(br.readLine());

        while(str.length()!=target.length()){
            if(target.charAt(target.length()-1)=='A'){
                target.deleteCharAt(target.length()-1);
            }
            else{
                target.deleteCharAt(target.length()-1);
                target.reverse();
            }
        }
        if(target.toString().equals(str.toString())){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}
