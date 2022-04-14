package com.CITB408.Kontrolno1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Item {
    private final String inventoryNumber;
    private String name;
    private LocalDate expirationDate;
    private double price;
    private AgeGroup ageGroup;

    public Item(String inventoryNumber, String name, LocalDate expirationDate, double price, AgeGroup ageGroup) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.expirationDate = expirationDate;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public Item(String inventoryNumber, String name, double price, AgeGroup ageGroup) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public boolean isSuitableForChildren (){
        if (getAgeGroup() == AgeGroup.CHILDREN) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isTheItemExpired (){
        if (getExpirationDate().isAfter(LocalDate.now())) {
            return false;
        }
        else {
            return true;
        }
    }

    public long daysUntilExpirationDate () {
        long daysUntilExpirationDate = ChronoUnit.DAYS.between(LocalDate.now(), getExpirationDate());
        return  daysUntilExpirationDate;
    }

    public double finalPrice (){
        double finalPrice = getPrice();
        if (daysUntilExpirationDate() < 30) {
            finalPrice = getPrice() - (20/100) * getPrice();
        }
        return finalPrice;
    }

}
