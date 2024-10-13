package study_10_15;
import java.io.*;
import java.util.*;

public class bj_9663 {
    static int N;
    static int count;
    static boolean[][] visit;
    static int[] dx = {-1,0,1};//좌상->우상
    static int[] dy = {-1,-1,-1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        dfs(0);
        System.out.println(count);
    }
    static void dfs(int depth){
        if(depth==N){
            count++;
            return;
        }

        for(int j=0;j<N;j++){
            if(check(j,depth)){
                visit[depth][j]=true;
                dfs(depth+1);
                visit[depth][j]=false;
            }
        }
    }
    static boolean check(int x,int y){
        for(int i=0;i<3;i++){
            int nx = x;
            int ny = y;
            while(true){
                nx+=dx[i];
                ny+=dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N)//map의 범위를 넘어가면 break;
                    break;
                if(visit[ny][nx]){//이동가능위치에 퀸이있으면 false리턴
                    return false;
                }
            }
        }
        return true;
    }
}
