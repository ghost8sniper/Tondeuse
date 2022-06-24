package fr.mower.model;

public enum Action {

    RIGHT('D'),
    LEFT('G'),
    ADVANCE('A');

    private char key;

    Action(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public static Action valueOfChar(char c) {
        for (Action action : values()) {
            if (action.key == c) {
                return action;
            }
        }
        return null;
    }
}
