package com.Service;

import com.Entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
public interface ProductService {

    void addPro(Product pro);

    void updatePro(Product pro);

    void deletePro(int id);

    Product findById(int id);

    List<Product> findByName(String name);

    List<Product> findAll();
}
