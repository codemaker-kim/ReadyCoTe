package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class b11286 {

    private static final int ZERO = 0;
    private static Queue<Integer> heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 연산의 개수
        int N = sc.nextInt();
        heap = new PriorityQueue<>(comparator());

        // x가 0이 아니라면 배열에 x라는 값 추가
        // x가 0이라면 배열에서 절댓값이 가장 작은 값 출력하고 제거
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x == ZERO) {
                pop();
            } else {
                insert(x);
            }
        }
    }

    // 1순위: 절댓값이 가장 작은 수
    // 2순위: 실질적으로 값이 작은 수
    private static Comparator<Integer> comparator() {
        return (x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if (absX == absY) {
                return Integer.compare(x, y);
            }

            return Integer.compare(absX, absY);
        };
    }

    private static void pop() {
        if (heap.isEmpty()) {
            System.out.println(ZERO);
        } else {
            System.out.println(heap.poll());
        }
    }

    private static void insert(int x) {
        heap.offer(x);
    }
}
