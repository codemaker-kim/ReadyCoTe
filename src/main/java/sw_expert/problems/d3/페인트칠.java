package sw_expert.problems.d3;

import java.util.Arrays;
import java.util.Scanner;

public class 페인트칠 {

    private static final String BLACK = "#";
    private static final String WHITE = ".";

    private static String[][] matrix;
    private static boolean[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();

            matrix = new String[H][W];
            checked = new boolean[W];
            int answer = 0;

            // 매트릭스 초기화
            for (int i = 0; i < H; i++) {
                char[] c = sc.nextLine().toCharArray();

                for (int j = 0; j < W; j++) {
                    matrix[i][j] = Character.toString(c[j]);
                }
            }

            // 격자 행, 혹은 열을 골라서 모두 검은색으로 칠하면,
            // 여전히 검은색.
            // 특정한 행에, 흰 색이 존재한다면, 그 행은 행 색칠을 하지 않았음.
            // 1. 행에 검은 색이 보이는 순간, flag를 true로 돌린다.
            // 2. flag가 true 라면 행에 있는 검은 색의 수를 센다.
            // 3. 그렇지 않다면, 넘어간다.

            for (int y = 0; y < matrix.length; y++) {
                // 흰 색을 포함하지 않는다면, 행 색칠 연산을 수행했다.
                if (!containsWhite(matrix[y]) && W >= H) {
                    answer++;
                    continue;
                }

                for (int x = 0; x < matrix[y].length; x++) {
                    if (matrix[y][x].equals(BLACK) && !checked[x]) {
                        answer++;
                        checked[x] = true;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static boolean containsWhite(String[] row) {
        return Arrays.asList(row).contains(WHITE);
    }
}
