package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b1654 {

    static List<Integer> wireLength = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] KN = br.readLine().split(" ");

        int k = Integer.parseInt(KN[0]);
        int n = Integer.parseInt(KN[1]);

        List<Integer> lanWires = new ArrayList<Integer>();

        // 리스트에 값 삽입
        for(int i=0; i<k; i++) {
            lanWires.add(Integer.parseInt(br.readLine()));
        }

        int maxValue = Collections.max(lanWires);

        for(int i = 1; i<=maxValue; i++) {
            wireLength.add(i);
        }

        int size = findMidValue(wireLength.size()-1);

        int result = binarySearch(size, 0, wireLength.size()-1);

        System.out.println(result);
    }

    static int findMidValue(int value) {
        return value%2==0 ? value/2 : (value/2)+1;
    }

    static int binarySearch(int goal, int low, int high) {
        int mid = findMidValue(wireLength.size()-1);

        while(low <= high){
            mid = (low + high) / 2;

            if(goal == wireLength.get(mid))
                return mid;
            else if(goal < wireLength.get(mid))
                high = mid-1;
            else
                low = mid+1;
        }

        return mid;
    }
}
