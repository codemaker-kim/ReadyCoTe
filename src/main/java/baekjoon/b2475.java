package baekjoon;

import java.util.Scanner;

public class b2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        for(int i=0; i<5; i++) {
            int n = sc.nextInt();
            ans+= (n*n);
        }

        System.out.println(ans%10);
    }
}
