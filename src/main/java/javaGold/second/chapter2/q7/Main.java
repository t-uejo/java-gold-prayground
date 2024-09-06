package javaGold.second.chapter2.q7;

import java.util.function.Predicate;

public class Main {
    public static void main (String[] args) {
        Person person = new Person(Person.Gender.MALE,180,900,20);

        Predicate<Person> isHighIncome = p -> p.getIncome() >= 600;
        Predicate<Person> isHighHeight = p -> p.getHeight() >= 180;
        Predicate<Person> isAdult = p -> p.getAge() >= 20;

        //成人、収入600万以上、身長180センチ以上であれば
        if (isAdult.and(isHighIncome.and(isHighHeight)).test(person)) {
            System.out.println("OK");
            return;
        }
        System.out.println("NG");
    }
}
