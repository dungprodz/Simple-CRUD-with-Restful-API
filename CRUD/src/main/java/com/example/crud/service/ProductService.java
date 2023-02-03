package com.example.crud.service;

import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllById(Iterable<Integer> integers) {
        return productRepository.findAllById(integers);
    }


    public Page<Product> findAll(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    public Product findById(Integer integer) {

        return productRepository.findById(integer).orElseThrow();
    }
    public Product update(int id, Product product) {
        Product newProduct= productRepository.findById(id).orElse(null);

        newProduct.setAvatar(product.getAvatar());
        newProduct.setPrice(product.getPrice());
        newProduct.setTitle(product.getTitle());
        newProduct.setDetails(product.getDetails());
        newProduct.setPriceSale(product.getPriceSale());
        newProduct.setShortDes(product.getShortDes());
        return productRepository.save(newProduct);
    }
    public void deleteById(Integer integer) {

        productRepository.deleteById(integer);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
