package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class b10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> toFind = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        // 카드의 개수를 저장할 HashMap 생성
        Map<Integer, Integer> cardCount = new HashMap<>();

        // cards 배열의 각 숫자 개수 세기
        for (int card : cards) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // toFind의 숫자에 대해 개수 조회
        for (int num : toFind) {
            sb.append(cardCount.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
