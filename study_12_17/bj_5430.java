package study_12_17;
import java.util.*;
import java.io.*;

public class bj_5430 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int j=0;j<T;j++){
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            //LinkedList<Integer> list = new LinkedList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            String arr = br.readLine();
            arr = arr.replace("[","");
            arr = arr.replace("]","");
            arr = arr.replace(","," ");
            StringTokenizer st = new StringTokenizer(arr);
            for(int i=0;i<n;i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            boolean front = true;
            boolean flag = true;
            for(int i=0;i<command.length();i++){
                if(command.charAt(i)=='R'){
                    front=!front;
                }
                else{//"D"
                    if(deque.size()>0){
                        if(front){
                            deque.removeFirst();
                        }
                        else{
                            deque.removeLast();
                        }
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
            }
            if(!flag){
                sb.append("error\n");
            }
            else{
                sb.append("[");
                int size = deque.size();

                if(front){
                    for(int i=0;i<size;i++){
                        sb.append(deque.removeFirst());
                        if(i!=size-1){
                            sb.append(",");
                        }
                    }
                }
                else{
                    for(int i=size-1;i>=0;i--){
                        sb.append(deque.removeLast());
                        if(i!=0){
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
