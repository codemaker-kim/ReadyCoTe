package baekjoon;

import java.util.Scanner;

public class b10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            sb.append(N%H == 0 ? H : N%H).append(N/H > 9 ? (N/H)+1 : "0" + ((N/H)+1));

            System.out.println(sb);
        }
    }
}
