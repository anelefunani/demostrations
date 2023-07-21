package za.co.code.rockpaperscissors.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.dao.impl.RpsDaoImpl;

class BytesToListTest extends BaseTest {

    @Test
    void adapt() {
        Assertions.assertEquals(3, new BytesToList()
                .adapt(new RpsDaoImpl(getFileLocation())
                        .getInstructions()).size());
    }
}