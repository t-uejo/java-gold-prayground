# Predicateを使った説明用変数の導入

今回はPredicateを使って説明用変数の導入を行う。説明用変数とは、条件式を変数として定義したものである。これを使うことで条件式の可読性が向上する。

以下は説明用変数を使わない例。
```java
public static void main (String[] args) {
    Person person = new Person(Person.Gender.MALE,180,900,20);

    //成人、収入600万以上、身長180センチ以上であれば
    if (person.getAge >= 20 && person.getIncome >= 600 && person.getHeight > 180) {
        System.out.println("OK");
        return;
    }
    System.out.println("NG");
}
```
これをもとにPredicateを使って説明用変数を導入したリファクタリング例。

```java
public static void main (String[] args) {
    Person person = new Person(Person.Gender.MALE,180,900,20);

    //説明用変数
    Predicate<Person> isHighIncome = p -> p.getIncome() >= 600;
    Predicate<Person> isHighHeight = p -> p.getHeight() >= 180;
    Predicate<Person> isAdult = p -> p.getAge() >= 20;

    //成人、収入600万以上、身長180センチ以上であれば
    if (isAdult.and(isHighIncome).and(isHighHeight).test(person)) {
        System.out.println("OK");
        return;
    }
    System.out.println("NG");
}
```

andやorメソッドを適切に使うことで複雑な条件式でも簡潔に記載できる。ただし、これらメソッドは直前の条件式に連結することになるため、連結場所や順番に注意を払う必要がある。

[トップへ戻る](../../../../../../../README.md)