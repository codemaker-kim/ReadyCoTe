package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class b2798{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mostNear = 0;

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] cards = br.readLine().split(" ");

        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++) {
                    int tmp = Integer.parseInt(cards[i]) + Integer.parseInt(cards[j]) + Integer.parseInt(cards[k]);

                    if(tmp <= M && tmp > mostNear) {
                        mostNear = tmp;
                    }
                }
            }
        }

        System.out.println(mostNear);
    }
}
