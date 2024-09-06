# OptionalのmapとflatMapの違い

それぞれのシグネチャから違いを確認する。

- map：`public <U> Optional<U> map(Function<? super T,? extends U> mapper)`
- flatMap：`public <U> Optional<U> flatMap(Function<? super T,Optional<U>> mapper)`

戻り値は`Optional<U>`であり同じである。一方で、引数が異なる。どちらも関数型インターフェースである`Function`を受け取っているが、`Function`の戻り値の型が異なる。

mapメソッドは、戻り値を新しいOptionalインスタンスに入れて返すのに対して、flatMapメソッドは戻り値をそのまま返す。

まとめると、戻り値を新しいOptionalインスタンスに入れるかどうかという違いである。

参照：https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html

[トップへ戻る](../../../../../../../README.md)