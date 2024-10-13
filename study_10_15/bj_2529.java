package study_10_15;

import java.util.*;
import java.io.*;

public class bj_2529 {
    static int n;
    static char[] signs;
    static LinkedList<String> answer = new LinkedList<>();
    static boolean[] visit;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[n];
        visit = new boolean[10];
        for(int i=0;i<n;i++){
            signs[i] = st.nextToken().charAt(0);// 부등호들 저장
        }
        dfs(0,"");
        System.out.println(answer.get(answer.size()-1));//0부터 시작하므로 마지막이 제일큼
        System.out.println(answer.get(0));

    }
    static void dfs(int depth,String num){
        if(depth==n+1){//가능한 숫자들을 answer리스트에 모두 저장
            answer.add(num);
            return;
        }
        for(int i=0;i<10;i++){
            if(!visit[i]&&(depth==0||check(num.charAt(depth-1),(char)('0'+i),signs[depth-1]))){
                //처음들어올수는 모두가능, 두번째부턴 크기비교필수
                visit[i]=true;//숫자 한번만 사용
                dfs(depth+1,num+(char)('0'+i));//num+X  구조로 빠져나왔을때 num에서 지워 줄 필요없음
                visit[i]=false;
            }
        }
    }
    static boolean check(char a,char b,char sign){
        /*if(sign=='<'){
            return a < b;
        }
        else if(sign=='>'){
            return a > b;
        }*/
        return sign=='<' ? a<b:a>b;
    }
}