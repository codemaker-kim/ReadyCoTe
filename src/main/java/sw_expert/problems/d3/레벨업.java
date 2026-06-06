package sw_expert.problems.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 레벨업 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            List<Integer> checkpoints = new ArrayList<>();
            int minimum = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                checkpoints.add(sc.nextInt());
            }

            for (int i = 1; i < N - 1; i++) {
                int result = 0;
                int beforeCheckPoint = checkpoints.get(0);
                for (int j = 1;  j < N; j++) {
                    if (i == j)
                        continue;

                    if (beforeCheckPoint != Integer.MIN_VALUE) {
                        result += Math.abs(beforeCheckPoint - checkpoints.get(j));
                    }

                    beforeCheckPoint = checkpoints.get(j);
                }

                if (result < minimum)
                    minimum = result;
            }

            System.out.println(minimum);
        }
    }
}
