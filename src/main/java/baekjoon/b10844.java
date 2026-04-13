package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10844 {
    private static final int MOD = 1_000_000_000;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 행: 길이
        // 열: 마지막번호
        // [i][j] = 길이가 i이고, j로 끝나는 계단 수의 개수.
        dp = new int[N + 1][10];
        dp[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 모듈러 연산 (오버플로우 방지)
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][j + 1]) % MOD;
                } else if (j == 9) {
                    dp[i][j] = (dp[i - 1][j - 1]) % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        // 2. 최종 합계를 구할 때 오버플로우를 막기 위해 long 사용 및 모듈러 적용
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % MOD;
        }

        System.out.println(ans);
    }
}
