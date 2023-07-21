package za.co.code.rockpaperscissors.adapter.impl;

import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.dao.RpsDao;
import za.co.code.rockpaperscissors.dao.impl.RpsDaoImpl;
import za.co.code.rockpaperscissors.domain.Round;

import java.util.List;

public class RoundsAdapter {

    private final RpsDao dao;

    private final Adapter<List<String>, byte[]> fromBytes;

    private final Adapter<List<Round>, List<String>> fromList;

    public RoundsAdapter(String fileLocation, Adapter<List<Round>, List<String>> toRounds) {
        this.dao = new RpsDaoImpl(fileLocation);
        this.fromBytes = new BytesToList();
        this.fromList = toRounds;
    }

    public List<Round> getRounds() {
        return fromList.adapt(fromBytes.adapt(dao.getInstructions()));
    }
}
