package study_10_29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1495 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N+1];
        boolean[][] dp = new boolean[N+1][M+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            V[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S]=true;
        for(int i=1;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(dp[i-1][j]){
                    int plus = j+V[i];//다음곡에서의 가능한 볼륨
                    int minus = j-V[i];
                    if(plus<=M)
                        dp[i][plus]=true;
                    if(minus>=0)
                        dp[i][minus]=true;
                }
            }
        }
        int answer=-1;
        for(int i=M;i>=0;i--){
            if(dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);




    }
}
