package za.co.code.rockpaperscissors.domain;

public class Winner implements IResult {

    @Override
    public IResult getRoundResult() {
        return new Winner();
    }
}
