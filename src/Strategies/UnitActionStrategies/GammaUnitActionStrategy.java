package Strategies.UnitActionStrategies;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.CityImpl;
import hotciv.GameImpl;
import hotciv.UnitImpl;

import java.util.HashMap;

/**
 * Created by csdev on 9/17/17.
 */
public class GammaUnitActionStrategy implements UnitActionStrategy {

    @Override
    public void deployUnitAction(Position p, GameImpl game, HashMap<Position, UnitImpl> unitMap, HashMap<Position, CityImpl> cityMap) {
        if (game.getUnitAt(p).getTypeString() == GameConstants.SETTLER) {
            cityMap.put(p, new CityImpl(game.getUnitAt(p).getOwner(), p));
            unitMap.remove(p, game.getUnitAt(p));
        } else if (game.getUnitAt(p).getTypeString() == GameConstants.ARCHER) {
            if (unitMap.get(p).isFortified()) {
                unitMap.get(p).setFortified(false);
                unitMap.get(p).setDefensiveStrength(-unitMap.get(p).getDefensiveStrength() / 2);

            } else {
                unitMap.get(p).setDefensiveStrength(unitMap.get(p).getDefensiveStrength());
                unitMap.get(p).setFortified(true);
            }
        }
    }
}
