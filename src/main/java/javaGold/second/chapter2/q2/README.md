# Supplierを使ったStrategyパターンの実装例

このようにSupplierを使うことで、Factoryを使わずにStrategyパターンを実装することができる。

```java
//Service層を使うレイヤー
public class Main {
    public static void main(String[] args){
        Service service = new Service();

        //Oracleにインサートする
        service.insert(() -> new Oracle());
        //MySQLにインサートする
        service.insert(() -> new MySQL());
    }
}

//Service層
public class Service {
    public void insert(Supplier<IRepository> supplier) {
        IRepository repository = supplier.get();
        repository.insert();
    }
}
```

なお、今回のようなリポジトリパターンにおいて、以下のOracleなどのクラスはパッケージプライベートとして公開しないのがセオリーであるが、例としてこのような設計にしていることを断っておく。

[トップへ戻る](../../../../../../../README.md)