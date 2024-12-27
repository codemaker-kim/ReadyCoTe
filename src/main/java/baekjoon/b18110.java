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
            return;
        }

        int[] opinions = new int[n];

        for(int i=0; i<n; i++) {
            opinions[i] = sc.nextInt();
        }

        Arrays.parallelSort(opinions);

        int unnecessary = (int) Math.round(n*0.15);

        int sum = 0;

        for(int i=unnecessary; i<=n-(unnecessary+1); i++) {
            sum+=opinions[i];
        }

        int res = (int) Math.round((double)sum / (n-unnecessary*2));
        System.out.println(res);
    }
}
