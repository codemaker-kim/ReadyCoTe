package baekjoon;

import java.util.Scanner;

public class b10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor = (N % H == 0) ? H : (N % H);
            int room = (N + H - 1) / H;

            System.out.printf("%d%02d\n", floor, room);
        }
        sc.close();
    }
}
