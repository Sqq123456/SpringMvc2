package com.Service;

import com.Entity.ProductType;

import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
public interface ProductTypeService {
    void addPro(ProductType pro);

    void updatePro(ProductType pro);

    void deletePro(int id);

    ProductType findById(int id);

    List<ProductType> findAll();
}
