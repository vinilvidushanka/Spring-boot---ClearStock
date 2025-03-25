package com.example.backend.entity;

import jakarta.persistence.*;

import java.util.Arrays;
//@Entity
//public class Store {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User owner;
//
//    @Column(columnDefinition = "TEXT")
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;
//
//    @Column(nullable = false)
//    private double price;
//
//    @Column(nullable = false, length = 255)
//    private String imagePath;  // Store file path instead of binary data
//
//
//    public Store() {
//    }
//
//    public Store(int id, String name, User owner, String description, Category category, double price, String imagePath) {
//        this.id = id;
//        this.name = name;
//        this.owner = owner;
//        this.description = description;
//        this.category = category;
//        this.price = price;
//        this.imagePath = imagePath;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Store{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", owner=" + owner +
//                ", description='" + description + '\'' +
//                ", category=" + category +
//                ", price=" + price +
//                ", imagePath='" + imagePath + '\'' +
//                '}';
//    }
//
//    public String getImagePath() {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//}

@Entity
public class Store {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User owner;
//
//    @Column(columnDefinition = "TEXT")
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;
//
//    @Column(nullable = false)
//    private double price;
//
//    @Column(nullable = false, length = 255)
//    private String imagePath;  // Store file path instead of binary data
//    @Column(nullable = false, length = 255)
//    private byte[] imageData;
//
//    public Store() {
//    }
//
//    public Store(int id, String name, User owner, String description, Category category, double price, String imagePath, byte[] imageData) {
//        this.id = id;
//        this.name = name;
//        this.owner = owner;
//        this.description = description;
//        this.category = category;
//        this.price = price;
//        this.imagePath = imagePath;
//        this.imageData = imageData;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getImagePath() {
//        return imagePath;
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }
//
//    public byte[] getImageData() {
//        return imageData;
//    }
//
//    public void setImageData(byte[] imageData) {
//        this.imageData = imageData;
//    }
//
//    @Override
//    public String toString() {
//        return "Store{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", owner=" + owner +
//                ", description='" + description + '\'' +
//                ", category=" + category +
//                ", price=" + price +
//                ", imagePath='" + imagePath + '\'' +
//                ", imageData=" + Arrays.toString(imageData) +
//                '}';
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Use int for the ID

        private String name;
        private String description;
        private double price;
        private String imagePath;
        @Column(name = "category_id")
        private int categoryId; // Add this field
        @Column(name = "user_id")
        private int ownerId;
        private byte[] imageData; // Add this field to store image data

    public Store() {
    }

    public Store(int id, String name, String description, double price, String imagePath, int categoryId, int ownerId, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.categoryId = categoryId;
        this.ownerId = ownerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                ", categoryId=" + categoryId +
                ", ownerId=" + ownerId +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
}
