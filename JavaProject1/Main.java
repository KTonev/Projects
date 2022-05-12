package com.CITB408.Kontrolno1;

import java.time.LocalDate;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        Medicine medicine1 = new Medicine("ABCA112", "Analgin", 52, AgeGroup.CHILDREN);

        System.out.println("Is suitable for children? " + medicine1.isSuitableForChildren());

        medicine1.setExpirationDate(LocalDate.of(2022,10,20));

        System.out.println("Is the item expired? " + medicine1.isTheItemExpired());

        System.out.println("Days until expiration: " + medicine1.daysUntilExpirationDate());

        System.out.println("Item's final price is: " + medicine1.finalPrice());

        medicine1.setIsPaidByNHIF(IsPaidByNHIF.PAID_BY_NHIF);
        medicine1.setDiscountPercent(25);

        medicine1.increasePercent(5);
        System.out.println("Percent after increase: " + medicine1.getDiscountPercent());

        medicine1.decreasePercent(10);
        System.out.println(("Percent after decrease " + medicine1.getDiscountPercent()));

        Medicine medicine2 = new Medicine("adffa22", "Aspirin", 40, AgeGroup.ADULTS);
        medicine2.setExpirationDate(LocalDate.of(2022,4,30));
        medicine2.setIsPaidByNHIF(IsPaidByNHIF.PAID_BY_NHIF);

        System.out.println("medicine2 total price" + medicine2.totalPrice());
        

    }
}
