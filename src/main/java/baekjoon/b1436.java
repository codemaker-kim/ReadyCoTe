package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int endNum = 666;

        while(N!=0){
            if((endNum+" ").contains("666")){
                N-=1;
                if(N==0){
                    break;
                }
                endNum+=1;
            } else
                endNum+=1;
        }

        System.out.println(endNum);
    }
}
