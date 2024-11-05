package study_10_29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1450 {
    static int N;
    static int C;
    static int[] W;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            W[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,N/2,0,listA);//절반의 모든경우의수
        dfs(N/2,N,0,listB);//절반의 모든경우의수
        listB.sort(null);//가능한 max값 이전 숫자카운트 하기 위해
        int count=0;
        for(int num:listA){
            count+=binarySearch(num,listB);//오름차순정렬이므로 최대값 인덱스+1이 가능한 개수
        }
        System.out.println(count);

    }
    static int binarySearch(int num,ArrayList<Integer> list){
        int min=0;
        int max= list.size();
        while(max>min){//이진탐색 으로 가능한 최댓값구하기
            int mid = (min+max)/2;
            if(list.get(mid)+num>C){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    static void dfs(int depth,int end,int sum,ArrayList<Integer> list){
        if(sum>C) {
            return;
        }
        if(depth==end){
            list.add(sum);
            return;
        }
        dfs(depth+1,end,sum,list);//현재 물건을 담지 않았을때 무게sum
        dfs(depth+1,end,sum+W[depth],list);//현재물건을 담았을때 무게sum

    }
}
