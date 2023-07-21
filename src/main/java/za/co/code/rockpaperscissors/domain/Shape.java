package za.co.code.rockpaperscissors.domain;

public enum Shape {
    A("R", 1),
    B("P", 2),
    C("S", 3),
    X("R", 1),
    Y("P", 2),
    Z("S", 3);

    private final String shapeName;
    private final int weight;

    Shape(String shapeName, int weight) {
        this.shapeName = shapeName;
        this.weight = weight;
    }

    public String getShapeName() {
        return shapeName;
    }

    public int getWeight() {
        return weight;
    }

}
