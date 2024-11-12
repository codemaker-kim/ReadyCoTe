package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp!=0)
                st.push(tmp);
            else
                st.pop();
        }

        int ans = 0;

        // 만약 i가 st.size()만큼 반복할 경우, 첫 pop을 진행한 후 두 번째 반복을 돌때 size값이 감소함.
        // 따라서 스택 내부를 순회하는 알고리즘으로 변경함.
        for(int i : st) {
            ans+=i;
        }

        System.out.println(ans);
    }
}
