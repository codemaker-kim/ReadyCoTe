package sw_expert;

import java.util.concurrent.ThreadLocalRandom;

class 절대값의_합 {

    // 상하좌우
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static int[][] matrix = new int[5][5];

    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(0, 25);
            }
        }

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + dx[dir];
                    int newY = y + dy[dir];

                    if(!isWall(newX, newY))
                        sum+=calAbs(matrix[y][x], matrix[newY][newX]);
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isWall(int x, int y) {
        return x < 0 || x >= matrix[0].length || y < 0 || y >= matrix.length;
    }

    private static int calAbs(int i1, int i2) {
        return Math.abs(i1 - i2);
    }
}
