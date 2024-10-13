package study_10_08;
import java.util.*;
import java.io.*;
public class bj_1213 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];//알파벳별 갯수 카운팅
        int oddCount=0;
        for(int i=0;i<str.length();i++){
            alpha[str.charAt(i)-'A']++;
        }
        for(int i=0;i<26;i++){
            if(alpha[i]%2!=0){
                oddCount++;//홀수개가 2개이상나오면 불가능
            }
        }
        if(oddCount>1){
            System.out.println("I'm Sorry Hansoo");
            return ;
        }
        char center = '0';//기본세팅 의미없는값
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<26;i++){
            if(alpha[i]==0){//나온적없으면 패스
                continue;
            }
            if(alpha[i]%2==1){
                center = (char)('A'+i);//홀수개는 가운데에 하나있어야함
            }
            for(int j=0;j<alpha[i]/2;j++){//앞부분
                sb.append((char)('A'+i));
            }
        }
        int halfLength = sb.length();

        if(center!='0') {//가운데 부분 추가
            sb.append(center);
        }
        for(int i=halfLength-1;i>=0;i--){//뒷부분완성
            sb.append(sb.charAt(i));
        }
        System.out.println(sb);
    }
}
