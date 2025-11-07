package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1654 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> cables = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int cableLength = Integer.parseInt(br.readLine());
            cables.add(cableLength);
        }

        long min = 1;
        long max = cables.stream()
                .max(Integer::compareTo)
                .get();

        System.out.println(getMid(cables, min, max, N));
    }

    private static long getMid(List<Integer> cables, long min, long max, int N) {
        long result = 0;

        while (min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            for (int cable : cables) {
                sum += (cable / mid);
            }

            if (sum >= N) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }
}
