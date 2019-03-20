package com.Service;

import com.Dao.ProductDaoimp;
import com.Dao.ProductTypeDao;
import com.Entity.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
@Service
public class ProuductTypeServiceimp implements ProductTypeService{
    @Resource
    ProductTypeDao typeDao;
    @Override
    public void addPro(ProductType pro) {
        typeDao.insertPro(pro);

    }

    @Override
    public void updatePro(ProductType pro) {
        typeDao.updatePro(pro);
    }

    @Override
    public void deletePro(int id) {
        typeDao.deletePro(id);

    }

    @Override
    public ProductType findById(int id) {
        return typeDao.findById(id);
    }

    @Override
    public List<ProductType> findAll() {

        return typeDao.findAll();
    }
}
