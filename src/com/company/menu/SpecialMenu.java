package com.company.menu;

import java.time.LocalDate;

public class SpecialMenu extends Menu {
    int discount = 0;

    public SpecialMenu(int id, String name, String description, LocalDate date_created, int discount){
        super(id, name, description, date_created);
        this.discount = discount;
    }

    public boolean isSpecialMenu(){
        return true;
    }

}
