package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1654 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i])
                max = arr[i];
        }

        // UpperBound
        max += 1;

        int mid = 0;
        int min = 0;

        // 경계 조건 - 최댓값과 최솟값이 엇갈리는 시점에 종료
        while (min < max) {

            mid = (max + min) / 2;

            // 자른 랜선의 갯수
            int cutWire = 0;

            for (int i = 0; i < arr.length; i++) {
                cutWire += (arr[i] / mid);
            }

            if (cutWire < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
