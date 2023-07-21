package za.co.code.rockpaperscissors.domain;

public class Result implements IResult {

    private final IResult roundResult;

    public Result(IResult roundResult) {
        this.roundResult = roundResult;
    }

    @Override
    public IResult getRoundResult() {
        return roundResult;
    }
}
