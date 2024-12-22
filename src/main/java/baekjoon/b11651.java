package baekjoon;

import java.util.*;

public class b11651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] points = new int[n][2];

        for (int i=0; i<n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[0], p2[0]);
            }
            return Integer.compare(p1[1], p2[1]);
        });

        for (int[] point : points) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}

