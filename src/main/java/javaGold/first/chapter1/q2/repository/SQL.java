package javaGold.first.chapter1.q2.repository;

//インターフェースをドメイン層に置いた場合、パッケージプライベートにしようと思ったができなかった。
//インターフェースを内側に置けば解決する。
class SQL implements IRepository {
    @Override
    public int getRecord() {
        return 0;
    }

    public int getRecord2() {
        return 0;
    }
}
