package za.co.code.caloriescounting.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.adapter.Adapter;
import za.co.code.caloriescounting.dao.CaloriesDao;
import za.co.code.caloriescounting.dao.impl.CaloriesDaoImpl;
import za.co.code.caloriescounting.domain.Elf;

import java.util.List;

class ListOfStringToElvesTest {

    private static final String FILE_LOCATION = "src/test/resources/calories.txt";

    private Adapter<List<Elf>, List<String>> listToElves;

    private Adapter<List<String>, byte[]> bytesToListOfString;

    private CaloriesDao caloriesDao;

    @BeforeEach
    void setUp() {
        listToElves = new ListOfStringToElves();
        bytesToListOfString = new BytesToListOfString();
        caloriesDao = new CaloriesDaoImpl(FILE_LOCATION);
    }

    @Test
    void adapt() {
        List<Elf> elves = listToElves.adapt(bytesToListOfString.adapt(caloriesDao.getCalories()));
        Assertions.assertNotNull(elves);
        Assertions.assertEquals(5, elves.size());
    }
}