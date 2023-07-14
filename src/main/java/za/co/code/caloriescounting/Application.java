package za.co.code.caloriescounting;

import za.co.code.caloriescounting.controller.CaloriesController;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsComplex;
import za.co.code.caloriescounting.service.helper.impl.SumUpTotalsSimple;

public class Application {

    private static final String FILE_LOCATION = "src/main/resources/calories.txt";

    public static void main(String[] args) {
        day1(new SumUpTotalsSimple());
        day2(new SumUpTotalsComplex());
    }

    private static void day1(ISumUpTotals sumUpTotals) {
        System.out.println("Highest calories simple: " + getController(sumUpTotals).getHighestCalories());
    }

    private static void day2(ISumUpTotals sumUpTotals) {
        System.out.println("Highest calories complex: " + getController(sumUpTotals).getHighestCalories());
    }

    private static CaloriesController getController(ISumUpTotals sumUpTotals) {
        return new CaloriesController(FILE_LOCATION, sumUpTotals);
    }
}
