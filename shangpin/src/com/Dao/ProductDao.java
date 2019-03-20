package com.Dao;

import com.Entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
public interface ProductDao {

    void insertPro(Product pro);

    void updatePro(Product pro);

    void deletePro(int id);

    Product selectById(int id);

    List<Product> findByName(String name);

    List<Product> findAll();

}
