package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {

    private static final int EMPTY = -1;
    private static final int RIPEN_TOMATO = 1;
    private static final int UNRIPEN_TOMATO = 0;

    private static int M,N;

    private static int[][] tomatoBox;

    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    private static final Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        tomatoBox = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st1.nextToken());
                if (tomatoBox[i][j] == RIPEN_TOMATO) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        printResult();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {

            Point cur = queue.poll();

            int r = cur.r;
            int c = cur.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (tomatoBox[nr][nc] == 0) {
                    // 이전 토마토 값 + 1 을 저장 (날짜 계산 효과)
                    tomatoBox[nr][nc] = tomatoBox[r][c] + 1;

                    queue.offer(new Point(nr, nc));
                }
            }
        }
    }

    private static void printResult() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == UNRIPEN_TOMATO) {
                    System.out.println(EMPTY);
                    return;
                }

                max = Math.max(max, tomatoBox[i][j]);
            }
        }

        if (max == EMPTY) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }

    static class Point {
        int r; // 가로
        int c; // 세로

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
