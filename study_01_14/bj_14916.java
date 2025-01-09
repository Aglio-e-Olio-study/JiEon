package study_01_14;
import java.util.*;
import java.io.*;

public class bj_14916 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=0;
        while(n>0){
            if(n%5==0){
                count+=n/5;
                break;
            }
            n-=2;
            count++;
        }
        if(n<0){
            System.out.println(-1);
        }
        else{
            System.out.println(count);
        }
    }
}
