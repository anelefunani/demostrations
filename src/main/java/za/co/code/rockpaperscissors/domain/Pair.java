package za.co.code.rockpaperscissors.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pair<T> {
    private T opponentShape;
    private T myShape;

    public Pair(T opponentsShape, T meShape) {
        this.opponentShape = opponentsShape;
        this.myShape = meShape;
    }
}
