package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        Queue<Integer> importance = new LinkedList<>();

        for(int i=0; i<T; i++) {

            // 문서의 개수
            int N = sc.nextInt();

            // 몇 번째로 인쇄되었는지 궁금한 문서의 현재 위치.(index)
            int M = sc.nextInt();

            // 현재 있는 문서들의 중요도.
            for(int j=0; j<N; j++) {
                importance.add(sc.nextInt());
            }

            int ans = 1;

            for(int j=0; true; j++) {
                if(importance.stream()
                        .noneMatch(num -> num > importance.peek())) {
                    importance.poll();
                    if(j==M){
                        System.out.println(ans);
                        break;
                    }
                    ans+=1;
                } else if(importance.stream()
                        .anyMatch(num -> num > importance.peek())){
                    if(j==M)
                        M+=importance.size();
                    int tmp = importance.poll();
                    importance.add(tmp);
                }
            }

            importance.clear();
        }

    }
}
