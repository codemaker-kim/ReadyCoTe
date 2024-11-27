package baekjoon;

import java.util.Scanner;

public class b2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int tmpX = x;
        int tmpY = y;

        // 사실 마구잡이로 풀라다가 아무래도 뭔가 아닌거 같아서 찾아봄
        // 유클리드 호제법이라는 방법으로 풀기 가능

        // 최대공약수:  x를 y로 나눈 나머지가 r일 때, x와 y의 최대공약수는 y와 r의 최대공약수와 같다.
        while(tmpY!=0){
            int tmp = tmpY;
            tmpY = tmpX % tmpY;
            tmpX = tmp;
        }

        System.out.println(tmpX);

        //최소공배수: 두 수 x, y를 곱한 뒤 최대공약수로 나누면 최소공배수임.

        System.out.println(x*y / tmpX);

    }
}
