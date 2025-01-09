package study_12_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2206 {
    static Queue<point> q = new LinkedList<point>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static boolean[][][] visit;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[2][n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        System.out.println(bfs());


    }
    static int bfs(){
        visit[0][0][0] = true;
        q.offer(new point(0,0,0,0));
        while(!q.isEmpty()){
            point p = q.poll();
            if(p.x==m-1&&p.y==n-1){
                return p.count+1;
            }

            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=m||ny>=n||nx<0||ny<0) continue;
                if(p.broke==0){
                    if(map[ny][nx]==0&&!visit[p.broke][ny][nx]){
                        visit[p.broke][ny][nx] = true;
                        q.offer(new point(nx,ny,p.count+1,p.broke));
                    }
                    else if(!visit[p.broke+1][ny][nx]){
                        visit[p.broke+1][ny][nx] = true;
                        q.offer(new point(nx,ny,p.count+1,p.broke+1));

                    }
                }
                else{
                    if(map[ny][nx]==0&&!visit[p.broke][ny][nx]){
                        visit[p.broke][ny][nx] = true;
                        q.offer(new point(nx,ny,p.count+1,p.broke));
                    }
                }
            }
        }
        return -1;
    }
    static class point{
        int x;
        int y;
        int count;
        int broke;
        point(int x,int y,int count,int broke){
            this.x = x;
            this.y = y;
            this.count = count;
            this.broke = broke;
        }
    }
}
