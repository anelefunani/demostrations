package za.co.code.rockpaperscissors.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.adapter.impl.RoundsComplex;
import za.co.code.rockpaperscissors.adapter.impl.RoundsSimple;
import za.co.code.rockpaperscissors.domain.Round;

import java.util.List;

class RpsControllerTest extends BaseTest {

    @Test
    void getScoreSimple() {
        int score = getController(new RoundsSimple()).getScore();
        Assertions.assertEquals(15, score);
    }

    @Test
    void getScoreComplex() {
        Assertions.assertEquals(12, getController(new RoundsComplex()).getScore());
    }

    private RpsController getController(Adapter<List<Round>, List<String>> adapter) {
        return new RpsController(getFileLocation(), adapter);
    }

}
