package com.example.backend.dto;

import java.util.Arrays;

public class StoreDTO {
    private int id;
    private String name;
    private String ownerEmail;
    private String description;
    private String categoryName;
    private int categoryId;
    private double price;
    private int ownerId;
    private String imagePath;
    private byte[] imageData;

    public StoreDTO() {}

    public StoreDTO(int id, String name, String ownerEmail, String description, String categoryName, int categoryId, double price, int ownerId, String imagePath, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.ownerEmail = ownerEmail;
        this.description = description;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.price = price;
        this.ownerId = ownerId;
        this.imagePath = imagePath;
        this.imageData = imageData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", ownerId=" + ownerId +
                ", imagePath='" + imagePath + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
}
