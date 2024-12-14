package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in ));
        int N = Integer.parseInt(br.readLine());

        // 그냥 층구조라고 생각하면 편하다고 한다.
        // 1층은 방이 1개, 2층은 1+6개 = 7개, 3층은 1+6+12 = 19개... 4층은 37개

        int i=1;
        int count = 1;
        while(i<N){
            i+=(6*count);
            count+=1;
        }

        System.out.println(count);
    }
}
