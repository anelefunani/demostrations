package za.co.code.caloriescounting.service.helper.impl;

import za.co.code.caloriescounting.domain.Calorie;

import java.util.List;

public class SumUpItems {

    public int sumCalories(List<Calorie> calories) {
        return calories.stream()
                .map(Calorie::getAmount)
                .reduce(0, Integer::sum);
    }
}
