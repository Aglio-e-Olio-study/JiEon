package study_11_05;
import java.util.*;
import java.io.*;

public class bj_2206 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[2][n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }
        bfs();

    }
    static void bfs(){
        Queue<point> q =new LinkedList<>();
        q.offer(new point(0,0,0,0));
        visit[0][0][0]=true;
        while(!q.isEmpty()){
            point p = q.poll();
            if(p.x==m-1&&p.y==n-1){
                System.out.println(p.count+1);
                System.exit(0);
            }
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(ny>=n||ny<0||nx>=m||nx<0)
                    continue;
                if(p.broke==0){
                    if(map[ny][nx]==0&&!visit[p.broke][ny][nx]){
                        q.offer(new point(nx,ny,p.count+1,p.broke));
                        visit[p.broke][ny][nx]=true;
                    }
                    else if(!visit[p.broke+1][ny][nx]){
                        q.offer(new point(nx,ny,p.count+1,p.broke+1));
                        visit[p.broke+1][ny][nx]=true;
                    }
                }
                else{
                    if(map[ny][nx]==0&&!visit[p.broke][ny][nx]){
                        if(!visit[p.broke][ny][nx]){
                            q.offer(new point(nx,ny,p.count+1,p.broke));
                            visit[p.broke][ny][nx]=true;
                        }
                    }

                }
            }
        }
        System.out.println(-1);
    }
    static class point{
        int x;
        int y;
        int count;
        int broke;
        point(int x,int y,int count,int broke){
            this.x=x;
            this.y=y;
            this.count=count;
            this.broke=broke;

        }
    }
}
