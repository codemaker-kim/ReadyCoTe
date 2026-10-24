package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 참외밭 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] lengths = new int[6];

        int maxWidth = 0;
        int maxHeight = 0;

        int maxWidthIndex = 0;
        int maxHeightIndex = 0;

        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().split(" ");

            int direction = Integer.parseInt(input[0]);
            int length = Integer.parseInt(input[1]);

            lengths[i] = length;

            if (direction <= 2 && length > maxWidth) {
                maxWidth = length;
                maxWidthIndex = i;
            }

            if (direction >= 3 && length > maxHeight) {
                maxHeight = length;
                maxHeightIndex = i;
            }
        }

        int totalArea = maxWidth * maxHeight;

        // 큰 세로 변에서 3칸 떨어진 변은 잘려 나간 직사각형의 가로
        // 큰 가로 변에서 3칸 떨어진 변은 잘려 나간 직사각형의 세로

        int smallWidth = lengths[(maxHeightIndex + 3) % 6];
        int smallHeight = lengths[(maxWidthIndex + 3) % 6];

        int smallArea = smallWidth * smallHeight;

        System.out.println((totalArea - smallArea) * k);
    }
}
