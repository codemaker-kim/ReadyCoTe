package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class b1874 {
    private static final String PUSH = "+";
    private static final String POP = "-";
    private static final String IMPOSSIBLE = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 반복 수와 수열 입력 - 목표 수열을 생성
        int n = Integer.parseInt(br.readLine());
        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add(Integer.parseInt(br.readLine()));
        }

        // 2. 스택을 생성
        Stack<Integer> stack = new Stack<>();

        int next = 1; // 다음에 스택에 삽입할 수
        int seqIndex = 0; // 목표 수열의 인덱스

        StringBuilder sb = new StringBuilder();

        while (true) {
            // 인덱스가 최종 길이보다 크다면 정답을 출력하고 종료
            if (n-1 < seqIndex) {
                System.out.println(sb.toString());
                break;
            }

            // 스택이 비어 있으면, 먼저 숫자 삽입
            if (stack.empty()) {
                stack.push(next);
                sb.append(PUSH + "\n");
                next++;
            }

            // 스택의 최상단을 확인
            int top = stack.peek();
            int targetNum = sequence.get(seqIndex);

            // 최상단이 목표하는 수보다 크다면 실패
            if (targetNum < top) {
                System.out.println(IMPOSSIBLE);
                break;
            }

            // 최상단이 목표하는 수와 같다면 POP
            else if (top == targetNum) {
                stack.pop();
                sb.append(POP + "\n");
                seqIndex++;
            }

            // 최상단이 목표하는 수보다 작다면 PUSH
            else {
                stack.push(next);
                sb.append(PUSH + "\n");
                next++;
            }
        }
    }
}
