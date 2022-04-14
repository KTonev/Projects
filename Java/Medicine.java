package com.CITB408.Kontrolno1;

public class Medicine extends Item{
    private IsPaidByNHIF isPaidByNHIF;
    private static double discountPercent;

    public Medicine(String inventoryNumber, String name, double price, AgeGroup ageGroup) {
        super(inventoryNumber, name, price, ageGroup);
    }

    public void setIsPaidByNHIF(IsPaidByNHIF isPaidByNHIF) {
        this.isPaidByNHIF = isPaidByNHIF;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public IsPaidByNHIF getIsPaidByNHIF() {
        return isPaidByNHIF;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void increasePercent (double increaseWith) {
        this.discountPercent = getDiscountPercent() + increaseWith;
    }

    public void decreasePercent (double decreaseWith) {
        this.discountPercent = getDiscountPercent() - decreaseWith;
    }

    public double totalPrice () {
        double totalPrice = 0;
        if (getIsPaidByNHIF() == IsPaidByNHIF.PAID_BY_NHIF) {
            totalPrice = getPrice() - ((getDiscountPercent() / 100) * getPrice());
        }
        else {
            totalPrice = getPrice();
        }
        return totalPrice;
    }

    public void cheaperMedicine (Medicine medicine1, Medicine medicine2) {
        if (medicine1.totalPrice() < medicine2.totalPrice()) {
            System.out.println(medicine1);
        }
        else {
            System.out.println(medicine2);
        }
    }
}
