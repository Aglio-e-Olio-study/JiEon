package study_10_08;
import java.util.*;
import java.io.*;
public class bj_11000{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<time> list = new LinkedList<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new time(start,end));

        }
        list.sort(null);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.remove(0).end);
        for(time i:list){
            if(i.start<pq.peek()){
                pq.offer(i.end);
            }
            else{
                pq.poll();
                pq.offer(i.end);
            }

        }
        System.out.println(pq.size());


    }
    static class time implements Comparable<time>{
        int start;
        int end;
        time(int start,int end){
            this.start=start;
            this.end = end;
        }
        @Override
        public int compareTo(time o){
            if(this.start==o.start)
                return this.end-o.end;
            return this.start-o.start;
        }
    }
}
