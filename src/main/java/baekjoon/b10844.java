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
        // [i][j] = 길이가 i이고, j로 끝나는 수의 개수.
        dp = new int[N + 1][10];
        dp[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }


    }
}
