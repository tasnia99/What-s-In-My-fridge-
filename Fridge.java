package com.example.designpage;

public class Fridge {
    String ItemName;
    String qty;
    String exp;

    public Fridge(String itemName, String qty, String exp) {
        ItemName = itemName;
        this.qty = qty;
        this.exp = exp;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getQty() {
        return qty;
    }

    public String getExp() {
        return exp;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
