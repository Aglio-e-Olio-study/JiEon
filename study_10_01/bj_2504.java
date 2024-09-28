package study_10_01;
import java.util.*;
import java.io.*;
public class bj_2504 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Character> stk = new Stack<>();//잘못된 괄호는 스택에 나머지가 생김
        int value=1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c=='('){//괄호가 열리면 push
                stk.push(c);
                value*=2;
            }
            else if(c=='['){
                stk.push(c);
                value*=3;
            }
            else if(c==')'){
                if(stk.isEmpty()){
                    stk.push(c);
                    break;
                }
                if(stk.peek()=='('){
                    stk.pop();
                }
                if(str.charAt(i-1)=='('){
                    list.add(value);// () 형태or []형태일때만 값추가
                }
                value/=2;
            }
            else if(c==']'){
                if(stk.isEmpty()){
                    stk.push(c);
                    break;
                }
                if(stk.peek()=='['){
                    stk.pop();
                }
                if(str.charAt(i-1)=='['){
                    list.add(value);
                }
                value/=3;
            }
        }
        if(stk.size()>0){
            System.out.println(0);
        }
        else{
            int sum=0;
            for(int x:list){
                sum+=x;
            }
            System.out.println(sum);
        }
    }
}
