package baekjoon;

import java.io.*;
import java.util.*;

public class b4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        while (true) {
            String tmp = br.readLine();
            if (tmp.equals(".")) break;

            st.clear();
            boolean isBalanced = true;

            for (char c : tmp.toCharArray()) {
                if (c == '[' || c == '(') {
                    st.push(c);
                } else if (c == ']' || c == ')') {
                    if (st.isEmpty()) {
                        isBalanced = false;
                        break;
                    }

                    char top = st.peek();
                    if ((c == ']' && top == '[') || (c == ')' && top == '(')) {
                        st.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced && st.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}