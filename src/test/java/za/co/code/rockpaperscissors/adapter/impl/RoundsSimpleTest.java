package za.co.code.rockpaperscissors.adapter.impl;

import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.dao.impl.RpsDaoImpl;
import za.co.code.rockpaperscissors.domain.Round;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundsSimpleTest extends BaseTest {

    @Test
    void adapt() {
        List<Round> rounds = new RoundsSimple().adapt(new BytesToList().adapt(new RpsDaoImpl(getFileLocation()).getInstructions()));
        String[][] opponentShapes = new String[][]{
                {"A", "Y"},
                {"B", "X"},
                {"C", "Z"}
        };

        for (int i = 0; i < opponentShapes.length; i++) {
            assertEquals(opponentShapes[i][0], rounds.get(i).getOpponentShape().name());
            assertEquals(opponentShapes[i][1], rounds.get(i).getMyShape().name());
        }
    }
}
