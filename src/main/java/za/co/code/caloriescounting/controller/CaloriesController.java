package za.co.code.caloriescounting.controller;

import za.co.code.caloriescounting.service.CaloriesService;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;
import za.co.code.caloriescounting.service.impl.CaloriesServiceImpl;

public class CaloriesController {

    private final CaloriesService caloriesService;

    public CaloriesController(String fileLocation, ISumUpTotals sumUpTotals) {
        this.caloriesService = new CaloriesServiceImpl(fileLocation, sumUpTotals);
    }
    public int getHighestCalories() {
        return caloriesService.getHighestCalories();
    }
}
