package za.co.code.rockpaperscissors.service.impl;

import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.adapter.impl.RoundsAdapter;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.service.RpcService;
import za.co.code.rockpaperscissors.service.helper.ScoreHelper;

import java.util.List;

public class RpsServiceImpl implements RpcService {

    private final RoundsAdapter adapter;

    public RpsServiceImpl(String fileLocation, Adapter<List<Round>, List<String>> adapter) {
        this.adapter = new RoundsAdapter(fileLocation, adapter);
    }

    @Override
    public int getScore() {
        return ScoreHelper.getScore(adapter.getRounds());
    }
}
