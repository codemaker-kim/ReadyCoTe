package sw_expert.problems.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 쉬운_삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int[] dot = new int[2];

                dot[0] = sc.nextInt();
                dot[1] = sc.nextInt();

                list.add(dot);
            }

            int maxArea = 0;

            for (int i = 0; i < list.size(); i++) {
                int width = 0;
                int height = 0;
                int[] current = list.get(i);

                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    int[] target = list.get(j);

                    if (current[0] == target[0]) {
                        height = Math.max(height, Math.abs(Math.max(current[1], target[1]) - Math.min(current[1], target[1])));
                    }

                    if (current[1] == target[1]) {
                        width = Math.max(width, Math.abs(Math.max(current[0], target[0]) - Math.min(current[0], target[0])));
                    }
                }

                maxArea = Math.max(maxArea, width * height);
            }

            System.out.println(maxArea);
        }

        sc.close();
    }
}
