package study_11_26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class bj_1253 {
    static int N;
    static int[] arr;
    static int count=0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            int left = 0;
            int right = N-1;
            while(left<right){
                if(left==i){
                    left++;
                    continue;
                }
                else if(right==i){
                    right--;
                    continue;
                }
                if(arr[left]+arr[right]==arr[i]){
//                    System.out.println(arr[left]+" " +arr[right] +" "+ arr[i]);
                    count++;
                    break;
                }
                else if(arr[left]+arr[right]>arr[i]){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}