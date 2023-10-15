# 匿名クラスの特徴

書籍では以下のような特徴があると述べられている。

> - 匿名クラスではコンストラクタは定義できない。
> - インターフェースを実現したクラス、抽象クラスか具象クラスを継承したサブクラスを定義する。

それをもとに作成したプログラムが以下である。listBはあくまでArrayListのサブクラスとして定義されているところがポイント。AとBで使う際に違いがあるのかは未調査なので追々確認したい。

```java
public class Main {
    public static void main(String[] args){
        //ArrayListをインスタンス化して参照をlistAに渡している。
        List<String> listA = new ArrayList<>();
        listA.add("A");
        listA.add("B");
        listA.add("C");

        //ArrayListを継承したサブクラスを匿名クラスとして定義してインスタンス化し、
        //初期化ブロックでsuperクラスであるArrayListのaddメソッドを呼び出してコレクションに追加している。
        List<String> listB = new ArrayList<String>() {
            {
                super.add("A");
                super.add("B");
                super.add("C");
            }
        };
    }
}
```

[トップへ戻る](../../../../../../../README.md)