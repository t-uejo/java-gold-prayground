# Optionalが解決する課題と欠点

Optionalがどんな課題を解決するのかを見ていく。

書籍では、Optionalは例外処理の記述を減らし、可読性を上げることができると述べられている。以下のような一般的なコードでは、メソッド内で例外が発生した場合、呼び出し側で`IllegalArgumentException`をハンドリングする必要がある。

```java
public static void main (String[] args) {
    String[] array = new String[]{"A", "B", null};

    //IllegalArgumentExceptionをハンドリングする必要あり
    try {
        String result = getFromArray(array, 3);
        
        if(result == null){
            System.out.println("指定したインデックス番号に対応する配列の中身がNullです。");
            return; 
        }
        System.out.println(result);
        
    } catch (IllegalArgumentException e) {
        System.out.println(e.message());
    }
}
```
```java
/**
 * 配列から指定されたインデックス位置にある要素を取得します。
 *
 * @param array 操作対象の配列
 * @param index 取得したい要素のインデックス位置
 * @return インデックス位置にある要素
 * @throws IllegalArgumentException 配列がnullの場合、またはインデックスが正しくない場合にスローされます。
 */
public static <T> T getFromArray(T[] array, int index) {
    //事前条件の確認
    if (array == null) {
        throw new IllegalArgumentException("arrayがNullです。");
    }
    try {
        return array[index];
        
    } catch (ArrayIndexOutOfBoundsException e) {
        throw new IllegalArgumentException("インデックス番号が正しくありません。");
    }
}
```

特に、今回のような`IllegalArgumentException`は非検査例外なので、無視される可能性が極めて高い。

上記コードの問題点をまとめると以下の2つである。
- 例外処理があるため可読性が低い
- 非検査例外が無視される可能性がある

冒頭で述べたOptionalを使うことで、これらの問題を解決することができる。実際にOptionalを使ってリファクタリング例が以下である。

```java
public static void main (String[] args) {
    String[] array = new String[]{"A", "B", null};

    //Optionalが返るので例外処理が必要ない
    Optional<String> result = getFromArray(array, 3);
    
    if(result.isEmpty()){
        System.out.println("empty");
        return;
    }
    System.out.println(result.get());
}
```
```java
/**
 * 配列から指定されたインデックス位置にある要素を取得します。
 *
 * @param array 操作対象の配列
 * @param index 取得したい要素のインデックス位置
 * @return インデックス位置にある要素を含む Optional インスタンス。インデックスが正しくない場合や、配列が null の場合、Optional.empty() が返されます。
 */
public static <T> T getFromArray(T[] array, int index) {
    //事前条件の確認
    if (array == null) {
        return Optional.empty();
    }
    
    try {
        return Optional.ofNullable(array[index]);
        
    } catch (ArrayIndexOutOfBoundsException e) {
        return Optional.empty();
    }
}
```

このプログラムでは、getFromArrayが`IllegalArgumentException`をthrowすることなく、Optionalインスタンスを返すことで、呼び出し元でのtry-catchブロックが必要なくなった。これにより可読性向上と例外が無視される可能性をなくすことができている。

## Optionalの欠点とEither

ただし、書籍では語られていなかったが、上記コードには問題がある。それは、Optionalがemptyの場合、どこで生成されたものか分からないということ。今回のコードでは3つの箇所でemptyを返す可能性がある。

emptyを作る前にコンソールに表示させたり、ログに出力したりするのか。とにかく、例外発生個所が複数ある場合は使うべきかを検討し、使うならどこで発生したかを明確にする必要があると考える。

[JavaのOptionalのモナド的な使い方](https://qiita.com/koher/items/6f4a8d8b3ad3142bf645#fn4)では、以下のように述べられている。

> 例外と比較した場合の Optional の欠点はエラーの理由を取得できないことです。 Optional がよく使われる関数型言語などでは、そういう場合は Either<L, R> のような L か R のどちらかを保持することができる型を使って、値かエラーかを保持することが行われます。残念ながら Java 8 時点では標準ライブラリで Either 相当のクラスは提供されていません。

かなり難易度は高いが、ライブラリを使ってEitherを活用する方法があるらしい。以下の記事で述べられている。

[Java Stream APIの個々の例外処理にEitherを活用する](https://qiita.com/kazuhiro1982/items/f8877c622f781b071b4e)

[トップへ戻る](../../../../../../../README.md)