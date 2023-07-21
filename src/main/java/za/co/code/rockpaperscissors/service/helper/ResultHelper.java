package za.co.code.rockpaperscissors.service.helper;

import za.co.code.rockpaperscissors.domain.*;

public interface ResultHelper {

    static IResult getResult(Round round) {
        if (round.getMyShape().getShapeName().equals("R") && round.getOpponentShape().getShapeName().equals("S") ||
                round.getMyShape().getShapeName().equals("S") && round.getOpponentShape().getShapeName().equals("P") ||
                round.getMyShape().getShapeName().equals("P") && round.getOpponentShape().getShapeName().equals("R"))
            return new Result(new Winner());
        else if (round.getMyShape().getShapeName().equals(round.getOpponentShape().getShapeName()))
            return new Result(new Draw());
        else
            return new Result(new Loser());
    }

}
