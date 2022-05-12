package com.CITB408.Kontrolno1;

import java.util.ArrayList;

public class Pharmacy {
    private String name;
    private ArrayList soldItems;

    public Pharmacy(String name) {
        this.name = name;
        soldItems = new ArrayList();
    }

    public void addItem (Medicine medicine) {
        if (!soldItems.contains(medicine)) {
            soldItems.add(medicine);
        }
    }

    public void removeItem (Medicine medicine) {
        soldItems.remove(medicine);
    }

    public double income() {
        for (Object medicine : soldItems) {

        }
        return 0;
    }
}
