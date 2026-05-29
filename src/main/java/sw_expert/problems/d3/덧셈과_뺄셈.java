package sw_expert.problems.d3;

import java.util.Scanner;

public class 덧셈과_뺄셈 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int plus = sc.nextInt();
            int minus = sc.nextInt();

            int a = (plus + minus) / 2;
            int b = plus - a;

            System.out.println(a + " " + b);
        }

        sc.close();
    }
}
