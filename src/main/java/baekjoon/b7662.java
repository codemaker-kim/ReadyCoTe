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
                        deleteLogic(max_pq, min_pq, value, checker);
                        break;
                }
            }

            List<Integer> validValues = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : checker.entrySet()) {
                if (entry.getValue() > 0) {
                    validValues.add(entry.getKey());
                }
            } if (validValues.isEmpty()) {
                System.out.println(EMPTY);
            } else {
                Collections.sort(validValues);
                int min = validValues.get(0);
                int max = validValues.get(validValues.size() - 1);
                System.out.println(max + " " + min);
            }
        }
    }

    private static void deleteLogic(PriorityQueue<Integer> maxPq,
                                    PriorityQueue<Integer> minPq,
                                    int flag,
                                    Map<Integer, Integer> checker) {

        if (flag == MAX_DEL) {
            while (true) {
                Integer maxValue = maxPq.peek();
                if (maxPq.isEmpty()) {
                    break;
                }
                if (checker.get(maxValue) == 0) {
                    maxPq.poll();
                } else {
                    maxPq.poll();
                    checker.put(maxValue, checker.get(maxValue) - 1);
                    break;
                }
            }
        } else {
            while (true) {
                Integer minValue = minPq.peek();
                if (minPq.isEmpty()) {
                    break;
                }
                if (checker.get(minValue) == 0) {
                    minPq.poll();
                } else {
                    minPq.poll();
                    checker.put(minValue, checker.get(minValue) - 1);
                    break;
                }
            }
        }
    }
}
