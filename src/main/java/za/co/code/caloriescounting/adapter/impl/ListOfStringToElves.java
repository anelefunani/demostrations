package za.co.code.caloriescounting.adapter.impl;

import za.co.code.caloriescounting.adapter.Adapter;
import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.domain.Elf;
import za.co.code.caloriescounting.domain.Item;
import za.co.code.caloriescounting.domain.Pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOfStringToElves implements Adapter<List<Elf>, List<String>> {

    @Override
    public List<Elf> adapt(List<String> calories) {
        List<Elf> elves = new ArrayList<>();

        Iterator<String> itr = calories.iterator();
        List<Item> items = new ArrayList<>();
        while (itr.hasNext()) {
            String current = itr.next();
            if (current.isEmpty()) {
                Pack pack = new Pack();
                pack.setItems(items);
                elves.add(new Elf(pack));
                items = new ArrayList<>();
            } else {
                Calorie calorie = new Calorie(Integer.parseInt(current));
                Item item = new Item(calorie);
                items.add(item);
            }
        }

        elves.add(new Elf(new Pack(items)));

        return elves;
    }
}
