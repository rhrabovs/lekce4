package com.engeto.shopping;



import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item {
    private String description;
    private BigDecimal price;
    private LocalDateTime reservationTime;
    private boolean isOnStock;
    private int quantity;
    private Category category;

    // konstuktory
    public Item(String description, BigDecimal price, LocalDateTime reservationTime,
                boolean isOnStock, int quantity,Category category) throws ShoppingCartException {
        this.description = description;
        //this.price = price;
        setPrice(price);
        this.reservationTime = reservationTime;
        this.isOnStock = isOnStock;
        this.quantity = quantity;
        this.category = category;
    }

    public Item(String description, BigDecimal price) throws  ShoppingCartException {
        this(description,price,LocalDateTime.now(),true,1,Category.FOOD);
    }

    //pristupove metody
    public String getDescription() {
        return description;
    }

    /*
    public void setDescription(String description) {
        this.description = description;
    }
    */
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws ShoppingCartException {
        if (BigDecimal.ZERO.compareTo(price) > 0) {
            throw new ShoppingCartException("Cena nesmi byt zaporna! Zadano: "+price);
        }
        if (price == null) {
            throw new NullPointerException("Cena nesmi byt null!");
        }
        this.price = price;
    }
    /*
    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public boolean isIsOnStock() {
        return isOnStock;
    }

    public void setIsonStock(boolean isOnStock) {
        this.isOnStock = isOnStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    */
    public Category getCategory() {
        return category;
    }
    /*
    public void setCategory(Category category) {
        this.category = category;
    }
    */
    @Override
    public String toString() {
        return description + ": " + " (" + price+" Kc)";
    }
}
