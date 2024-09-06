package javaGold.second.chapter2.q2;

public class MySQL implements IRepository{
    @Override
    public void insert() {
        System.out.println("MySQLにインサートしました");
    }

    @Override
    public int getRecord() {
        return 1;
    }
}
