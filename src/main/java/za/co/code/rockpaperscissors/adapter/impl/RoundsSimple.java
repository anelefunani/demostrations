package za.co.code.rockpaperscissors.adapter.impl;


import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.domain.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundsSimple implements Adapter<List<Round>, List<String>> {

    @Override
    public List<Round> adapt(List<String> instructions) {
        List<Round> rounds = new ArrayList<>();
        for (String instruction : instructions) {
            String[] roundInstruction = instruction.split(" ");
            rounds.add(new Round(getShape(roundInstruction[0]), getShape(roundInstruction[1])));
        }
        return rounds;
    }

    private static Shape getShape(final String shape) {
        return Arrays.stream(Shape.values())
                .filter(s -> s.name().equals(shape.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unknown shape: " + shape));
    }
}
