package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b7662 {

    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final String EMPTY = "EMPTY";
    private static final int MIN_DEL = -1;
    private static final int MAX_DEL = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // k만큼 반복해서 입력받는다.
        // 입력은 I, 삭제는 D로 입력받는다. D 1은 최댓값 D 2는 최솟값 삭제
        // 중복 삽입 가능
        // Q가 비어있을 때 D는 무시한다.
        // 최종 연산 시 Q가 비어있을 경우 EMPTY를 출력한다.

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] pq = new int[k];

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");

                String operation = input[0];
                int value = Integer.parseInt(input[1]);

                
            }
        }
    }
}
