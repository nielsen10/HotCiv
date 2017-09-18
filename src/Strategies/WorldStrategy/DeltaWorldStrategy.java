package Strategies.WorldStrategy;

import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.TileImpl;
import hotciv.standard.UnitImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csdev on 9/18/17.
 */
public class DeltaWorldStrategy implements WorldStrategy {

    private String line;
    private CityImpl cityRed = new CityImpl(Player.RED, new Position(8,12));
    private CityImpl cityBlue = new CityImpl(Player.BLUE, new Position(4,5));


    String[] layout =
            new String[] {
                    "...ooMooooo.....",
                    "..ohhoooofffoo..",
                    ".oooooMooo...oo.",
                    ".ooMMMoooo..oooo",
                    "...ofooohhoooo..",
                    ".ofoofooooohhoo.",
                    "...ooo..........",
                    ".ooooo.ooohooM..",
                    ".ooooo.oohooof..",
                    "offfoooo.offoooo",
                    "oooooooo...ooooo",
                    ".ooMMMoooo......",
                    "..ooooooffoooo..",
                    "....ooooooooo...",
                    "..ooohhoo.......",
                    ".....ooooooooo..",
            };



    @Override
    public void buildWorld(GameImpl game, HashMap<Position, UnitImpl> unitMap, HashMap<Position, TileImpl> tileMap, HashMap<Position, CityImpl> cityMap) {
        //input tiles
        for (int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = layout[r];
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                char tileChar = line.charAt(c);
                String type = "error";
                if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
                if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
                if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
                if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
                if ( tileChar == 'h' ) { type = GameConstants.HILLS; }
                Position p = new Position(r,c);
                tileMap.put(p, new TileImpl(p, type));
            }
        }
        //input cities
        cityMap.put(cityRed.getPosition(), cityRed);
        cityMap.put(cityBlue.getPosition(), cityBlue);

        //input units

    }
}
