package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b17298 {

    private static final int NO_NGE = -1;
    private static Stack<Integer> indexStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[N];

        // 초기에 오큰수가 없는 값들을 위해 미리 -1 세팅.
        Arrays.fill(result, NO_NGE);

        for (int i = 0; i < N; i++) {
            // 1. 스택이 비어있지 않고, arr[i] 값이 스택 최상단보다 크다면?
            // 오큰수 찾음

            // 2. 현재 인덱스는 다음 원소들을 상대로, 오큰수를 찾아야 하므로 스택에 삽입.
            while (!indexStack.isEmpty() && arr[indexStack.peek()] < arr[i]) {
                // 이 조건이 만족되는 시점에서 이미 오큰수임.
                int popIndex = indexStack.pop();

                result[popIndex] = arr[i];
            }

            indexStack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            sb.append(result[i]).append(" ");
        }

        sb.append(result[N - 1]);

        System.out.println(sb);
    }
}
