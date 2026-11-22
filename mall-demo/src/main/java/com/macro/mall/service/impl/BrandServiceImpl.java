package com.macro.mall.service.impl;

import com.macro.mall.mapper.BrandMapper;
import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

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
        if (brand == null) {
            log.info("brand is null");
            return;
        }

        if (brandMapper.insertBrand(brand) > 0) {
            log.info("save brand success");
        } else {
            log.info("save brand failure");
        }
    }

    public List<Brand> getBrandsByName(String name) {
        return brandMapper.selectAllByName(name);
    }

    public int updateBrand(Brand brand) {
        return brandMapper.update(brand);
    }

    public int deleteBrand(Long id) {
        return brandMapper.deleteBrand(id);
    }

}
