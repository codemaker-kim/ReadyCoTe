package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<JudgeUser> judgeList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            judgeList.add(new JudgeUser(Integer.parseInt(input[0]), input[1]));
        }

        Collections.sort(judgeList);

        for(JudgeUser user: judgeList) {
            System.out.println(user.getAge() + " " + user.getName());
        }
    }

    static class JudgeUser implements Comparable<JudgeUser> {
        private int age;
        private String name;

        public JudgeUser(int age, String name) {
            this.age = age;
            this.name = name;
        }

        //Comparable 인터페이스를 구현 상속하여 객체 비교 기준 지정
        @Override
        public int compareTo(JudgeUser o) {
            return Integer.compare(this.age, o.age);
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}

