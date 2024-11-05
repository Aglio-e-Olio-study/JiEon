package study_11_05;
import java.util.*;
import java.io.*;

public class bj_1260 {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visit;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());
        graph = new LinkedList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(graph[i]);
        }
        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visit = new boolean[N+1];
        bfs(V);
        System.out.println(sb);



    }
    static void dfs(int cur){
        visit[cur]=true;
        sb.append(cur+" ");
        for(int i:graph[cur]){
            if(!visit[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        sb.append(V+" ");
        visit[V]=true;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i: graph[p]){
                if(!visit[i]){
                    visit[i]=true;
                    q.offer(i);
                    sb.append(i+" ");
                }
            }
        }
    }
}

