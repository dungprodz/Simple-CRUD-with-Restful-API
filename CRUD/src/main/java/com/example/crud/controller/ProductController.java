package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getProduct(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id){
        return productService.findById(id);
    }
    @PutMapping  ("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product newProduct) {

        return productService.update(id,newProduct);
    }
    @DeleteMapping  ("/{id}")
    public void deleteProduct(@PathVariable("id") int id){
         productService.deleteById(id);
    }

    @PostMapping ("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //API sap xep product
    @GetMapping("/views")
    public List<Product> sort(@RequestParam("p") Optional<Integer> p){
        Sort sort = Sort.by("price").ascending();
        List<Product> allProducts = productService.findAll(sort);
        return allProducts;
    }
    //API phan trang product
    @GetMapping("/views/page")
    public Page<Product> paging(@RequestParam("p") Optional<Integer> p){
        Pageable pageable= PageRequest.of(p.orElse(0),4);
        Page<Product> allProducts = productService.findAll(pageable);
        return allProducts;
    }

}
