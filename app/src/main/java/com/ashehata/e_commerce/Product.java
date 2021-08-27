
package com.ashehata.e_commerce;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Product {

    @Expose
    private String category;
    @Expose
    private String description;
    @Expose
    private Long id;
    @Expose
    private String image;
    @Expose
    private Double price;
    @Expose
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
