package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int[] triangle = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if(triangle[0]==0 && triangle[1]==0 && triangle[2]==0) {
                break;
            }

            Arrays.sort(triangle);

            if(triangle[2]*triangle[2] == triangle[1]*triangle[1]+triangle[0]*triangle[0])
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
