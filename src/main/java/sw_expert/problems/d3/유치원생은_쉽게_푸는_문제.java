package sw_expert.problems.d3;

import java.util.Scanner;

public class 유치원생은_쉽게_푸는_문제 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int X = sc.nextInt();
            // 닫힌 공간의 개수가 X인
            // 가장 작은 음이 아닌 정수 N를 구하는 프로그램을 작성하라.
            // x는 1~2500까지

            // 0 = 1
            // 4 = 1
            // 6 = 1
            // 8 = 2
            // 9 = 1
            StringBuilder sb = new StringBuilder();


            if (X == 1) {
                sb.append(0);
                System.out.println(sb.toString());
            } else if (X == 2) {
                sb.append(8);
                System.out.println(sb.toString());
            } else {
                for (int i = 0; i < X; i++) {
                    if (i == 0 && (X % 2) != 0) {
                        sb.append(4);
                    } else {
                        sb.append(8);
                        i++;
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
