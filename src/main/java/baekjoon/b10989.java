package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Short> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(Short.parseShort(br.readLine()));
        }

        Collections.sort(arr);
        for(short i : arr) {
            System.out.println(i);
        }
    }
}
