package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 단어집합2 {

    private static final String END = "END";
    private static final String BLANK = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wordSet = new LinkedHashSet<>();

        while (true) {
            String input = br.readLine();

            // 종료 조건
            if (input.equals(END)) {
                break;
            }

            String[] split = input.split(BLANK);
            wordSet.addAll(Arrays.asList(split));

            String result = String.join(" ", wordSet);
            System.out.println(result);
        }
    }
}

