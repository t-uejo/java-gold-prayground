# Enumが生まれた背景と特徴

## 背景
Enumがない時代は以下のように定義していた。

```java
public interface Fruits{
    public final static int APPLE = 0;
    public final static int ORANGE = 1;
    public final static int BANANA = 2;
}
```
ただこれだと、以下のように誤って定義した場合、appleとmelonが同じ定数値のため不具合が生じる。
```java
public interface Fruits{
    public final static int APPLE = 0;
    public final static int ORANGE = 1;
    public final static int BANANA = 2;
    public final static int MELON = 0;
}
```
上記のような問題を解決するためにEnumは生まれた。

```java
public enum Fruits{
    APPLE,
    ORANGE,
    BANANA,
    MELON
}
```

## 特徴
以下の特徴がある。
- 他のプログラミング言語と異なりjava.lang.Enumクラスのサブクラスとして扱われる。
- `values`と`valueOf`メソッドがコンパイラによって追加され、利用できる。
- Enumに定義した列挙子はそれぞれがインスタンス生成される。(上記の例だとFruits型の４つのインスタンスができる)
  - コンパイル時にstatic初期化子の中で各列挙子のインスタンスが生成され、staticフィールドに代入される。

[トップへ戻る](../../../../../../../README.md)