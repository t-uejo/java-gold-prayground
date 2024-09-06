# Consumerを使ったBuilderパターンの実装例

今回はBuilderパターンとその課題を解決するためのConsumerの使い方を見ていく。

## Builderパターンが解決する課題
まずBuilderパターンとは、GoFのデザインパターンの1つ。コンストラクタが多い場合、Builderを使うと直感的にオブジェクトを構築することができる。

例えば、以下のようなItemクラスがあるとする。

```java
import java.util.Date;

class Item {
    private int id;
    private String name;
    private int price;
    private String category;
    private int date;

    private Item(int id, String name, int price, String category, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category; 
        this.date = date; 
    }
}
```
```java
Item item = new Item(1, "keybord", 17500, "PC周辺機器", 20231016);
```
他のクラスでオブジェクトを構築する（インスタンス化）する場合、上記のように5つ指定しなければいけず、どこに何を指定するか多くの注意を払う必要がある。別の型であればコンパイルエラーが出るが、同じ型の引数に間違ったフィールド値を指定するリスクもある。

このような場合にビルダーを使うことで、直感的かつ安全にインスタンス化ができる。ItemクラスをBuilderに変更した[ソース](Item.java)。

```java
//ビルダーを使ってItemクラスを呼び出す
Item item = new Item.Builder(1)
        .setName("keybord")
        .setPrice(17500)
        .setCategory("PC周辺機器")
        .setDate(20231016)
        .build();
```

上記のようにBuilderを使うことで、かなり直感的にオブジェクトの構築ができるようになった。

## Builder自体の課題

しかし、Builder自体にも課題はある。それは、フィールドが増えた場合に、毎回setterを定義しなければいけない点である。

現在は5つしかないが、ここからさらに10個、20個と増えていった場合（クラス設計に問題がありそうだが）、setterも同時に増えていき、可読性の低下や修正時間の増加の懸念がある。

そこで、関数型インターフェースであるConsumerを使うことでsetterを定義せずともBuilderクラスを設計することができる。

ItemクラスのBuilderをConsumerを使って実装した[ソース](ItemUsingConsumer.java)。

```java
//consumerを使ってItemクラスを呼び出す
ItemUsingConsumer item = new ItemUsingConsumer.Builder(1)
                .with(b -> {
                    b.name = "keybord";
                    b.price = 17500;
                    b.category = "PC周辺機器";
                    b.date = 20231016;
                })
                .build();
```

このようにsetterというのは、引数を受け取りvoidすることを行うメソッドなので、consumerを使って実装することができる。

[トップへ戻る](../../../../../../../README.md)