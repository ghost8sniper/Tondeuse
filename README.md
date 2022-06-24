# Mower

Mower is a program for automating mower movements inside a grid
## Structure

```bash
├───main
│   ├───java
│   │   └───fr
│   │       └───mower
│   │           │   Main.java
│   │           │
│   │           ├───config
│   │           │       ConfigReader.java
│   │           │       GridSetup.java
│   │           │
│   │           └───model
│   │                   Action.java
│   │                   Grid.java
│   │                   Mower.java
│   │                   Orientation.java
│   │                   Position.java
│   │
│   └───resources
│           grid-config.txt
│
└───test
    └───java
            GridTest.java
```
## Configuration

The file resources/grid-config.txt is your first destination for setting up the grid properties, mowers positions and there movements.
<br/>
### Example 

5 5 1 2 N GAGAGAGAA 3 3 E AADAADADDA
<br/>
5 5 : correspond to width and height of the grid
<br/>
1 2 N : correspond to position of the mower (x=1, y=2) and N (NORTH) its orientation
<br/>
GAGAGAGAA : movements of the mower inside the grid, G (Orientate to left), D(Orientate to right) and A(Advance)


## Start
```java
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
```