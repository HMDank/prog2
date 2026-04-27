package Assignment_03.JumpNRun;

public enum GameObject {

    GROUND('G'), LAVA('L'), AIROBSTACLE('O'), EMPTY(' '), GOAL('Zs');

    private char symbol;

    GameObject(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
