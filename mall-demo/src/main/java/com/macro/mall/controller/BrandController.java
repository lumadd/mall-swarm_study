package com.macro.mall.controller;

import com.macro.mall.dto.CreateBrandRequest;
import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.Null;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    // 构造器注入
    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

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
        if (StringUtils.isEmpty(request.getName())) {
            return ResponseEntity.badRequest().build();
        }
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandService.save(brand);
        return ResponseEntity.ok(brand);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable() Long id, @RequestBody CreateBrandRequest request) {
        Brand brand = brandService.getBrand(id);
        if (brand == null || brand.getId() == null || StringUtils.isBlank(request.getName())) {
            return ResponseEntity.notFound().build();
        }
        brand.setName(request.getName());
        brandService.updateBrand(brand);
        return ResponseEntity.ok(brandService.getBrand(id));
    }

    public ResponseEntity<Null> deleteBrand(@PathVariable Long id) {
        Brand brand = brandService.getBrand(id);
        if (brand == null || brand.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        brandService.deleteBrand(id);
        return ResponseEntity.ok(null);
    }
}
