package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1074 {

    private static final int[][] N1_MAP = {
            {0, 1},
            {2, 3}
    };

    private static final String BLANK = " ";
    private static final int BASE_SIZE = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(BLANK);

        // 격자의 지수
        int N = Integer.parseInt(input[0]);

        // 목표 행
        int r = Integer.parseInt(input[1]);

        // 목표 열
        int c = Integer.parseInt(input[2]);

        findLevel(N, r, c);
    }

    private static void findLevel(int N, int r, int c) {
        int result = 0;

        for (int i = N; i >= 1; i--) {
            int area = getArea(i);
            int half = (int) (Math.pow(2, i) / 2);

            int row = r < half ? 0 : 1;
            int col = c < half ? 0 : 1;

            result += area * N1_MAP[row][col];

            // 상대 좌표 이동 - 만약, r 혹은 c가 절반을 넘어갔다면,
            // 4 사분면 선택 후 그 안에서 로직을 진행.
            // 이후 1/4로 작아진 넓이에서 계산을 진행할 때, 기존값이 그대로 남아있으면,
            // row와 col을 구하는 연산에서 문제가 생기게 됨.

            if (row == 1)
                r -= half;
            if (col == 1)
                c -= half;
        }

        System.out.println(result);
    }

    private static int getArea(int n) {
        int length = (int) Math.pow(2, n);
        int width = (int) Math.pow(2, n);

        return (length * width) / BASE_SIZE;
    }
}

