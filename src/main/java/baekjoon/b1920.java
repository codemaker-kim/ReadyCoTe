package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class b1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 첫 번째 숫자의 개수
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        // 첫 번째 배열 입력
        String[] arr = br.readLine().split(" ");
        for (String str : arr) {
            set.add(Integer.parseInt(str));
        }

        // 두 번째 숫자의 개수
        int M = Integer.parseInt(br.readLine());

        // 두 번째 배열 입력 및 결과 출력
        String[] newArr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : newArr) {
            if (set.contains(Integer.parseInt(str))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}