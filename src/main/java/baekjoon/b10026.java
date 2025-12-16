package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b10026 {

    private static final String RED = "R";
    private static final String GREEN = "G";
    private static final String BLUE = "B";

    private static String[][] picture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        picture = new String[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            for (int j = 0; j < N; j++) {
                picture[i][j] = st.nextToken();
            }
        }

        System.out.println(countNormal() + " " + countRedGreenBlindness());
    }

    private static int countNormal() {
        int result = 0;

        boolean[][] visited = new boolean[picture.length][picture[0].length];
        Queue<String> queue = new LinkedList<>();


        return result;
    }

    private static int countRedGreenBlindness() {
        int result = 0;

        return result;
    }
}
