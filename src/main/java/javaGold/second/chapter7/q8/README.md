# 非境界ワイルドカードと上限境界ワイルドカードの違い

非境界ワイルドカードには2つの特徴があると[前回](../q6/README.md)書いた。
1. メソッドの戻り値型はObject型になる
2. メソッドの引数にはnullリテラルしか渡せない

今回は違いについて確認する。端的にいうと、
上限境界ワイルドカードを使うと、戻り値の型を特定することができる。

```java
public class Test<T> {
    private T value;

    public Test(T value) {
        this.value = value;
    }
    
    public T setValue(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
}
```
上記クラスを以下のように上限境界ワイルドカードを使ってインスタンス化する。
```java
Test<? extends A> test = new Test<A>(new A());

A a = test.getValue(); //戻り型はA
test.setValue(new A()); //コンパイルエラー
```
2行目を見ると、戻り値の型はObject型ではない。この理由は、保証されているからである。Aないし、Aのサブクラスしか戻ってこないということが保証されるので、Aを返しても問題ない。

しかし、3行目ではコンパイルエラーが出ている。これは、testのフィールドの型が不定であるため。`<? extends A>`であり、ある1つの型に特定されていないので不定と判断される。

このように、上限境界ワイルドカードは、戻り値型のみが非境界ワイルドカードと異なるが、引数にnullリテラルしか渡せないという特徴は同じである。

[トップへ戻る](../../../../../../../README.md)