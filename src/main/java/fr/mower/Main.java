package fr.mower;

import fr.mower.config.GridSetup;
import fr.mower.model.Grid;

public class Main {

    public static void main(String[] args) {
        GridSetup gridSetup = new GridSetup();
        Grid grid = gridSetup.setupGrid();
        System.out.println(grid.moveAllMowers());
    }
}
