package com.example.demo.service;

import java.util.List;

import com.example.demo.commands.ProductForm;
import com.example.demo.model.Product;

public interface ProductService {
	List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);

    void sendProductMessage(String id);

}
