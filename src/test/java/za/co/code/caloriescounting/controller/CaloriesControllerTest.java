package za.co.code.caloriescounting.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsComplex;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsSimple;

class CaloriesControllerTest {

    private static final String FILE_LOCATION = "src/test/resources/calories.txt";

    private CaloriesController caloriesController;

    @Test
    void getHighestCaloriesSimple() {
        caloriesController = new CaloriesController(FILE_LOCATION, new SumUpTotalsSimple());
        int highestCalories = caloriesController.getHighestCalories();
        Assertions.assertEquals(24000, highestCalories);
    }

    @Test
    void getHighestCaloriesComplex() {
        caloriesController = new CaloriesController(FILE_LOCATION, new SumUpTotalsComplex());
        int highestCalories = caloriesController.getHighestCalories();
        Assertions.assertEquals(45000, highestCalories);
    }

}