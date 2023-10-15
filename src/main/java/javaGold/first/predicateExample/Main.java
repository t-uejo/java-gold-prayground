package javaGold.first.predicateExample;

import java.util.function.Predicate;

public class Main {
    public static void main (String[] args) {
        Person person = new Person(170,900,"hot",20);

        //実装パターン1
        if(person.getHeight() > 170){
            System.out.println("OK");
        }

        //実装パターン2
        //ラムダ式を使わないパターン
        Predicate<Person> isHeight = new Predicate<Person>() {
            public boolean test(Person person) {
                return person.getHeight() > 170;
            }
        };
        if (isHeight.test(person)) {
            System.out.println("OK");
        }

        //実装パターン3
        //ラムダ式を使ったパターン
        Predicate<Person> isIncome = p -> p.getIncome() > 600;
        if (isIncome.test(person)) {
            System.out.println("OK");
        }
    }
}
