package Strategies.unitActionStrategies;

import hotciv.framework.Position;
import hotciv.standard.CityImpl;
import hotciv.standard.GameImpl;
import hotciv.standard.UnitImpl;

import java.util.HashMap;

/**
 * Created by csdev on 9/17/17.
 */
public class GammaUnitActionStrategy  implements UnitActionStrategy {

    @Override
    public void performUnitActionAt(Position p, GameImpl game, HashMap<Position, UnitImpl> unitMap, HashMap<Position, CityImpl> cityMap) {
        if(game.getUnitAt(p).getTypeString() == "settler") {
            cityMap.put(p, new CityImpl(game.getUnitAt(p).getOwner(), p));
            unitMap.remove(p, game.getUnitAt(p));
        }
        else if(game.getUnitAt(p).getTypeString() == "archer"){
            if(game.getUnitAt(p))
            unitMap.get(p).setDefensiveStrength(unitMap.get(p).getDefensiveStrength());
        }
    }
}