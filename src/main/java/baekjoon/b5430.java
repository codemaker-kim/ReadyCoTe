package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class b5430 {

    private static char reverse = 'R';
    private static char delete = 'D';

    private static String error = "[error]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();
            List<Integer> numbers = parseInput(x);

            calculateAC(p, numbers);
        }
    }

    private static List<Integer> parseInput(String x) {
        String parsed = x.substring(1, x.length() - 1);

        if (parsed.isEmpty()) {
            return List.of();
        }

        return Arrays.stream(parsed.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void calculateAC(String p, List<Integer> numbers) {
        for (int index = 0; index < p.length(); index++) {
            char temp = p.charAt(index);

            if (temp == reverse) {
                Collections.reverse(numbers);
            } else if (temp == delete) {
                if (numbers.isEmpty()) {
                    System.out.println(error);
                    return;
                }
                numbers.remove(0);
            }
        }

        System.out.println(numbers);
    }
}
