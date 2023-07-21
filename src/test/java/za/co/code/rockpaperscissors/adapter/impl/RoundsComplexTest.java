package za.co.code.rockpaperscissors.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.domain.Round;

import java.util.List;

class RoundsComplexTest extends BaseTest {

    @Test
    void adapt() {
        List<Round> rounds = new RoundsAdapter(getFileLocation(), new RoundsComplex()).getRounds();
        String[] expected = new String[] {"R", "R", "R"};
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], rounds.get(i).getMyShape().getShapeName());
        }
    }
}