package baekjoon;

import java.util.Scanner;

public class b2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int moves = A - B;

        int days = (V - B) / moves;

        if ((V - B) % moves!=0) {
            days++;
        }
        System.out.println(days);
    }
}
