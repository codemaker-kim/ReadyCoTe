package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Dot implements Comparable {
    private int x;
    private int y;

    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        Dot d = (Dot) o;

        if(d.getX() > this.x)
            return -1;
        else if(d.getX() < this.x)
            return 1;
        else
        {
            return d.getY() > this.y ? -1 : 1;
        }
    }
}

public class b11650{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Dot> dots = new ArrayList<>();

        for(int i=0; i<T; i++) {
            int[] s = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            dots.add(new Dot(s[0], s[1]));
        }

        Collections.sort(dots);

        dots.forEach((d) -> System.out.println(d.getX() + " " + d.getY()));
    }
}

