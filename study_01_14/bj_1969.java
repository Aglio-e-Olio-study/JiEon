package study_01_14;
import java.util.*;
import java.io.*;
public class bj_1969 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] str = new String[N];
        int[][] count = new int[M][4];//ACGT순서의 인덱스
        int[] index = new int[M];
        for(int i=0;i<N;i++){
            str[i] = br.readLine();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(str[i].charAt(j)=='A'){
                    count[j][0]++;
                } else if(str[i].charAt(j)=='C'){
                    count[j][1]++;
                } else if(str[i].charAt(j)=='G'){
                    count[j][2]++;
                } else if(str[i].charAt(j)=='T'){
                    count[j][3]++;
                }
            }
        }
        for(int i=0;i<M;i++){
            int max = 0;
            for(int j=0;j<4;j++){
                if(count[i][j]>max){
                    max=count[i][j];
                    index[i]=j;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            if(index[i]==0){
                sb.append("A");
            }else if(index[i]==1){
                sb.append("C");
            }else if(index[i]==2){
                sb.append("G");
            }else if(index[i]==3){
                sb.append("T");
            }
        }
        String answer = sb.toString();
        System.out.println(answer);
        int min=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(answer.charAt(j)!=str[i].charAt(j)){
                    min++;
                }
            }
        }
        System.out.println(min);


    }
}
