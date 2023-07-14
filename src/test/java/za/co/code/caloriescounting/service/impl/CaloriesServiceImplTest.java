package za.co.code.caloriescounting.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.service.CaloriesService;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsComplex;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsSimple;

class CaloriesServiceImplTest {

    private static final String FILE_LOCATION = "src/test/resources/calories.txt";

    private CaloriesService caloriesService;

    @Test
    void getHighestCaloriesSimple() {
        caloriesService = new CaloriesServiceImpl(FILE_LOCATION, new SumUpTotalsSimple());
        int highestCalories = caloriesService.getHighestCalories();
        Assertions.assertEquals(24000, highestCalories);
    }

    @Test
    void getHighestCaloriesComples() {
        caloriesService = new CaloriesServiceImpl(FILE_LOCATION, new SumUpTotalsComplex());
        int highestCalories = caloriesService.getHighestCalories();
        Assertions.assertEquals(45000, highestCalories);
    }
}