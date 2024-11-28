package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);


        binomial(N, K);
    }

    static void binomial(int N, int K) {
        int tmp = 1;
        int tmp2 = 1;

        for(int i=K; i>=1; i--) {
            tmp*=N;
            N--;
            tmp2*=K;
            K--;
        }

        System.out.println(tmp / tmp2);
    }
}
