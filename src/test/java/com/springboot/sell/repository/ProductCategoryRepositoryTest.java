package com.springboot.sell.repository;


import com.springboot.sell.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest() {

        ProductCategory category = new ProductCategory();
//        category.setCategoryId(2);
        category.setCategoryType(90);
        category.setCategoryName("烧烤店");
        repository.save(category);
    }
    @Test
    public void listTest() {

        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> productCategorys = repository.findByCategoryIdIn(list);
        for (int i = 0; i < productCategorys.size(); i++) {
            System.out.println(productCategorys.get(i));
        }
    }
}