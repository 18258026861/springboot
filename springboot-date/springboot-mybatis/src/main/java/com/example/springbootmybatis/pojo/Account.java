package com.example.springbootmybatis.pojo;

/**
 * @author YZY
 * @date 2020/5/7 - 10:55
 */
public class Account {
    private int id;
    private String name;
    private float money;

    public Account() {
    }

    public Account(int id, String name, float money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
