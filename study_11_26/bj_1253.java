package study_11_26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class bj_1253 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // 배열 입력
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr); // 배열 정렬 (이분 탐색을 위한 준비)
//
//        int count = 0;
//
//        // 배열 내 모든 숫자 탐색
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < i; j++) { // 두 수 선택
//                int target = arr[i];
//                int a = arr[j];
//                int left = 0;
//                int right = j - 1;
//                boolean flag = false;
//
//                // 이분 탐색으로 두 수의 합을 찾음
//                while (left < right) {
//                    int mid = (left + right) / 2;
//
//                    if (arr[mid] + a == target) {
//                        flag = true;
//                        break;
//                    } else if (arr[mid] + a < target) {
//                        left = mid +1;
//                    } else {
//                        right = mid;
//                    }
//                }
//
//                if (flag) {
//                    count++;
//                    break; // 조건 만족 시 더 이상 탐색하지 않음
//                }
//            }
//        }
//
//        System.out.println(count);
//    }
//}
static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<Integer>[] list;


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            list[src].add(dst);
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        dist[X] = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int p = q.poll();
            if(dist[p]>K) break;
            if(dist[p]==K) ans.add(p);
            for(int i: list[p]){
                if (dist[i] != -1) continue;//이미방문했는지 확인
                dist[i] = dist[p]+1;
                q.add(i);
            }
        }
        Collections.sort(ans);
        if(ans.size()==0){
            System.out.println(-1);
        }
        else{
            for(int i:ans){
                System.out.println(i);
            }
        }

    }
}