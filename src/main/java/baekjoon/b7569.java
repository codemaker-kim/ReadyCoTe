package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7569 {
    private static final int EMPTY = -1;
    private static final int RIPEN_TOMATO = 1;
    private static final int UNRIPEN_TOMATO = 0;

    static int M, N, H;
    static int[][][] tomatoBox; // 3차원 토마토 상자

    private static int[] dh = {1, -1, 0, 0, 0, 0};
    private static int[] dr = {0, 0, 1, -1, 0, 0};
    private static int[] dc = {0, 0, 0, 0, 1, -1};

    private static final Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        tomatoBox = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                int[] boxRow = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int k = 0; k < M; k++) {
                    tomatoBox[i][j][k] = boxRow[k];
                    if (tomatoBox[i][j][k] == RIPEN_TOMATO) {
                        queue.offer(new Point(i, j, k));
                    }
                }
            }
        }

        bfs();

        printResult();
    }

    static class Point {
        int h; // 높이
        int r; // 가로
        int c; // 세로

        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {

            Point cur = queue.poll();

            int h = cur.h;
            int r = cur.r;
            int c = cur.c;

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (tomatoBox[nh][nr][nc] == 0) {
                    // 이전 토마토 값 + 1 을 저장 (날짜 계산 효과)
                    tomatoBox[nh][nr][nc] = tomatoBox[h][r][c] + 1;

                    queue.add(new Point(nh, nr, nc));
                }
            }
        }
    }

    static void printResult() {
        int max = Integer.MIN_VALUE;


        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (tomatoBox[h][r][c] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    max = Math.max(max, tomatoBox[h][r][c]);
                }
            }
        }

        // 시작값이 1이었으므로, 실제 걸린 일수는 (최대값 - 1)
        if (max == -1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }
}
