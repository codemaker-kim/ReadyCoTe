package sw_expert;

import java.util.Scanner;

class 부분집합의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int count = sc.nextInt();
            boolean result = false;

            int[] arr = new int[count];

            for (int j = 0; j < count; j++) {
                arr[j] = sc.nextInt();
            }

            // 부분집합의 개수만큼 반복
            for (int j = 1; j < (1 << count); j++) {
                int sum = 0;
                for (int k = 0; k < count; k++) {
                    // j의 k번째 비트가 1인지 아닌지 확인한다.
                    if ((j & (1 << k)) == 1)
                        sum+=arr[k];
                }

                if (sum == 0) {
                    result = true;
                    break;
                }
            }

            System.out.println(result);
        }
        sc.close();
    }
}
