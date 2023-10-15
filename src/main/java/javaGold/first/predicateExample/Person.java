package javaGold.first.predicateExample;

public class Person {
    private final int height;
    private final int income;
    private final String looks;
    private final int age;

    public Person(int height, int income, String looks, int age) {
        this.height = height;
        this.income = income;
        this.looks = looks;
        this.age = age;
    }
    
    public int getHeight() {
        return height;
    }
    public int getIncome() {
        return income;
    }
    public String getLooks() {
        return looks;
    }
    public int getAge() {
        return age;
    }
}
