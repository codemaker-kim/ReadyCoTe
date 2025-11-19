package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14500 {

    // 사각형 -> 1개
    // 일자 -> 2개
    // L자 -> 8개
    // Z자 -> 4개
    // T자 -> 4개

    // -> 총 19개
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            paper[i] = row;
        }

        int squareMax = calculateSquareBlock(paper);
        int SMax = calculateSBlock(paper);
        int IMax = calculateIBlock(paper);
        int LMax = calculateLBlock(paper);
        int TMax = calculateTBlock(paper);

        int result = Math.max(squareMax, Math.max(SMax, Math.max(IMax, Math.max(LMax, TMax))));

        System.out.println(result);
    } // main

    private static int calculateSquareBlock(int[][] paper) {
        int maxValue = 0;

        // 사각형 연산 로직
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        return maxValue;
    }

    private static int calculateTBlock(int[][] paper) {
        int maxValue = 0;

        // T자
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㅗ 자
        for (int i = 1; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i - 1][j + 1] + paper[i][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㅏ 자
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㅓ 자
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 1; j < paper[i].length; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j - 1] + paper[i + 2][j];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        return maxValue;
    }

    // ㄴ자
    private static int calculateLBlock(int[][] paper) {
        int maxValue = 0;

        // ㄴ 자 블럭
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㄴ 자 반전
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 2; j < paper[i].length; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j - 1] + paper[i + 1][j - 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㄱ자 블럭
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // ㄱ자 반전
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // L자
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // L자 반전
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 1; j < paper[i].length; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j - 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // 큰 ㄱ자
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // 큰 ㄱ자 반전
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        return maxValue;
    }

    private static int calculateIBlock(int[][] paper) {
        int maxValue = 0;

        // 가로 I 블럭
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length - 3; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // 세로 I 블럭
        for (int i = 0; i < paper.length - 3; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        return maxValue;
    }

    private static int calculateSBlock(int[][] paper) {
        int maxValue = 0;

        // S자
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 0; j < paper[i].length - 1; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // s자 반전
        for (int i = 0; i < paper.length - 2; i++) {
            for (int j = 1; j < paper[i].length; j++) {
                int tetrominoValue = paper[i][j] + paper[i + 1][j] + paper[i + 1][j - 1] + paper[i + 2][j - 1];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // z자
        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        // z자 반전
        for (int i = 1; i < paper.length; i++) {
            for (int j = 0; j < paper[i].length - 2; j++) {
                int tetrominoValue = paper[i][j] + paper[i][j + 1] + paper[i - 1][j + 1] + paper[i - 1][j + 2];
                if (tetrominoValue > maxValue) {
                    maxValue = tetrominoValue;
                }
            }
        }

        return maxValue;
    }
}

