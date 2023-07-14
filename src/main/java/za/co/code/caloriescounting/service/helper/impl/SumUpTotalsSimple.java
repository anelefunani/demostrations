package za.co.code.caloriescounting.service.helper.impl;

import za.co.code.caloriescounting.domain.Calorie;
import za.co.code.caloriescounting.service.helper.ISumUpTotals;

import java.util.List;
import java.util.stream.Collectors;

public class SumUpTotalsSimple implements ISumUpTotals {

    @Override
    public int sumUpTotals(List<Calorie> calories) {
        return calories.stream().sorted()
                .map(Calorie::getAmount)
                .collect(Collectors.toList()).get(0);
    }
}
