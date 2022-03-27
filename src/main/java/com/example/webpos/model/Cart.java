package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cart {

    private Map<Product, Integer> items = new HashMap();

    public boolean addItem(Product product, int amount) {
        if(amount < 0) return false;
        int amountCart = items.getOrDefault(product, 0);

        try{
            items.put(product, Math.addExact(amountCart, amount));
            return true;
        }catch(ArithmeticException e){
            return false;
        }
    }

    public boolean removeItem(Product product, int amount){
        if(amount < 0) return false;
        int amountCart = items.getOrDefault(product, 0);
        int newAmount = amountCart - amount;
        if(newAmount > 0){
            items.put(product, newAmount);
            return true;
        }else if(newAmount == 0){
            items.remove(product);
            return true;
        }else{
            return false;
        }

    }

    public boolean empty(){
        items.clear();
        return true;
    }

    public double total(){
        double total = 0;


        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    public boolean isEmtpy(){
        return items.isEmpty();
    }
    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            stringBuilder.append(entry.getKey()).append('\t').append(entry.getValue()).append('\n');
            total += entry.getValue() * entry.getKey().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
