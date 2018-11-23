package com.springboot.sell.repository;


import com.springboot.sell.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest() {

        ProductCategory category = new ProductCategory();
        category.setCategoryType(89);
        category.setCategoryName("烤肉店");
        repository.save(category);
    }
}