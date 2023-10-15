# なぜジェネリクスが必要なのか

1つのクラスで複数の型を扱うためである。以下のような貨幣クラスは整数だけを扱うことに特化しているが、国によって、小数点以下を扱いたい場合も出てくる。

```java
public class Currency{
    //amountがIntegerで定義されている
    private Integer amount;
    public Currency(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
```
そこでジェネリクスを使うことで、実行時に型を決めることができるので、例えばDouble型を扱うこともできる。

```java
public class Currency<T> {
    //amountの型は実行時に渡された型パラメータによって決まる
    private T amount;

    public Currency(T amount) {
        this.amount = amount;
    }

    public T getAmount() {
        return amount;
    }
}

//呼び出し側
Currency<Double> currency = new Currency<Double>(7.25);
```
また、コレクションでは複数の型を混在させることができる。複数の型が混在している場合、ジェネリクスがなければ、ダウンキャストの際に実行時エラーが出る可能性がある。ジェネリクスで型パラメータを指定することで、このような問題を解決する。

<>をダイヤモンド演算子と呼び、Tを型パラメータと呼ぶ。

なお、この型パラメータを渡さなかった場合、**Object型の型パラメータ**が渡されたことになる。

[トップへ戻る](../../../../../../../README.md)