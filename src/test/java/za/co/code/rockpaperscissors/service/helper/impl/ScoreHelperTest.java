package za.co.code.rockpaperscissors.service.helper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.adapter.impl.RoundsAdapter;
import za.co.code.rockpaperscissors.adapter.impl.RoundsComplex;
import za.co.code.rockpaperscissors.adapter.impl.RoundsSimple;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.service.helper.ScoreHelper;

import java.util.List;

class ScoreHelperTest extends BaseTest {

    @Test
    void getScoreSimple() {
        Assertions.assertEquals(15, ScoreHelper.getScore(getRounds(new RoundsSimple())));
    }

    @Test
    void getScoreComplex() {
        Assertions.assertEquals(12, ScoreHelper.getScore(getRounds(new RoundsComplex())));
    }


    private List<Round> getRounds(Adapter<List<Round>, List<String>> adapter) {
        return new RoundsAdapter(getFileLocation(), adapter).getRounds();
    }
}
