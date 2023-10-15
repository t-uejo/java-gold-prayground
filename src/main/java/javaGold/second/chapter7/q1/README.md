# なぜオートボクシングが必要なのか

複数のプリミティブ型を扱う場合、配列を使う必要があったが、配列は扱いづらい。（上限や何番目を扱っているかの把握など）

コレクションでプリミティブ型を扱いたいが、参照型のみを保持できるため、以下のようにラッパークラスを使う必要があった。

```java
List<Interger> list = ArrayList<>();
list.add(new Interger(10));
list.add(new Interger(20));

for(int i = 0; i < list.size(); i++){
    Interger obj = list.get(i);
    int num = obj.intValue();
    System.out.println(num);
}
```
上記はあくまで例だが、このようなコードは冗長であったことから、Java SE 5で「オートボクシング」という仕組みが導入された。 これは、プリミティブ型の自動変換機能のことで、自動箱詰めと訳される。（boxの動詞？）

この仕組みを使えば、以下のようにリファクタリングできる。

```java
List<Interger> list = ArrayList<>();
//オートボクシング
list.add(10);
list.add(20);

for(int i = 0; i < list.size(); i++){
    //アンオートボクシング
    int num = list.get(i);
    System.out.println(num);
}
```
なお、この仕組みはコンパイラが自動でコードを置き換えてくれることで成り立っている。

[トップへ戻る](../../../../../../../README.md)