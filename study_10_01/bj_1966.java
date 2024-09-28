package study_10_01;
import java.util.*;
import java.io.*;
public class bj_1966 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int test_case=0;test_case<T;test_case++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int targetPage = Integer.parseInt(st.nextToken());//타켓페이지넘버
            int count=0;//인쇄된 페이지 카운트
            PriorityQueue<page> pq = new PriorityQueue<>();//중요도 높은 문서 비교를 위해 사용
            Queue<page> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                page temp = new page(i,Integer.parseInt(st.nextToken()));
                q.offer(temp);
                pq.offer(temp);
            }
            while(true){
                if(pq.peek().imp==q.peek().imp){//현재 페이지의 중요도가 최대인지 확인
                    pq.poll();
                    int x=q.poll().num;
                    count++;
                    if(targetPage==x){//현재 페이지가 타켓페이지일 경우
                        break;
                    }
                }else{
                    q.offer(q.poll());//페이지를 뒤로 보냄
                }
            }
            System.out.println(count);

        }
    }
    static class page implements Comparable<page>{
        int num;//페이지 넘버
        int imp;//페이지중요도
        page(int num,int imp){
            this.num=num;
            this.imp=imp;
        }
        @Override
        public int compareTo(page o) {//페이지 중요도내림차순 정렬
            return o.imp-this.imp;
        }
    }
}

