package za.co.code.caloriescounting.service.helper;

import za.co.code.caloriescounting.domain.Calorie;

import java.util.List;

public interface ISumUpTotals {

    int sumUpTotals(List<Calorie> calories);
}
