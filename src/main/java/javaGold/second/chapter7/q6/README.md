# 非境界ワイルドカードの特徴と使いどころ

非境界ワイルドカードには2つの特徴がある。   
1. メソッドの戻り値型はObject型になる
2. メソッドの引数にはnullリテラルしか渡せない

以下のコード例をもとに上記を確認する。

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
この総称型クラスTestを以下のように非境界ワイルドカードを使ってインスタンス化する。valueには`Hello`が入る。
```java
Test<?> test = new Test<>("Hello");

String msg = (String) test.getValue(); //戻り型はObject型になる
test.setValue("sample"); //コンパイルエラー
test.setValue(new Object()); //コンパイルエラー
test.setValue(null);
```
まずは1つ目の特徴について見ていく。上記の2行目で`Hello`を取得しているが、この戻り値はObject型となる。この理由は、コンパイラがフィールドの型を特定できず、型が**不定**であると判断したため。

不定と判断した場合は、このようにObject型を返せば、例外を発生させることない。しかし、呼び出し側でダウンキャストをするなど適切に扱わなければならず、安全とは言い難い。

また、2つ目の特徴についても同様の理由である。3行目と4行目のように引数を渡すとエラーが起こり、5行目のようにnullリテラルを渡すとエラーは起こらない。

これは、先に同じく、フィールドの型が不定であるとコンパイラは判断しているためである。不定である型に対して特定の型の参照を代入することはできない。

唯一、nullリテラルであれば問題なく代入できる。Javaの仕様でどのような参照型の変数にでも代入できることが定められているため。

## 使いどころ

このように使い勝手がよくない仕組みではあるが、ニーズがある場面もあり、以下ではその例を見ていく。

[前回](../q4/README.md)見たように、ジェネリクスは非変であることから、以下のようなprintAllメソッドが汎用性を持てない。
```java
List<Integer> a = List.of(1,2,3);
List<String> b = List.of("A","B","C");

//printAllメソッドを呼び出し
printAll(a); //コンパイルエラー
printAll(b); //コンパイルエラー

private static void printAll(Collection<Object> collection){
    collection.stream().forEach(System.out::println);
}
```
printAllメソッドは特にジェネリクスによる違いを意識する必要のないメソッドであるため、汎用性を持たせたいところ。

ここで、ジェネリクスの非境界ワイルドカードが使える。以下のように`?`というワイルドカードをつけることでコンパイルエラーは出ない。

```java
private static void printAll(Collection<?> collection){
    collection.stream().forEach(System.out::println);
}
```

[トップへ戻る](../../../../../../../README.md)