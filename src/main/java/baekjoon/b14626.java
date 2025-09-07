package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b14626 {

    private static final String DAMAGED_NUMBER_INPUT = "*";
    private static final int ODD_MUL = 1;
    private static final int EVEN_MUL = 3;
    private static final int CHECKMARK_INDEX = 12;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ISBN = br.readLine().split("");

        int damagedNumIndex = 0;
        int value = 0;
        boolean isOdd = false;

        for (int i = 0; i < ISBN.length; i++) {
            if (ISBN[i].equals(DAMAGED_NUMBER_INPUT)) {
                damagedNumIndex = i;
                isOdd = i % 2 == 0;
                continue;
            }

            int temp = Integer.parseInt(ISBN[i]);

            if (i % 2 == 0) {
                value += temp * ODD_MUL;
            } else {
                value += temp * EVEN_MUL;
            }
        }

        if (value % 10 == 0)
            System.out.println(0);

        for (int i = 1; i < 10; i++) {
            int temp = isOdd ? i * ODD_MUL : i * EVEN_MUL;

            if ((value + temp) % 10 == 0)
                System.out.println(isOdd ? temp : (temp / 3));
        }
    }
}
