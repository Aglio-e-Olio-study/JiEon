package study_10_08;
import java.util.*;
import java.io.*;
public class bj_13305 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] dist = new long[n-1];
        long[] price = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            price[i] = Long.parseLong(st.nextToken());
        }
        long minprice = price[0];
        long total = 0L;
        for(int i=0;i<n-1;i++){
            if(minprice>price[i]){
                minprice=price[i];
            }
            total+=minprice*dist[i];
        }
        System.out.println(total);
    }
}
