package sw_expert.problems.d3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 여행 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            // N - S
            // W - E
            String A = sc.nextLine();
            Set<Character> set = new HashSet<>();

            for (char c : A.toCharArray()) {
                set.add(c);
            }

            boolean result = true;

            for (char c : set) {
                if (set.contains(counter(c)))
                    continue;

                result = false;
            }

            System.out.println(result ? "Yes" : "No");
        }
    }

    private static char counter(char target) {
        switch (target) {
            case 'N':
                return 'S';
            case 'S':
                return 'N';
            case 'W':
                return 'E';
            case 'E':
                return 'W';
            default:
                throw new IllegalArgumentException();
        }
    }
}
