package baekjoon;

import java.util.Scanner;

public class b1929 {
    public static void main(String[] args) {
        //에라토스테네스의 체 알고리즘 활용
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];

        for(int i=2; i<=N; i++) {
            isPrime[i] = true;
        }

        for(int i=2; i*i<=N; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i=M; i<=N; i++) {
            if(isPrime[i])
                System.out.println(i);
        }
    }
}
