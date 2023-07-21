package za.co.code.rockpaperscissors.service.helper;

import za.co.code.rockpaperscissors.domain.Draw;
import za.co.code.rockpaperscissors.domain.IResult;
import za.co.code.rockpaperscissors.domain.Round;
import za.co.code.rockpaperscissors.domain.Winner;

import java.util.List;

public interface ScoreHelper {

    static int getScore(List<Round> rounds) {
        int score = 0;
        for (Round round : rounds) {
            IResult result = ResultHelper.getResult(round);
            if (result.getRoundResult() instanceof Winner) {
                score += 6 + round.getMyShape().getWeight();
            } else if (result.getRoundResult() instanceof Draw) {
                score += 3 + round.getMyShape().getWeight();
            } else {
                score += round.getMyShape().getWeight();
            }
        }
        return score;
    }
}
