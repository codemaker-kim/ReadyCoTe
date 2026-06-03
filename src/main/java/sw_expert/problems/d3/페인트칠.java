package sw_expert.problems.d3;

import java.util.Scanner;

public class 페인트칠 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine(); // 정수 입력 후 버퍼에 남은 개행 문자(\n) 제거

            char[][] grid = new char[H][W];
            boolean hasWhite = false;

            // 격자판 초기화 및 흰색 존재 여부 체크
            for (int i = 0; i < H; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = line.charAt(j);
                    if (grid[i][j] == '.') {
                        hasWhite = true;
                    }
                }
            }

            // [예외 처리] 격자판에 흰색이 단 하나도 없는 경우
            if (!hasWhite) {
                System.out.println(Math.min(H, W));
                continue;
            }

            // 1. 모든 칸이 '#'인 행(가로줄)의 개수 카운트
            int allBlackRows = 0;
            for (int i = 0; i < H; i++) {
                boolean isAllBlack = true;
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == '.') {
                        isAllBlack = false;
                        break;
                    }
                }
                if (isAllBlack) {
                    allBlackRows++;
                }
            }

            // 2. 모든 칸이 '#'인 열(세로줄)의 개수 카운트
            int allBlackCols = 0;
            for (int j = 0; j < W; j++) {
                boolean isAllBlack = true;
                for (int i = 0; i < H; i++) {
                    if (grid[i][j] == '.') {
                        isAllBlack = false;
                        break;
                    }
                }
                if (isAllBlack) {
                    allBlackCols++;
                }
            }

            // 최소 연산 횟수 출력
            System.out.println(allBlackRows + allBlackCols);
        }

        sc.close();
    }
}
