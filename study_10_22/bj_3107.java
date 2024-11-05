package study_10_22;
import java.io.*;
import java.util.*;
public class bj_3107 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Character> ans = new LinkedList<>();
        int colonCount=0;
        str = str.replaceAll("::",":zero1:");
        if(str.charAt(0)==':'){
            str = str.substring(1,str.length());

        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==':')
                colonCount++;
        }
        if(str.charAt(str.length()-1)==':'){
            colonCount--;

        }

        for(int i=0;i<7-colonCount;i++){
            str = str.replaceAll("zero1:","zero1:zero2:");
        }
        str = str.replaceAll("zero1","0000");
        str = str.replaceAll("zero2","0000");

        if(str.charAt(str.length()-1)==':'){
            str = str.substring(0,str.length()-1);

        }

        StringBuffer sb = new StringBuffer();
        //4자리로 채워주기
        int count=0;
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(c==':'&&count<4){
                for(int j=0;j<4-count;j++){
                    sb.append('0');

                }
                count=0;
            }
            sb.append(c);
            if(c==':') {
                count=0;
            }
            else{
                count++;
            }
        }
        for(int i=sb.length();i<39;i++){
            sb.append('0');
        }
        sb.reverse();
        System.out.println(sb);

    }
}
