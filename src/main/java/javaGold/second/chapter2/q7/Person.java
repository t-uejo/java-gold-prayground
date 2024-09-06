package javaGold.second.chapter2.q7;

public class Person {
    public enum Gender{
        MALE,
        FEMALE
    }

    private Gender gender;
    private final int height;
    private final int income;
    private final int age;

    public Person(Gender gender, int height, int income, int age) {
        this.gender = gender;
        this.height = height;
        this.income = income;
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }
    public int getHeight() {
        return height;
    }
    public int getIncome() {
        return income;
    }
    public int getAge() {
        return age;
    }
}
