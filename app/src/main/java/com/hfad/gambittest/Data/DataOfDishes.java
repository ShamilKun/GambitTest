package com.hfad.gambittest.Data;
import com.google.gson.annotations.SerializedName;

public class DataOfDishes {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image_app;
    @SerializedName("price")
    private String price;
    @SerializedName("description")
    private String description;

    private int quantity;

    private boolean isFavorites = false;

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int item;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void enlarge() {
        item++;
    }

    public void reduce() {
        item--;
    }

    public String getImage_app() {
        return image_app;
    }

    public void setImage_app(String image_app) {
        this.image_app = image_app;
    }

    @SerializedName("new")
    private Boolean newDishes;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
