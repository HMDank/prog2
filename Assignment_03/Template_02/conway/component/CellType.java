package conway.component;

import java.awt.Color;

public enum CellType {
    LIVING(1, Color.BLACK),
    DEAD(0, Color.WHITE);

    private int value;
    private Color color;

    CellType(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }
}