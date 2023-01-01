package com.example.designpage;

public class ItemsModel {
    private String foodNames;
    private int pic;

    public ItemsModel(String foodNames, int pic) {
        this.foodNames = foodNames;
        this.pic = pic;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
