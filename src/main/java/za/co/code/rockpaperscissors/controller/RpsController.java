package za.co.code.rockpaperscissors.controller;

import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.service.RpcService;
import za.co.code.rockpaperscissors.service.impl.RpsServiceImpl;

import java.util.List;

public class RpsController {

    private final RpcService service;

    public RpsController(String fileLocation, Adapter<List<Round>, List<String>> adapter) {
        this.service = new RpsServiceImpl(fileLocation, adapter);
    }

    public int getScore() {
        return service.getScore();
    }
}
