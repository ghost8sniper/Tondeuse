package fr.mower.model;

public enum Orientation {

    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    private char indicator;
    private Orientation left;
    private Orientation right;

    static {
        NORTH.left = WEST;
        NORTH.right = EAST;
        EAST.left = NORTH;
        EAST.right = SOUTH;
        SOUTH.left = EAST;
        SOUTH.right = WEST;
        WEST.left = SOUTH;
        WEST.right = NORTH;
    }

    Orientation(char indicator) {
        this.indicator = indicator;
    }

    public char getIndicator() {
        return indicator;
    }

    public void setIndicator(char indicator) {
        this.indicator = indicator;
    }

    public Orientation getLeft() {
        return left;
    }

    public void setLeft(Orientation left) {
        this.left = left;
    }

    public Orientation getRight() {
        return right;
    }

    public void setRight(Orientation right) {
        this.right = right;
    }

    public static Orientation valueOfChar(char c) {
        for (Orientation orientation : values()) {
            if (orientation.indicator == c) {
                return orientation;
            }
        }
        return null;
    }
}
