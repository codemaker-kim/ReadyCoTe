package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b7569 {
    private static final int EMPTY = -1;
    private static final int RIPEN_TOMATO = 1;
    private static final int UNRIPEN_TOMATO = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int boxRow = input[1];
        int boxCol = input[0];
        int boxCount = input[2];

        int[][] tomatoBox = new int[boxRow][boxCol];

        for (int boxRowIndex = 0; boxRowIndex < boxRow; boxRowIndex++) {
            int[] tomatoBoxRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.arraycopy(tomatoBoxRow, 0, tomatoBox[boxRowIndex], 0, boxCol);
        }
    }
}
