package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class b2798{
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mostNear = 0;

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        visited = new boolean[N];

        List<Integer> cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        //구현 로직
    }
}
