package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Stack<String> st;

        for(int i=0; i<T; i++) {
            st = new Stack<>();
            String[] s = br.readLine().split("");
            for(String str : s) {
                if(st.isEmpty())
                    st.push(str);
                else if(st.peek().equals(str) || st.peek().equals(")"))
                    st.push(str);
                else
                    st.pop();
            }
            System.out.println(st.isEmpty() ? "YES" : "NO");
        }
    }
}
