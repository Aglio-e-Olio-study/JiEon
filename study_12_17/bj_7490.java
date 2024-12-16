package study_12_17;
import java.util.*;
import java.io.*;
public class bj_7490 {
    static StringBuffer sb = new StringBuffer();
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            n = Integer.parseInt(br.readLine());
            dfs(2,"1");
            if(i!=T-1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
    static void dfs(int depth,String str){
        if(depth==n+1){

            String str2 = str.replace(" ","");
            if(cal(str2)){
                sb.append(str+"\n");
            }
            return;
        }
        dfs(depth+1,str+" "+depth);
        dfs(depth+1,str+"+"+depth);
        dfs(depth+1,str+"-"+depth);


    }
    static boolean cal(String str){
        LinkedList<Integer> operand = new LinkedList<>();
        LinkedList<Character> operator = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'){
                operator.add(str.charAt(i));
            }
            else if(str.charAt(i)=='-'){
                operator.add(str.charAt(i));
            }
        }
        str = str.replace("+"," ");
        str = str.replace("-"," ");

        StringTokenizer st = new StringTokenizer(str);
        int answer = Integer.parseInt(st.nextToken());
        for(int i=0;i<operator.size();i++){
            if(operator.get(i)=='+'){
                answer+=Integer.parseInt(st.nextToken());
            }
            else{
                answer-=Integer.parseInt(st.nextToken());
            }
        }
        if(answer==0)  return true;
        return false;

    }

}