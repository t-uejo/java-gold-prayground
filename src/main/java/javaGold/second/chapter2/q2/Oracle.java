package javaGold.second.chapter2.q2;

public class Oracle implements IRepository{
    @Override
    public void insert() {
        System.out.println("Oracleにインサートしました");
    }

    @Override
    public int getRecord() {
        return 0;
    }
}
