package za.co.code.rockpaperscissors.domain;

public class Draw implements IResult {

    @Override
    public IResult getRoundResult() {
        return new Draw();
    }
}
