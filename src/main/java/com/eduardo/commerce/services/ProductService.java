package com.eduardo.commerce.services;

import com.eduardo.commerce.dto.ProductDTO;
import com.eduardo.commerce.entities.Product;
import com.eduardo.commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> product = repository.findById(id);
        Product result = product.get();
        ProductDTO dto = new ProductDTO(result);
        return dto;
    }

}
