package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class b7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Person p = new Person(x, y);
            persons.add(p);
            rank.add(1);
        }

        for(Person p : persons) {
            for(int i=0; i<persons.size(); i++) {
                if(persons.get(i) == p)
                    continue;

                switch (compareBody(p, persons.get(i))){
                    case 0:
                        break;
                    case 1:
                        rank.set(i, rank.get(i) + 1);
                        break;
                    case 2:
                        break;
                }
            }
        }

        for(int i=0; i<rank.size(); i++) {
            if(i==rank.size()-1)
                System.out.print(rank.get(i));
            else
                System.out.print(rank.get(i) + " ");
        }
    }

    static int compareBody(Person p1, Person p2) {
        if((p1.getX() > p2.getX()) && (p1.getY() > p2.getY()))
            return 1;
        else if((p1.getX() < p2.getX()) && (p1.getY() < p2.getY()))
            return 2;
        else
            return 0;
    }

    static class Person{
        int x; // 몸무게
        int y; // 키

        Person(int x,int y){
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
