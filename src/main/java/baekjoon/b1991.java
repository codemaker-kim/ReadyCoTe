package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1991 {

    private static final String EMPTY = ".";
    private static final String ROOT_NODE = "A";
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;

    private static Map<String, String[]> nodes = new HashMap<>();
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input, " ");

            String node = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            nodes.put(node, new String[]{leftNode, rightNode});
        }

        preOrder();
        inOrder();
        postOrder();
    }

    // 루트 - 왼쪽 - 오른쪽 우선순위
    private static void preOrder() {
        StringBuilder sb = new StringBuilder();

        // 루트 노드를 먼저 삽입한다.
        stack.push(ROOT_NODE);

        // 스택이 빌 때까지 반복
        while (!stack.isEmpty()) {
            // 스택에서 값을 뽑아냄.
            String node = stack.pop();
            sb.append(node);

            String[] childNodes = nodes.get(node);

            String left = childNodes[LEFT_INDEX];
            String right = childNodes[RIGHT_INDEX];

            // 스택이기에, 후입선출에 맞추어 오른쪽 노드부터 삽입
            if (!right.equals(EMPTY)) {
                stack.push(right);
            }

            if (!left.equals(EMPTY)) {
                stack.push(left);
            }
        }

        System.out.println(sb.toString());
    }

    // 왼쪽 - 루트 - 오른쪽 우선순위 (중위 순회)
    private static void inOrder() {
        StringBuilder sb = new StringBuilder();
        String currNode = ROOT_NODE;

        while (!stack.isEmpty() || !currNode.equals(EMPTY)) {

            while (!currNode.equals(EMPTY)) {
                stack.push(currNode);
                currNode = nodes.get(currNode)[LEFT_INDEX];
            }

            currNode = stack.pop();
            sb.append(currNode);

            currNode = nodes.get(currNode)[RIGHT_INDEX];
        }
        System.out.println(sb.toString());
    }

    // 왼쪽 - 오른쪽 - 루트 우선순위
    private static void postOrder() {
        Stack<String> s2 = new Stack<>();
        stack.push(ROOT_NODE);

        while (!stack.isEmpty()) {
            String curr = stack.pop();
            s2.push(curr);

            String left = nodes.get(curr)[LEFT_INDEX];
            String right = nodes.get(curr)[RIGHT_INDEX];

            if (!left.equals(EMPTY)) {
                stack.push(left);
            }
            if (!right.equals(EMPTY)) {
                stack.push(right);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!s2.isEmpty()) {
            sb.append(s2.pop());
        }

        System.out.println(sb.toString());
    }
}
