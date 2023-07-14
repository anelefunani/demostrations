package za.co.code.caloriescounting.dao.impl;

import za.co.code.caloriescounting.dao.CaloriesDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaloriesDaoImpl implements CaloriesDao {

    private final String fileLocation;

    public CaloriesDaoImpl(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public byte[] getCalories() {
        try {
            return Files.readAllBytes(Paths.get(fileLocation));
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong, we could read the file at location: " + fileLocation);
        }
    }
}
