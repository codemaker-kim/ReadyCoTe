package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<3; i++) {
            arr.add(br.readLine());
        }


        for(int i=1; i<=3; i++) {
            try{
                int ans = Integer.parseInt(arr.get(i-1));
                if((ans+4-i) % 15 == 0){
                    System.out.println("FizzBuzz");
                    break;
                } else if((ans+4-i) % 3 == 0){
                    System.out.println("Fizz");
                    break;
                } else if((ans+4-i) % 5 == 0){
                    System.out.println("Buzz");
                    break;
                } else{
                    System.out.println(ans+4-i);
                    break;
                }
            } catch (NumberFormatException e){
                continue;
            }
        }
    }
}

