package com.engeto.shopping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private String owner;

    public ShoppingCart(String owner){
        this.owner = owner;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public List<Item> getAllItems() {
        return new ArrayList<Item>();  // vytvori kopii meho seznamu, neposkytne muj seznam
    }

    public void sortItems() {
        items.sort(Comparator.comparing(Item::getDescription)); // vytvori novou tridu komparator, ktery bude porovnavat dve polozky na zaklade popisu
    }

    @Override
    public String toString() {
        return "Kosik zakaznika "+owner +" polozky "+items;
    }
}
