package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] KN = br.readLine().split(" ");

        int k = Integer.parseInt(KN[0]);
        int n = Integer.parseInt(KN[1]);

        ArrayList<Integer> lanWires = new ArrayList<Integer>();

        // 리스트에 값 삽입
        for(int i=0; i<k; i++) {
            lanWires.add(Integer.parseInt(br.readLine()));
        }

        // 아 너무 아이디어가 안떠오른다..

    }
}
