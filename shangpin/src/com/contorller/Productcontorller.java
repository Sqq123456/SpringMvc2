package com.contorller;

import com.Entity.Product;
import com.Entity.ProductType;
import com.Service.ProductServiceimp;
import com.Service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/17 0017.
 */
@Controller
@RequestMapping("/selectAll")
public class Productcontorller {
    //产品Service
    @Resource
    ProductServiceimp ser;
    //类型Service
    @Resource
    ProductTypeService types;

    @RequestMapping("/test")
    public  String findAllProduct(Model model){
        //调用查询所有方法
        List<Product> prolist = ser.findAll();
        for (Product li:prolist
             ) {
            System.out.println(li.getName());
        }

        //将集合封装到model返回给页面
        model.addAttribute("Producto",new Product());
        model.addAttribute("prolist",prolist);
        return "My";
    }
    @RequestMapping("delete")
    public String delete(int id){
        ser.deletePro(id);
    System.out.println(id);
    return "forward:/selectAll/test.do";
    }

    @RequestMapping("insert1")
    public String insert1(Model model){
        List<ProductType> all = types.findAll();

        model.addAttribute("Producto",new Product());
        model.addAttribute("lx",all);

        return "insert";
    }
    @RequestMapping("insert2")
    public String insert2(Model model,Product Producto){
        ser.addPro(Producto);
        return "forward:/selectAll/test.do";
    }
    //模糊查询
    @RequestMapping("/selectname")
    public  String selectname(Model model,String name){
        //调用查询所有方法
        List<Product> prolist = ser.findByName(name);

        System.out.println(name);
        model.addAttribute("Producto",new Product());
        model.addAttribute("prolist",prolist);

        return "My";
    }
    //修改
    @RequestMapping("update")
    public String update(Model model,int id){
        Product byId = ser.findById(id);
        System.out.println(byId.getId()+byId.getName()+byId.getPrice()+byId.getProductType());

        List<ProductType> all = types.findAll();
        model.addAttribute("pro",byId);
        model.addAttribute("lx",all);

        return "update";
    }
    @RequestMapping("update2")
    public String update2(Model model,Product Producto){
        System.out.println(Producto.getId());
        System.out.println(Producto.getName());
        System.out.println(Producto.getPrice());
        System.out.println(Producto.getProductType().getId());
        ser.updatePro(Producto);


        return "forward:/selectAll/test.do";
    }


}
