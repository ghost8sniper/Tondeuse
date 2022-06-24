package fr.mower.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {

    private int width;
    private int height;
    private List<Mower> mowers;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.mowers = new ArrayList<>();
    }

    public String moveAllMowers(){
        for(Mower mower : mowers)
            moveMower(mower);
        return mowers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public String moveMower(Mower mower){
        for(Action action: mower.getActions()){
            if(action.equals(Action.ADVANCE))
                mower.advance(width, height);
            else
                mower.orientate(action);
        }
        return mower.toString();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
