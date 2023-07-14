package za.co.code.caloriescounting.service.helper.impl;

import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;

import java.util.List;
import java.util.stream.Collectors;

public class SumUpTotalsComplex implements ISumUpTotals {
    @Override
    public int sumUpTotals(List<Calorie> calories) {
        if (calories.size() < 3)
            throw new IllegalStateException("Not enough calories to get to three...");
        return calories.stream()
                .sorted()
                .collect(Collectors.toList())
                .subList(0, 3).stream()
                .map(Calorie::getAmount)
                .reduce(0, Integer::sum);

    }
}
