package za.co.code.rockpaperscissors.adapter.impl;

import za.co.code.rockpaperscissors.adapter.Adapter;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.domain.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundsComplex implements Adapter<List<Round>, List<String>> {

    @Override
    public List<Round> adapt(List<String> instructions) {
        List<Round> rounds = new ArrayList<>();
        for (String instruction : instructions) {
            String[] roundInstruction = instruction.split(" ");
            rounds.add(new Round(getShape(roundInstruction[0]), getMyShape(roundInstruction[0], roundInstruction[1])));
        }
        return rounds;
    }

    private Shape getMyShape(final String opponent, final String me) {
        if (me.equals("Y"))
            return getDrawShape(opponent);
        else if (me.equals("X"))
            return getLoseShape(opponent);
        else
            return getWinShape(opponent);
    }

    private Shape getShape(final String shape) {
        return Arrays.stream(Shape.values())
                .filter(s -> s.name().equals(shape.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unknown shape: " + shape));
    }

    private Shape getDrawShape(final String opponent) {
        return getShape(opponent);
    }

    private Shape getLoseShape(final String opponent) {
        if (getShape(opponent) == Shape.A)
            return Shape.Z;
        else if (getShape(opponent) == Shape.B)
            return Shape.X;
        else
            return Shape.Y;
    }

    private Shape getWinShape(String opponent) {
        if (getShape(opponent) == Shape.A)
            return Shape.Y;
        else if (getShape(opponent) == Shape.B)
            return Shape.Z;
        else
            return Shape.X;
    }

}
