package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class b1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 큰 수 입력받기
        BigInteger n = sc.nextBigInteger(); // 총 금액
        BigInteger m = sc.nextBigInteger(); // 사람 수

        // 몫 계산
        BigInteger quotient = n.divide(m);
        // 나머지 계산
        BigInteger remainder = n.remainder(m);

        // 결과 출력
        System.out.println(quotient);
        System.out.println(remainder);
    }
}
