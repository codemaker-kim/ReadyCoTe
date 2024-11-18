package baekjoon;

import java.util.Scanner;

public class b10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split("\n");

        for(int i=0; i<str.length; i++) {
            System.out.println(Integer.parseInt(Character.toString(str[i].charAt(0))) + Integer.parseInt(Character.toString(str[i].charAt(2))));
        }
    }
}
