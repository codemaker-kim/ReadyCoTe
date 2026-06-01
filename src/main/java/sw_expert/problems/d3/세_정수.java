package sw_expert.problems.d3;

import java.util.Scanner;

public class 세_정수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // x = max(a,b)
            // y = max(b,c)
            // z = max(c,a)

            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // 정답을 담을 변수
            int a = -1;
            int b = -1;
            int c = -1;

            // 최댓값
            int max = Math.max(x, Math.max(y, z));

            boolean maxIsX = max == x;
            boolean maxIsY = max == y;
            boolean maxIsZ = max == z;

            if (maxIsX) {
                if (maxIsY && maxIsZ) { // 모두가 최대의 경우
                    a = max;
                    b = max;
                    c = max;
                } else if (maxIsY) { // x와 y가 최대일 경우, a가 최대일 경우, z도 같이 최대여야 함. 따라서 b가 최대
                    b = max;
                    a = z;
                    c = z;
                } else if (maxIsZ) { // x와 z가 최대일 경우, c가 최대일 경우, y도 같이 최대여야 함. 따라서 a가 최대.
                    a = max;
                    b = y;
                    c = y;
                }
            } else if (maxIsY) { // x는 이미 최대가 아니고, y가 최대라면 b,c가 남는데 이러면 당연히 c가 최대가 된다.
                if (maxIsZ) {
                    c = max;
                    a = x;
                    b = x;
                }
            }

            // x가 최대일 때, a 혹은 b가 최댓값을 가짐.
            System.out.println(
                    a + " " + b + " " + c
            );
        }
    }
}

