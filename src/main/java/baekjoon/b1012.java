package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1012 {

    private static int[][] matrix;
    private static boolean[][] visited;

    // 상하 좌우 이동을 위한 배열
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 배추 밭 가로
            int M = Integer.parseInt(st.nextToken());

            // 배추 밭 새로
            int N = Integer.parseInt(st.nextToken());

            // 배추의 개수
            int K = Integer.parseInt(st.nextToken());

            matrix = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                matrix[x][y] = 1;
            }

            System.out.println(calculateWormNeed());
        }
    }

    private static int calculateWormNeed() {
        int count = 0;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 1 && !visited[x][y]) {
                    bfs(x, y);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length) {
                    if (matrix[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Integer[]{nx, ny});
                    }
                }
            }
        }
    }
}
