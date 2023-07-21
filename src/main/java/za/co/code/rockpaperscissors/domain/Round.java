package za.co.code.rockpaperscissors.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Round extends Pair<Shape> {

    public Round(Shape opponentsShape, Shape meShape) {
        super(opponentsShape, meShape);
    }
}
