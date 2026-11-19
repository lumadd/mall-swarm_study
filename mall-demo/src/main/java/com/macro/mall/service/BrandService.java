package com.macro.mall.service;

import com.macro.mall.model.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getBrands();

    Brand getBrand(Long id);

    void save(Brand brand);

    List<Brand> getBrandsByName(String name);
}
