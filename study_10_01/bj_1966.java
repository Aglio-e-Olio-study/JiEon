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
            int targetPage = Integer.parseInt(st.nextToken());
            int count=0;
            PriorityQueue<page> pq = new PriorityQueue<>();
            Queue<page> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                page temp = new page(i,Integer.parseInt(st.nextToken()));
                q.offer(temp);
                pq.offer(temp);
            }
            while(true){
                if(pq.peek().imp==q.peek().imp){
                    pq.poll();
                    int x=q.poll().num;
                    count++;
                    if(targetPage==x){
                        break;
                    }
                }else{
                    q.offer(q.poll());
                }
            }
            System.out.println(count);

        }
    }
    static class page implements Comparable<page>{
        int num;
        int imp;
        page(int num,int imp){
            this.num=num;
            this.imp=imp;
        }
        @Override
        public int compareTo(page o) {
            return o.imp-this.imp;
        }
    }
}

