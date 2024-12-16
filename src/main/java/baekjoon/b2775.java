package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2775 {
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 문제를 점화식으로 만들어보자! DP임
        // dp[i][j] = dp[i-1][1]+...+dp[i-1][j]
        // dp[0][j] = j
        for(int i=1; i<dp[0].length; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                for(int k=1; k<=j; k++) {
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }


        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[k][n]);
        }
    }
}

