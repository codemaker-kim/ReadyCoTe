package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class b2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> deck = new LinkedList<>();

        // 람다식
        IntStream.rangeClosed(1, N).forEach(deck::add);

        // 카드가 1장 남을 때까지 반복
        for(int i=1; deck.size()!=1; i++) {

            // 홀수번 반복일 때는 위에서 버림
            if(i%2!=0){
                deck.remove();
            }
            // 짝수번 반복일 때는 위에 있는 카드를 아래로
            else if(i%2==0){
                int tmp = deck.poll();
                deck.add(tmp);
            }

        }

        System.out.println(deck.poll());
    }
}
