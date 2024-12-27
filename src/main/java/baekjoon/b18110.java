package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class b18110 {
    public static void main(String[] args) {
        // 의견 없으면 -> 난이도 0
        // 의견이 하나 이상 있다면, 30% 절사평균으로 결정
        // 35퍼센트 시간초과

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n==0){
            System.out.println(0);
            System.exit(0);
        }

        int[] opinions = new int[n];

        for(int i=0; i<n; i++) {
            opinions[i] = sc.nextInt();
        }

        Arrays.sort(opinions);

        int size = opinions.length;

        double tmp = size * 0.15;

        int unnecessary = (int) Math.round(tmp);

        double aver = 0;

        for(int i=unnecessary; i<=size-(unnecessary+1); i++) {
            aver+=opinions[i];
        }

        aver /= (size-unnecessary*2);
        System.out.println(Math.round(aver));
    }
}
