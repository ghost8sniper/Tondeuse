import fr.mower.config.GridSetup;
import fr.mower.model.Grid;
import fr.mower.model.Mower;
import fr.mower.model.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private Grid grid;
    private Mower mower1;
    private Mower mower2;

    @BeforeEach
    public void init(){
        mower1 = new Mower(1, 2, Orientation.NORTH);
        mower1.setActions("GAGAGAGAA");
        mower2 = new Mower(3, 3, Orientation.EAST);
        mower2.setActions("AADAADADDA");

        grid = new GridSetup().setupGrid();
    }

    @Test
    @DisplayName("move_mower")
    public void moveMower(){
        assertEquals("1 3 N", grid.moveMower(mower1));
        assertEquals("5 1 E", grid.moveMower(mower2));
    }

    @Test
    @DisplayName("move_all_mower")
    public void moveAllMowers(){
        assertEquals("1 3 N 5 1 E", grid.moveAllMowers());
    }
}
