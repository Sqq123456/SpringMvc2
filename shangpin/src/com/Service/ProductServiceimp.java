package com.Service;

import com.Dao.ProductDaoimp;
import com.Entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
@Service
public class ProductServiceimp implements ProductService{
    @Resource
    ProductDaoimp dao;
    @Override
    public void addPro(Product pro) {
      dao.insertPro(pro);
    }

    @Override
    public void updatePro(Product pro) {
        dao.updatePro(pro);

    }

    @Override
    public void deletePro(int id) {
        dao.deletePro(id);

    }

    @Override
    public Product findById(int id) {
        return dao.selectById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }
}
