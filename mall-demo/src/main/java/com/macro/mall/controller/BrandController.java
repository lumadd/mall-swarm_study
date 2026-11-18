package com.macro.mall.controller;

import com.macro.mall.dto.CreateBrandRequest;
import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("/listAll")
    public List<Brand> listBrand(@RequestParam(required = false) String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return brandService.getBrands();
        }
        return brandService.getBrandsByName(keyword);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable() Long id) {
        Brand brand = brandService.getBrand(id);
        if (brand == null || brand.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brand);
    }

    @PostMapping("/create")
    public ResponseEntity<Brand> createBrand(@RequestBody CreateBrandRequest request) {
        Long uuid = UUID.randomUUID().getMostSignificantBits();
        Brand brand = new Brand();
        brand.setId(uuid);
        brand.setName(request.getName());
        brandService.save(brand);
        return ResponseEntity.ok(brand);
    }

}
