package za.co.code.rockpaperscissors.dao.impl;

import za.co.code.rockpaperscissors.dao.RpsDao;

import java.nio.file.Files;
import java.nio.file.Paths;

public class RpsDaoImpl implements RpsDao {

    private final String fileLocation;

    public RpsDaoImpl(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public byte[] getInstructions() {

        try {
            return Files.readAllBytes(Paths.get(fileLocation));
        } catch (Exception ex) {
            throw new IllegalStateException("Something went wrong, we could not read file at: " + fileLocation);
        }
    }
}
