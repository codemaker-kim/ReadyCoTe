package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairScores = new int[N + 1];
        int[] dp = new int[N + 1];

        // 계단 점수 입력
        for (int i = 1; i <= N; i++) {
            stairScores[i] = Integer.parseInt(br.readLine());
        }

        // 기저 사례 초기화 (N=1일 때의 예외 처리 완벽 방어)
        dp[1] = stairScores[1];
        if (N >= 2) {
            // 핵심: 1번 계단을 밟고 2번 계단을 밟는 것이 두 번째 계단까지의 최댓값
            dp[2] = stairScores[1] + stairScores[2];
        }

        // 점화식을 이용한 DP 테이블 채우기
        for (int i = 3; i <= N; i++) {
            int upOneStair = dp[i - 3] + stairScores[i - 1] + stairScores[i];
            int twoUpStair = dp[i - 2] + stairScores[i];

            dp[i] = Math.max(upOneStair, twoUpStair);
        }

        System.out.println(dp[N]);
    }
}