package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }

    public boolean add(int amount){
        if(amount >= 0 && quantity + amount > quantity){
            quantity += amount;
            return true;
        }else
            return false;
    }

    public boolean remove(int amount){
        if(amount >= 0 && quantity >= amount){
            quantity -= amount;
            return false;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        return quantity <= 0;
    }
}
