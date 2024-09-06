# Javaはどのようにして関数を第一級関数として扱うのか

第一級関数とは、関数を変数に代入したり、引数に渡したりすることができる性質のことをいう。

そもそもJavaは関数をそのように自由に扱うことができない。つまり、第一級関数の性質を満たしていない言語である。

しかし、Javaではラムダ式が存在し、メソッドの引数や変数に関数を与えられるという事実がある。ここでは、この事実がどのようにして成り立っているかを見ていく。

## 関数を第一級関数として扱うことができると何がいいのか

外から関数を与えることで、振る舞いを柔軟に操作することができる点である。

例えば、以下のように3つの単語を並び替える処理を見ていく。単語を自然順序で並び替えるだけなら、sortメソッドにコレクションを渡すことで実現することができる。

```java
List<String> strings = Arrays.asList("cherry", "apple", "banana");

Collections.sort(strings);
System.out.println(strings); // -> [apple, banana, cherry]

Collections.sort(strings, Comparator.reverseOrder());
System.out.println(strings); // -> [cherry, banana, apple]
```

仮に、逆順で並び替える必要があった場合、sortメソッドの第２引数に関数を渡すことで実現することができる。

```java
Collections.sort(strings, Comparator.reverseOrder());
System.out.println(strings); // -> [cherry, banana, apple]
```

このように、第一級関数（ここではラムダ式）を使うことで、sortメソッドの振る舞いを柔軟にすることができている。

## なぜこのような処理を実現できるのか

インターフェースと匿名クラス、ラムダ式によって実現している。

これらについて詳細は割愛するが、実際には匿名クラスかラムダ式を渡して、インターフェースによるポリモーフィズムによって、渡した第一級関数を実行させる。

つまり、Javaはインタフェースを利用することで、実質、関数(メソッド)を第一級オブジェクトのように扱えているということ。

## 関数型インターフェースとは何か

Javaでは、APIの引数に直接的に関数を渡せるよう、いくつかのインターフェースが用意されている。これを関数型インターフェースという。

関数を第一級オブジェクトとして扱うために利用しているインタフェースのこと。本来やりたいことは関数を第一級関数として扱いたいだけなので、インターフェースに定義するメソッドは1つのみである。

[トップへ戻る](../../../../../../../README.md)