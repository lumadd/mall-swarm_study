package com.macro.mall.service;

import com.macro.mall.model.Brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BrandService {

    List<Brand> getBrands();

    Brand getBrand(Long id);

    void save(Brand brand);

    List<Brand> getBrandsByName(String name);
}
