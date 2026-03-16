package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14940 {

    private static int[][] matrix;
    private static Queue<int[]> queue;
    private static boolean[][] visited;
    // 방향 벡터
    private static final int[][] vectors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        matrix = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                // 만약 값이 2라면 시작 지점이므로 인덱스를 저장하고, 값을 0으로 초기화 (핵심 수정 사항)
                if (matrix[i][j] == 2) {
                    startX = i;
                    startY = j;
                    matrix[i][j] = 0;
                }
            }
        }

        queue = new LinkedList<>();
        // 큐에는 x, y 좌표 정보만 저장 (크기 2)
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        // bfs 실행 (불필요한 매개변수 제거)
        bfs();

        // 탐색 완료 후 한 번에 출력 (성능 최적화)
        printResult();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] vector : vectors) {
                int nextX = curr[0] + vector[0];
                int nextY = curr[1] + vector[1];

                // 범위를 벗어나지 않고, 방문하지 않았으며, 원래 갈 수 있는 땅(1)인 경우
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                        && !visited[nextX][nextY] && matrix[nextX][nextY] == 1) {

                    visited[nextX][nextY] = true;
                    // 이전 좌표의 거리 + 1
                    matrix[nextX][nextY] = matrix[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 도달할 수 없는 위치(1인데 방문 못한 곳)는 -1 출력
                if (!visited[i][j] && matrix[i][j] == 1) {
                    sb.append("-1 ").append("");
                } else {
                    sb.append(matrix[i][j]).append(" ");
                }
            }
            sb.append("\n"); // 줄바꿈
        }
        // 최종적으로 한 번만 출력
        System.out.print(sb.toString());
    }
}