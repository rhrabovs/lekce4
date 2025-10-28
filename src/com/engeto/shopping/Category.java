package com.engeto.shopping;

//vyctovy typ
public enum Category {
    FOOD("jidlo"),
    CONSUMABLES("spotrebni zbozi"),
    OTHERS("ostatni");

    /*
    ked ku kategoriam pridam zatvorky s ceskym popisom
    a pridam kod ktory je pod touto poznamkou, tak budem vypisovat na obrazovku cesky

    - musi sa pridat konstruktor
    - musi sa pridat metoda toString()
    - musi sa definovat promenna description

     */

    private String description;

    Category(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
