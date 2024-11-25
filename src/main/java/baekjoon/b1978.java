package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class b1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int cnt = 0;

        for(int i : list) {
            boolean isPrime = false;
            for(int j=1; j<i; j++){
                if(i==2){
                    isPrime = true;
                    break;
                } else if(i%j==0 && j!=1)
                    break;
                else if(j==i-1)
                    isPrime = true;

            }
            if(isPrime)
                cnt+=1;
        }

        System.out.println(cnt);
    }
}
