package za.co.code.rockpaperscissors.domain;

public class Loser implements IResult {
    @Override
    public IResult getRoundResult() {
        return new Loser();
    }
}
