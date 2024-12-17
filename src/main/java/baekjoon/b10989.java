package baekjoon;

import java.io.*;
import java.util.Arrays;

public class b10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        short[] arr = new short[N];

        for(int i=0; i<N; i++) {
            arr[i] = Short.parseShort(br.readLine());
        }

        Arrays.sort(arr);
        for(short i : arr) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
