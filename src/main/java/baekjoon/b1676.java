package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 팩토리얼을 계산하는 것은 안 됨.
        // 너무 값이 커지고, 이 문제의 의도는 아닐것임.
        // 입력범위는 0부터 500까지.

        int ans = 0;

        int divisor = 5;

        // 보통 뒤가 0이면 10의 배수인데, 2와 5의 곱으로 이루어지는데,
        // 팩토리얼에서는 5의 개수가 2의 개수보다 적기에, N!의 뒤에 오는 0 개수는
        // 5의 개수에 의해 결정됨.

        // 1~N까지의 범위에서 5가 몇 번 곱해지는지 알려면 5의 배수의 개수를 세면 됨.
        while(N/divisor >= 1) {
            ans+=N/divisor;
            divisor*=5;
        }

        System.out.println(ans);
    }
}
