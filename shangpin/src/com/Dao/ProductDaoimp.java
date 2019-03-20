package com.Dao;

import com.Entity.Product;
import com.Entity.ProductType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
@Repository
public class ProductDaoimp implements ProductDao{
    @Resource
    JdbcTemplate template;

    @Resource
    ProductTypeDaoimp typeDao;

    @Override
    public void insertPro(Product pro) {
        String sql="INSERT into product(name,price,pid) value(?,?,?)";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println(""+ update);

    }

    @Override
    public void updatePro(Product pro) {
        String sql="update product set name=?,price=?,pid=? where id=?";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId(),pro.getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("updatePro return :"+ update);

    }

    @Override
    public void deletePro(int id) {
        //sql
        String sql="delete from product where id = ?";
        Object[] args={id};
        //执行
        int update = template.update(sql, args);
        System.out.println("deletePro return :"+ update);
    }

    @Override
    public Product selectById(int id) {
        String sql="select * from product where id = ? ";
        Object[] args={id};
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        Product productEntity = template.queryForObject(sql, args, rowMapper);
        return productEntity;
    }


    @Override
    public List<Product> findByName(String name) {

        //sql
        String sql="select * from product where name like ? ";
        Object[] args={"%"+name+"%"};
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId1 = typeDao.findById(pid);
                pro.setProductType(byId1);
                return pro;
            }
        };
        //执行查询
        List<Product>  list = template.query(sql, args, rowMapper);
        return list;
    }

    @Override
    public List<Product> findAll() {
        String sql="select * from product ";
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        List<Product>  list = template.query(sql, rowMapper);
        return list;
    }
}
