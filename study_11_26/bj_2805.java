package study_11_26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2805 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int min=0;
        int mid=0;
        while(max>min){
            mid = (max+min)/2;
            int sum=0;
            for(int i=0;i<N;i++){
                if(arr[i]>mid){
                    sum+=(arr[i]-mid);
                }
                if(sum>M)
                    break;
            }
            if(sum<M){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(min-1);

    }
}
