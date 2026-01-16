package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건의 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게

        // 물건의 정보를 담을 배열
        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 정의
        // 행(i): i번째 물건까지 살펴봤을 때
        // 열(j): 배낭 용량이 j일 때
        // 값: 그때의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 1번 물건부터 N번 물건까지 차례대로 검사
        for (int i = 1; i <= N; i++) {
            // 배낭 용량을 1부터 K까지 늘려가며 확인
            for (int j = 1; j <= K; j++) {

                // 1. 현재 물건(i)의 무게가 배낭 용량(j)보다 커서 아예 못 넣는 경우
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 위쪽 값(이전 물건까지의 최댓값)을 그대로 가져옴
                }

                // 2. 넣을 수 있는 경우 (넣는 게 이득인지, 안 넣는 게 이득인지 비교)
                else {
                    // 안 넣는 경우: dp[i-1][j] (이전 상태 그대로)
                    // 넣는 경우: 내 가치 V[i] + 남은 무게(j - W[i])를 채울 수 있는 최댓값 dp[i-1][j - W[i]]
                    dp[i][j] = Math.max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}