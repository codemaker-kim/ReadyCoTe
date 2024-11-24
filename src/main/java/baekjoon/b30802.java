package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class b30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> S = Arrays.stream(br.readLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> list = Arrays.stream(br.readLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toCollection(ArrayList::new));

        int T = list.get(0); // 티셔츠 묶음 수
        int P = list.get(1); // 펜 묶음 수

        int TshirtCnt = 0;

        // 티셔츠 묶음 출력하기
        for(int i=0; i<6; i++) {
            if(S.get(i)%T==0)
                TshirtCnt+=(S.get(i) / T);
            else
                TshirtCnt+=((S.get(i) / T)+1);
        }

        System.out.println(TshirtCnt);

        // 펜 묶음 출력하기
        System.out.println((N / P) + " " + (N % P));
    }
}