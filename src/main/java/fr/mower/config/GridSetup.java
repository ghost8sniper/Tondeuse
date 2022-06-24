package fr.mower.config;


import fr.mower.model.Grid;
import fr.mower.model.Mower;
import fr.mower.model.Orientation;

import java.util.ArrayList;
import java.util.List;

public class GridSetup {

    private static ConfigReader configReader;

    public GridSetup() {
        configReader = ConfigReader.getInstance();
    }

    public Grid setupGrid(){
        Grid grid = new Grid(Integer.parseInt(configReader.getConfig().get(0)),
                Integer.parseInt(configReader.getConfig().get(1)));
        grid.setMowers(setupMowers());

        return grid;
    }

    public List<Mower> setupMowers(){
        List<Mower> mowers = new ArrayList<>();
        List<String> currentConfig = configReader.getConfig();
        for(int i = 2; i < currentConfig.size(); i+=4){
            Mower mower = new Mower(Integer.parseInt(currentConfig.get(i)),
                    Integer.parseInt(currentConfig.get(i+1)),
                    Orientation.valueOfChar(currentConfig.get(i+2).charAt(0)));
            mower.setActions(currentConfig.get(i+3));
            mowers.add(mower);
        }
        return mowers;
    }
}
