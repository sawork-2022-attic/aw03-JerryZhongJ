package com.example.webpos.db;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PosInMemoryDB implements PosDB {
    private List<Product> products = new ArrayList<>();

    private Cart cart;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private PosInMemoryDB() {
        this.products.add(new Product("PD1", "iPhone 13", 5999, "1.jpg"));
        this.products.add(new Product("PD2", "iPhone 13 Pro Max", 9799, "2.jpg"));
        this.products.add(new Product("PD3", "2021 款 iPad", 2499, "3.jpg"));
        this.products.add(new Product("PD4", "iPad Pro 12.9 英寸", 8499, "4.jpg"));
        this.products.add(new Product("PD5", "新款 MacBook Air", 7999, "5.jpg"));
        this.products.add(new Product("PD6", "新款 MacBook Pro 13 英寸", 9999, "6.jpg"));
        this.products.add(new Product("PD7", "Apple Watch Series 7", 2999, "7.jpg"));
        this.products.add(new Product("PD8", "AirPods", 1176, "8.jpg"));

    }

}
