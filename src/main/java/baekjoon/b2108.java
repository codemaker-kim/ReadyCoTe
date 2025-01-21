package baekjoon;

import java.io.*;
import java.util.*;

public class b2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] frequency = new int[8001]; // -4000 ~ 4000 범위

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mode = 0;
        int maxFreq = 0;
        boolean secondMode = false; // 두 번째 최빈값 체크

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            frequency[numbers[i] + 4000]++; // -4000 -> 0 인덱스에 대응

            // 최대, 최소 갱신
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        Arrays.sort(numbers); // 중앙값을 구하기 위해 정렬

        // 최빈값 찾기
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                mode = i - 4000;
                secondMode = false; // 새로운 최빈값 발견
            } else if (frequency[i] == maxFreq && !secondMode) {
                mode = i - 4000;
                secondMode = true; // 두 번째 최빈값 설정
            }
        }

        // 출력
        System.out.println((int) Math.round((double) sum / N)); // 평균 (반올림)
        System.out.println(numbers[N / 2]); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(max - min); // 범위
    }
}