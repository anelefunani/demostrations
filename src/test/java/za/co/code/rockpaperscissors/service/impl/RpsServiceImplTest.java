package za.co.code.rockpaperscissors.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.code.rockpaperscissors.BaseTest;
import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.adapter.impl.RoundsComplex;
import za.co.code.rockpaperscissors.adapter.impl.RoundsSimple;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.service.RpcService;

import java.util.List;

class RpsServiceImplTest extends BaseTest {

    @Test
    void getScoreSimple() {
        Assertions.assertEquals(15, getService(new RoundsSimple()).getScore());
    }

    @Test
    void getScoreComplex() {
        Assertions.assertEquals(12, getService(new RoundsComplex()).getScore());
    }

    private RpcService getService(Adapter<List<Round>, List<String>> adapter) {
        return new RpsServiceImpl(getFileLocation(), adapter);
    }
}
