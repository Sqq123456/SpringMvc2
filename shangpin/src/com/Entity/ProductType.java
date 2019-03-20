package com.Entity;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
public class ProductType {

    private int id;
    private String name;

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductType(String name) {
        this.name = name;
    }

    public ProductType() {
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
}
