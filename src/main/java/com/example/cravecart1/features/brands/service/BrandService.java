package com.example.cravecart1.features.brands.service;

import com.example.cravecart1.features.brands.dto.BrandRequest;
import com.example.cravecart1.features.brands.entity.Brand;
import com.example.cravecart1.features.brands.repo.BrandRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand createBrand(BrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setDescription(request.getDescription());
        return brandRepository.save(brand);
    }

    public List<Brand> listBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrand(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found"));
    }

    public Brand updateBrand(Long id, BrandRequest request) {
        Brand brand = getBrand(id);
        brand.setName(request.getName());
        brand.setDescription(request.getDescription());
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        Brand brand = getBrand(id);
        brandRepository.delete(brand);
    }
}
