package com.salbiyath.springmvcdemo.service;

import com.salbiyath.springmvcdemo.entity.Product;
import com.salbiyath.springmvcdemo.util.RandomNumber;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private static final List<Product> products = new ArrayList<Product>(){
        {
           add(new Product(RandomNumber.getRandom(1000, 9999), "Sunlight", 2000, 100));
           add(new Product(RandomNumber.getRandom(1000, 9999), "Mama Lime", 2000, 200));
           add(new Product(RandomNumber.getRandom(1000, 9999), "Lifeboy", 5000, 50));
           add(new Product(RandomNumber.getRandom(1000, 9999), "Nivea Men", 24000, 10));
           add(new Product(RandomNumber.getRandom(1000, 9999), "Rexona", 16000, 20));
        }
    };

    public List<Product> findAll(){
        return products;
    }

    public Optional<Product> find(Long id){
        return products.stream().filter(product -> Objects.equals(product.getId(), id)).findFirst();
    }


    public void add(Product product){
        product.setId(RandomNumber.getRandom(1000, 9999));
        products.add(product);
    }

    public void delete(long id){
        products.removeIf(product -> product.getId() == id);
    }

    public void update(Product product) {
        delete(product.getId());
        products.add(product);
    }
}
