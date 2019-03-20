package com.Dao;

import com.Entity.Product;
import com.Entity.ProductType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
@Repository
public class ProductTypeDaoimp implements ProductTypeDao{
    @Resource
    JdbcTemplate jdbcTemplate;


    @Override
    public void insertPro(ProductType pro) {

    }

    @Override
    public void updatePro(ProductType pro) {

    }

    @Override
    public void deletePro(int id) {

    }

    @Override
    public ProductType findById(int id) {
        String sql="select * from productType where id =? ";
        Object[] args={id};
        RowMapper<ProductType> rowMapper=new RowMapper<ProductType>() {
            @Override
            public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {

                    ProductType pro=new ProductType(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    );
                    return pro;
                }
        };
        ProductType productType = jdbcTemplate.queryForObject(sql, args, rowMapper);
        return productType;
    }

    @Override
    public List<ProductType> findAll() {
        String sql="select * from productType ";
        //rowMapper
        RowMapper<ProductType> rowMapper=new RowMapper<ProductType>() {
            @Override
            public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductType pro=new ProductType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return pro;
            }
        };
        //执行
        List<ProductType> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }
}
