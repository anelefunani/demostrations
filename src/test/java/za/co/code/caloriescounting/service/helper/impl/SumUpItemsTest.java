package za.co.code.caloriescounting.service.helper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SumUpItemsTest {

    private SumUpItems sumUpItems;

    @BeforeEach
    void setUp() {
        sumUpItems = new SumUpItems();
    }

    @Test
    void sumUpItems() {

        List<Item> items = new ArrayList<>();
        items.add(new Item(new Calorie(1000)));
        items.add(new Item(new Calorie(2000)));
        items.add(new Item(new Calorie(3000)));

        int sum = sumUpItems.sumCalories(items.stream()
                .map(Item::getCalorie)
                .collect(Collectors.toList()));

        Assertions.assertEquals(6000, sum);
    }
}