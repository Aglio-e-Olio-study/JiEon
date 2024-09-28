package study_10_01;

import java.util.*;
import java.io.*;
public class bj_2563 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[100][100];//흰색은 false
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=y;j<y+10;j++){//선택부위색칠
                for(int k=x;k<x+10;k++){
                    map[j][k]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j])
                    count++;//전체 맵중에 검은색(true)부분 카운트
            }
        }
        System.out.println(count);
    }
}
