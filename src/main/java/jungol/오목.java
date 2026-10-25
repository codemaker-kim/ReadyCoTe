package jungol;

import java.util.Scanner;


public class 오목 {
    static final int SIZE = 19;
    static int[][] board = new int[SIZE][SIZE];

    // 오른쪽, 아래, 오른쪽 아래, 오른쪽 위
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    continue;
                }

                for (int direction = 0; direction < 4; direction++) {
                    if (countLine(row, col, direction) == 5) {
                        System.out.println(board[row][col]);
                        System.out.println((row + 1) + " " + (col + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static int countLine(int row, int col, int direction) {
        int color = board[row][col];

        // 반대 방향에 같은 돌이 있다면 줄의 시작점이 아님
        int prevRow = row - dr[direction];
        int prevCol = col - dc[direction];

        if (inRange(prevRow, prevCol)
                && board[prevRow][prevCol] == color) {
            return 0;
        }

        int length = 0;

        // 방향을 유지하며 같은 색 돌이 끝날 때까지 확인
        while (inRange(row, col) && board[row][col] == color) {
            length++;
            row += dr[direction];
            col += dc[direction];
        }

        return length;
    }

    static boolean inRange(int row, int col) {
        return row >= 0 && row < SIZE
                && col >= 0 && col < SIZE;
    }
}
