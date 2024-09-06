# Streamインターフェースのmapメソッドとfilterメソッドの違い

設問で以下のコード例のfilter部分がmapかfilterかどうか問われた。既にfilterであることは分かっているため記述しているが、最初は分からなかった。

```java
List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
list.stream()
    .filter(n -> n > 5)
    .forEach(System.out::print);
```

なぜfilterなのか、それぞれのシグネチャから違いを確認すると、引数に受け取る関数型インターフェースが違うためである。Predicateでなければいけなかったのでfilterとなると理解できた。

- filter：`filter(Predicate<? super T> predicate)`
- map：`map(Function<? super T,? extends R> mapper)`

また、mapメソッドの引数である`Function<? super T,? extends R>`について2つの型をとることは学習済み。1つ目は消費する型であり、2つ目は戻り値として提供する型である。

これは[PECSの法則](../../../second/chapter7/q9/README.md)にもあった通りである。Producerがextendsであり、consumerがsuperという意味だ。


参照：https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/Stream.html

[トップへ戻る](../../../../../../../README.md)