package fr.mower.model;

import java.util.ArrayList;
import java.util.List;

public class Mower {

    private Position position;
    private List<Action> actions;


    public Mower(int x, int y, Orientation orientation) {
        this.position = new Position(x, y, orientation);
        this.actions = new ArrayList<>();
    }

    public void orientate(Action action){
        Orientation currentOrientation = position.getOrientation();
        if(action.equals(Action.LEFT))
            position.setOrientation(currentOrientation.getLeft());
        else if(action.equals(Action.RIGHT))
            position.setOrientation(currentOrientation.getRight());
    }

    public void advance(int width, int height){
        switch (position.getOrientation()){
            case NORTH:
                if(position.getY() < height) position.incrementY();
                break;
            case SOUTH:
                if(position.getY() > 0) position.decrementY();
                break;
            case EAST:
                if(position.getX() < width) position.incrementX();
                break;
            case WEST:
                if(position.getX() > 0) position.decrementX();
                break;
        }
    }

    public void setActions(String actions) {
        actions = actions.trim();
        char[] charActions = actions.toCharArray();
        for (char c : charActions) {
            Action action = Action.valueOfChar(c);
            if(action != null)
                this.actions.add(action);
        }
    }

    public List<Action> getActions() {
        return actions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
