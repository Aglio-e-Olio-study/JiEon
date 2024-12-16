package study_12_17;
import java.util.*;
import java.io.*;
public class bj_1541{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Integer> operand = new LinkedList<>();
        LinkedList<Character> operator = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                operator.add(str.charAt(i));
            }
        }
        str = str.replace("+"," ");
        str = str.replace("-"," ");StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            operand.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<operator.size();i++){
            if(operator.get(i) == '+'){
                int a = operand.remove(i);
                int b = operand.remove(i);
                operator.remove(i);
                operand.add(i,a+b);
                i--;
            }
        }
        int answer = operand.removeFirst();
        for(int x: operand){
            answer-=x;
        }
        System.out.println(answer);

    }
}
