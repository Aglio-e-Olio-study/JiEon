package study_10_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14620 {
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,  1, 0);
        System.out.println(min);

    }
    static void dfs(int depth,int y,int sum){
        if(depth==3){//꽃 3개를 모두 심었을때
            if(min>sum){
                min=sum;
            }
        }
        for(int i=y;i<n-1;i++){
            for(int j=1;j<n-1;j++){
                if(!visit[i][j]&&!visit[i-1][j]&&!visit[i+1][j]&&!visit[i][j-1]&&!visit[i][j+1]){//겹치지않을때
                    if(sum+map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]+map[i][j+1]>=min)//min보다 크면 놓을필요없음
                        continue;
                    toggle(j,i);//visit=true역할
                    dfs(depth+1,i,sum+map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]+map[i][j+1]);//다음 꽃잎, 좌표+상하좌우 가격
                    toggle(j,i);//visit=false역할
                }
            }
        }
    }
    static void toggle(int x,int y){
        visit[y][x]=!visit[y][x];

        visit[y-1][x]=!visit[y-1][x];
        visit[y+1][x]=!visit[y+1][x];
        visit[y][x-1]=!visit[y][x-1];
        visit[y][x+1]=!visit[y][x+1];
    }
}
