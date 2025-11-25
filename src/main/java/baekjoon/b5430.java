package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class b5430 {

    private static char reverse = 'R';
    private static char delete = 'D';

    private static String error = "error";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();
            Deque<Integer> numbers = parseInput(x);

            calculateAC(p, numbers);
        }
    }

    private static Deque<Integer> parseInput(String x) {
        String parsed = x.substring(1, x.length() - 1);

        if (parsed.isEmpty()) {
            return new ArrayDeque<>();
        }

        return Arrays.stream(parsed.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static void calculateAC(String p, Deque<Integer> numbers) {
        boolean isReversed = false;

        for (int index = 0; index < p.length(); index++) {
            char temp = p.charAt(index);

            if (temp == reverse) {
                isReversed = !isReversed;
            } else if (temp == delete) {
                if (numbers.isEmpty()) {
                    System.out.println(error);
                    return;
                }

                if (isReversed) {
                    numbers.pollLast();
                } else {
                    numbers.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");

        if (isReversed) {
            while(!numbers.isEmpty()) {
                sb.append(numbers.pollLast());
                if (numbers.peekLast() != null)
                    sb.append(",");
            }
        } else {
            while(!numbers.isEmpty()) {
                sb.append(numbers.pollFirst());
                if (numbers.peekFirst() != null)
                    sb.append(",");
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
