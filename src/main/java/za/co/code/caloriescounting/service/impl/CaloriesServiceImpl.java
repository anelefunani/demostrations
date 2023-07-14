package za.co.code.caloriescounting.service.impl;

import za.co.code.caloriescounting.adapter.Adapter;
import za.co.code.caloriescounting.adapter.impl.BytesToListOfString;
import za.co.code.caloriescounting.adapter.impl.ListOfStringToElves;
import za.co.code.caloriescounting.dao.CaloriesDao;
import za.co.code.caloriescounting.dao.impl.CaloriesDaoImpl;
import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.domain.Elf;
import za.co.code.caloriescounting.domain.Pack;
import za.co.code.caloriescounting.service.CaloriesService;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;
import za.co.code.caloriescounting.service.helper.impl.SumUpItems;

import java.util.ArrayList;
import java.util.List;

public class CaloriesServiceImpl implements CaloriesService {

    private final CaloriesDao caloriesDao;

    private final Adapter<List<String>, byte[]> bytesToStringList;

    private final Adapter<List<Elf>, List<String>> listToElves;

    private final SumUpItems sumCalories;

    private final ISumUpTotals sumUpTotals;

    public CaloriesServiceImpl(String fileLocation, ISumUpTotals sumUpTotals) {
        caloriesDao = new CaloriesDaoImpl(fileLocation);
        bytesToStringList = new BytesToListOfString();
        listToElves = new ListOfStringToElves();
        sumCalories = new SumUpItems();
        this.sumUpTotals = sumUpTotals;
    }

    @Override
    public int getHighestCalories() {

        List<Elf> elves = listToElves.adapt(bytesToStringList.adapt(caloriesDao.getCalories()));

        List<Calorie> totals = new ArrayList<>();
        for (Elf elf : elves) {
            Pack pack = elf.getPack();
            List<Calorie> calories = new ArrayList<>();
            pack.getItems().forEach(item -> calories.add(item.getCalorie()));
            totals.add(new Calorie(sumCalories.sumCalories(calories)));
        }

        return sumUpTotals.sumUpTotals(totals);
    }
}
