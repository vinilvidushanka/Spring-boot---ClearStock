package com.example.backend.entity;

import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, length = 255)
    private String imagePath;  // Store file path instead of binary data

    public Store() {
    }

    public Store(int id, String name, User owner, String description, Category category, double price, String imagePath) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
