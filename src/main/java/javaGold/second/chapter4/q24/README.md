# StreamのgroupingByメソッドとSQL

以下のように使う。groupingByはFunction型のラムダ式を受け取る。マップのキーとなるのがラムダ式が返す型。バリューがグルーピングされた要素のListである。

```java
List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,1,1,1);

Map<Integer,List<Integer>> map =
        nums.stream()
            .collect(Collectors.groupingBy(i -> i)); 

System.out.println(map);
```
結果は以下のようになる。<br>
`{1=[1, 1, 1, 1], 2=[2], 3=[3], 4=[4], 5=[5], 6=[6], 7=[7], 8=[8], 9=[9]}`

また、以下のようにグルーピングの後に、第二引数に渡した下流Collectorを使って、グループごとに値を加算する集約も定義できる。

```java
List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,1,1,1);

Map<Integer,Integer> map =
        nums.stream()
            .collect(
                Collectors.groupingBy(
                    i -> i,
                    Collectors.summingInt(Integer::intValue)));

System.out.println(map);
```

また、この`groupingBy`メソッドはSQLのような感覚で直感的に理解できた。SQLに`group by`句があり、特定のカラムをもとに対象のレコードをグループ化する。

[トップへ戻る](../../../../../../../README.md)