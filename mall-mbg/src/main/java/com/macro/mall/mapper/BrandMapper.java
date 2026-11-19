package com.macro.mall.mapper;

import com.macro.mall.model.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    List<Brand> selectAllByName(String name);

}
