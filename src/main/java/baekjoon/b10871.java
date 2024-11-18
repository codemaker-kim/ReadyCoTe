package baekjoon;

import java.util.Scanner;

public class b10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            int tmp = sc.nextInt();
            if(tmp < X && i==N-1)
                sb.append(tmp);
            else if(tmp < X)
                sb.append(tmp).append(" ");
        }

        System.out.println(sb);
    }
}
