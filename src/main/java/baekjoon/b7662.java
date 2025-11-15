package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class b7662 {

    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final String EMPTY = "EMPTY";
    private static final int MIN_DEL = -1;
    private static final int MAX_DEL = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // k만큼 반복해서 입력받는다.
        // 입력은 I, 삭제는 D로 입력받는다. D 1은 최댓값 D -1는 최솟값 삭제
        // 중복 삽입 가능
        // Q가 비어있을 때 D는 무시한다.
        // 최종 연산 시 Q가 비어있을 경우 EMPTY를 출력한다.

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min_pq = new PriorityQueue<>();
            Map<Integer, Integer> checker = new HashMap<>();

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");

                String operation = input[0];
                int value = Integer.parseInt(input[1]);

                switch (operation) {
                    case INSERT:
                        max_pq.offer(value);
                        min_pq.offer(value);
                        checker.put(value, checker.getOrDefault(value, 0) + 1);
                        break;
                    case DELETE:
                        Integer deletedValue = deleteValue(max_pq, min_pq, value);
                        Integer put = checker.put(deletedValue, checker.getOrDefault(deletedValue, 1) - 1);

                        if (put.equals(0)) {
                            checker.remove(deletedValue);
                        }

                        break;
                }
            }

            List<Integer> result = new ArrayList<>();

            while (!max_pq.isEmpty() && !min_pq.isEmpty()) {
                Integer maxValue = max_pq.peek();
                Integer minValue = min_pq.peek();

                if (checker.containsKey(maxValue) && checker.get(maxValue) > 0) {
                    result.add(maxValue);
                    max_pq.poll();
                } else {
                    max_pq.poll();
                }

                if (checker.containsKey(minValue) && checker.get(minValue) > 0) {
                    if (!result.contains(minValue)) {
                        result.add(minValue);
                    }
                    min_pq.poll();
                } else {
                    min_pq.poll();
                }
            }
            if (result.isEmpty()) {
                System.out.println(EMPTY);
            } else {
                System.out.println(result.stream().max(Integer::compareTo).get() + " " + result.stream().min(Integer::compareTo).get());
            }
        }
    }


    // TODO: 여기서, 2개의 우선순위 큐의 데이터 정합성이 안맞는 문제가 있음. 이걸 해결해야 할 듯.
    private static Integer deleteValue(PriorityQueue<Integer> max_pq,
                                       PriorityQueue<Integer> min_pq,
                                       int flag) {

        if (flag == MAX_DEL) {
            return max_pq.poll();
        } else {
            return min_pq.poll();
        }
    }
}
