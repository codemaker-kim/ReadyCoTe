package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1003 {
    private static final String[] memo = new String[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 주어진 케이스를 메모 배열에 저장
        memo[0] = "1 0";
        memo[1] = "0 1";
        memo[2] = "1 1";
        memo[3] = "1 2";

        for (int i = 0; i < T; i++) {
            // N: 0보다 크거나 같고 40보다 작은 수
            int N = Integer.parseInt(br.readLine());

            // 메모에 값이 존재한다면 출력.
            if (memo[N] != null) {
                System.out.println(memo[N]);
                continue;
            }

            getFiboResult(N);
        }
    }

    // 피보나치 함수의 결과를 출력하는 함수
    private static void getFiboResult(int N) {
        for (int i = 4; i <= N; i++) {
            memo[i] = memoResult(memo[i-1], memo[i-2]);
        }

        System.out.println(memo[N]);
    }

    // N의 피보나치 함수 결과를 만드는 함수
    private static String memoResult(String N1, String N2) {
        int[] N1Arr = Arrays.stream(N1.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] N2Arr = Arrays.stream(N2.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int zeroCount = N1Arr[0] + N2Arr[0];
        int oneCount = N1Arr[1] + N2Arr[1];

        return zeroCount + " " + oneCount;
    }
}
