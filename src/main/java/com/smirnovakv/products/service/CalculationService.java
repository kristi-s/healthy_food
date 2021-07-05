package com.smirnovakv.products.service;

import com.smirnovakv.products.dao.ProductsDao;
import com.smirnovakv.products.dto.CategoryContainer;
import com.smirnovakv.products.dto.PeopleDto;
import com.smirnovakv.products.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {

    private final ProductsDao productsDao;

    @Autowired
    CalculationService(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    public List<CategoryContainer> getProductsPerWeek(PeopleDto peopleDto) {
        List<CategoryContainer> containers = getProductsPerDay(peopleDto);
        containers.replaceAll(container -> {
            container.setGrams(container.getGrams() * 7);
            return container;
        });

        return containers;
    }

    private static Integer countGramsPerPeople(PeopleDto peopleDto, ProductCategory category) {
        return peopleDto.getWoman() * category.getGramsPerWoman() +
                        peopleDto.getMan() * category.getGramsPerMan() +
                        peopleDto.getChild() * category.getGramsPerChild();
    }

    private CategoryContainer createContainerByCategory(PeopleDto peopleDto, ProductCategory category) {
        return new CategoryContainer(category,
                countGramsPerPeople(peopleDto, category),
                productsDao.getProductsByCategory(category));
    }

    public List<CategoryContainer> getProductsPerDay(PeopleDto peopleDto) {
        List<CategoryContainer> containers = new ArrayList<>();
        for (ProductCategory category : ProductCategory.values()) {
            containers.add(createContainerByCategory(peopleDto, category));
        }
        return containers;
    }
}
