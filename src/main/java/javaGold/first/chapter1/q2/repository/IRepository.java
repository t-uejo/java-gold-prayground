package javaGold.first.chapter1.q2.repository;

public interface IRepository {
    //公開したいものだけを定義できる
    public int getRecord();

    public static IRepository factory(){
        return new SQL();
    }
}
