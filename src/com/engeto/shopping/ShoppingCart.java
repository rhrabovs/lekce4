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

    /*
    public Item getItem(int index) {
        return items.get(index);
    }

    public List<Item> getAllItems() {
        return new ArrayList<Item>();  // vytvori kopii meho seznamu, neposkytne muj seznam
    }
    */
    public void sortItems() {
        items.sort(Comparator.comparing(Item::getDescription)); // vytvori novou tridu ktera bude potomkem komparatoru,
                                                                // ktery bude porovnavat dve polozky na zaklade popisu
                                                                // kdyby jsme tam nechali jen zapis items.sort(),
                                                                // tak by nevedel podle ceho ma tridit
        // zapis getDescription znamena, ze polozky bude porovnavat na zaklade popisu
    }

    public void sortItems(Comparator<Item> comparator){
        items.sort(comparator);
        // muzeme ten Comparator dat do metody primo
        // budu mit metodu sort, kde muzu jako parametr uvest primo comparator
    }

    @Override
    public String toString() {
        return "Kosik zakaznika "+owner +":\n"+items;
    }
}
