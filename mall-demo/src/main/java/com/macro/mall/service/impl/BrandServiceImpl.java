package com.macro.mall.service.impl;

import com.macro.mall.mapper.BrandMapper;
import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    private static final HashMap<Long, Brand> map = new HashMap<>();

    public List<Brand> getBrands() {
        return brandMapper.selectAll();
    }

    public Brand getBrand(Long id) {
        if (id == null) {
            log.info("id is null");
            return null;
        }
        return brandMapper.selectByPrimaryKey(id);
    }


    public void save(Brand brand) {
        if (brand == null || brand.getId() == null) {
            log.info("brand is null");
            return;
        }

        map.put(brand.getId(), brand);
    }

    public List<Brand> getBrandsByName(String name) {
        return brandMapper.selectAllByName(name);
    }

}
