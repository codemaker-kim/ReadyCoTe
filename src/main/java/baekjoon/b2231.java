package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int minNum = Integer.parseInt(N)-(N.length()*9);

        while(true){
            int tmp = minNum;
            String num = Integer.toString(minNum);

            for(int i=0; i<num.length(); i++) {
                tmp+= Integer.parseInt(Character.getNumericValue(num.charAt(i))+"") ;
            }
            if(Integer.parseInt(N) == tmp){
                System.out.println(minNum);
                break;
            } else if(minNum > Integer.parseInt(N)){
                System.out.println(0);
                break;
            } else{
                minNum+=1;
            }
        }
    }
}
