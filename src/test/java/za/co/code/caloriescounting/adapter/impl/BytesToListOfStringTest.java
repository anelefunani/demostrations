package za.co.code.caloriescounting.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import za.co.code.caloriescounting.adapter.Adapter;
import za.co.code.caloriescounting.dao.CaloriesDao;
import za.co.code.caloriescounting.dao.impl.CaloriesDaoImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class BytesToListOfStringTest {

    private Adapter<List<String>, byte[]> bytesToListOfString;

    @Mock
    private CaloriesDao caloriesDao;

    @BeforeEach
    void setUp() {
        bytesToListOfString = new BytesToListOfString();
        caloriesDao = Mockito.mock(CaloriesDaoImpl.class);

        Mockito.when(caloriesDao.getCalories())
                .thenReturn(getFileContents());
    }

    @Test
    void adapt() {
        List<String> fileLines = bytesToListOfString.adapt(caloriesDao.getCalories());
        Assertions.assertEquals(14, fileLines.size());
    }

    private byte[] getFileContents() {
        try {
            return Files.readAllBytes(Paths.get("src/test/resources/calories.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalStateException("Could not read file");
        }
    }
}