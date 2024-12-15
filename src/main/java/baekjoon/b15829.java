package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] L = br.readLine().split("");

        long ans = 0;
        long M = 1234567891;
        long pow = 1;

        for(int i=0; i<N; i++) {
            int tmp = L[i].charAt(0)-96;
            ans = (ans + tmp * pow) % M;
            pow = (pow * 31) % M;
        }

        System.out.println(ans);
    }
}
