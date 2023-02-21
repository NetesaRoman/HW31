package com.example.hw31.service;

import com.example.hw31.dto.ProductDto;
import com.example.hw31.model.Product;
import com.example.hw31.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto addNewProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCost(productDto.getCost());
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public ProductDto findById(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No product"));

        return new ProductDto(product.getId(), product.getName(), product.getCost());
    }

    public List<ProductDto> findAll(){
        List<ProductDto> productDtos = new ArrayList<>();

        productRepository.findAll().forEach(p -> productDtos.add(new ProductDto(p.getId(), p.getName(), p.getCost())));
        return productDtos;
    }

}
