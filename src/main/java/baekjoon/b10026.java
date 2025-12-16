package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b10026 {

    private static final String RED = "R";
    private static final String GREEN = "G";
    private static final String BLUE = "B";

    private static String[][] picture;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        picture = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                picture[i][j] = input[j];
            }
        }

        int normalCount = bfsModule();

        visited = new boolean[N][N];

        // 초록색인 부분을 빨간색으로 변경
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j].equals(GREEN)) {
                    picture[i][j] = RED;
                }
            }
        }

        int redGreenBlindCount = bfsModule();

        System.out.println(normalCount+ " " + redGreenBlindCount);
    }

    private static int bfsModule() {
        int result = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        String targetColor = picture[x][y];

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];

            // 상하 좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (picture[nx][ny].equals(targetColor)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
