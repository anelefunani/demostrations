package za.co.code.rockpaperscissors.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.dao.RpsDao;

class RpsDaoImplTest {

    private static final String FILE_LOCATION = "src/test/resources/rockpaperscissors.txt";
    private RpsDao dao;

    @BeforeEach
    void setUp() {
        dao = new RpsDaoImpl(FILE_LOCATION);
    }

    @Test
    void getInstructions() {
        byte[] instructions = dao.getInstructions();
        Assertions.assertNotNull(instructions);
        Assertions.assertEquals(13, instructions.length);
    }

}