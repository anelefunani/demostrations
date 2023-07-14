package za.co.code.caloriescounting.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.caloriescounting.dao.CaloriesDao;

class CaloriesDaoImplTest {

    private static final String FILE_LOCATION = "src/test/resources/calories.txt";

    private CaloriesDao caloriesDao;

    @BeforeEach
    void setUp() {
        caloriesDao = new CaloriesDaoImpl(FILE_LOCATION);
    }

    @Test
    void getCalories() {
        byte[] calories = caloriesDao.getCalories();
        Assertions.assertNotNull(calories);
        Assertions.assertEquals(67, calories.length);
    }

    @Test
    void should_fail_if_fileLocation_does_not_exist() {
        caloriesDao = new CaloriesDaoImpl("src/test/resources/idontexist.txt");
        Assertions.assertThrows(IllegalStateException.class, () -> caloriesDao.getCalories());
    }

}
