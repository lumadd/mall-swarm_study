package com.macro.mall.controller;

import com.macro.mall.dto.CreateBrandRequest;
import com.macro.mall.model.Brand;
import com.macro.mall.service.BrandService;
import jakarta.validation.constraints.Null;
import org.apache.commons.lang3.StringUtils;
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
        if (request == null || StringUtils.isBlank(request.getName())) {
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
        if (brand == null || brand.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        if (request == null || StringUtils.isBlank(request.getName())) {
            return ResponseEntity.badRequest().build();
        }
        brand.setName(request.getName());
        if (brandService.updateBrand(brand) == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(brand);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        Brand brand = brandService.getBrand(id);
        if (brand == null || brand.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        if (brandService.deleteBrand(id) == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(null);
    }
}
