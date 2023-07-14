package za.co.code.caloriescounting.service.helper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;

import java.util.ArrayList;
import java.util.List;

class SumUpTotalsComplexTest {

    private ISumUpTotals sumUpTotals;

    @BeforeEach
    void setUp() {
        sumUpTotals = new SumUpTotalsComplex();
    }

    @Test
    void sumTotals() {
        List<Calorie> calories = new ArrayList<>();
        // Should only sum up the top three
        calories.add(new Calorie(900)); // Should be ignored...
        calories.add(new Calorie(1000));
        calories.add(new Calorie(2000));
        calories.add(new Calorie(3000));
        calories.add(new Calorie(150)); // Should be ignored...

        int total = sumUpTotals.sumUpTotals(calories);

        Assertions.assertEquals(6000, total);
    }
}