package com.macro.mall.service.impl;

import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    private static final HashMap<Long, Brand> map = new HashMap<>();

    public List<Brand> getBrands() {
        if (map.isEmpty()) {
            return new ArrayList<>(0);
        }
        List<Brand> brands = new ArrayList<>();
        map.keySet().forEach(key -> {
            brands.add(map.get(key));
        });
        return brands;
    }

    public Brand getBrand(Long id) {
        if (id == null) {
            log.info("id is null");
            return null;
        }
        if (map.containsKey(id)) {
            return map.get(id);
        }
        return null;
    }


    public void save(Brand brand) {
        if (brand == null || brand.getId() == null) {
            log.info("brand is null");
            return;
        }

        map.put(brand.getId(), brand);
    }

    public List<Brand> getBrandsByName(String name) {
        List<Brand> brands = new ArrayList<>(0);
        map.keySet().forEach(key -> {
            Brand brand = map.get(key);
            if (brand.getName().contains(name)) {
                brands.add(brand);
            }
        });
        return brands;
    }

}
