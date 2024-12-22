package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        while(true) {
            String tmp = br.readLine();
            if(tmp.equals(".")) {
                System.out.println("yes");
                break;
            }
            st.clear();
            for(int i=0; i<tmp.length(); i++) {
                if(tmp.charAt(i)=='(' || tmp.charAt(i)=='[') {
                    st.push(tmp.charAt(i));
                } else if(tmp.charAt(i)==')' || tmp.charAt(i)==']') {
                    char brac = tmp.charAt(i);
                    if(!st.isEmpty() && brac==')' && st.peek()=='(')
                        st.pop();
                    else if(!st.isEmpty() && brac==']' && st.peek()=='[')
                        st.pop();
                }
            }

            if(st.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
