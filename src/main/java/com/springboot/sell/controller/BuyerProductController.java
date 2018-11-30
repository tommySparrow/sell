package com.springboot.sell.controller;

import com.springboot.sell.model.ProductCategory;
import com.springboot.sell.model.ProductInfo;
import com.springboot.sell.service.CategoryService;
import com.springboot.sell.service.ProductService;
import com.springboot.sell.utils.ResultVOUtil;
import com.springboot.sell.vo.ProductInfoVO;
import com.springboot.sell.vo.ProductVO;
import com.springboot.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/11/30
 * @ Description：买家商品
 * @ throws
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO list(){

        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询所有上线的类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> (e.getCategoryType()))
                .collect(Collectors.toList());
        //2. 查询类目(一次性查询)
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        ArrayList<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory:productCategoryList){

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType( productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
