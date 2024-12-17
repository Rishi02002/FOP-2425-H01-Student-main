package h01;

import fopbot.Direction;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import fopbot.Robot;
import h01.template.Families;
import h01.template.Ghost;
import h01.template.TickBased;
import h01.template.Util;

/**
 * The {@link PinkGhost} is a {@link Robot} that looks like a pink ghost.
 * It tries to move in a random direction.
 */
public class PinkGhost extends Robot implements Ghost, TickBased {
    /**
     * Creates a new {@link PinkGhost} at the given position.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public PinkGhost(int x, int y) {
        super(x, y, Families.GHOST_PINK);
    }

    /**
     * Finds in how many directions the ghost can move and then turns a random
     * amount of times to the left.
     * The ghost then moves forward or turns to the left until it can move forward.
     */
    @Override
    @StudentImplementationRequired("H2.2")
    public void doMove() {
        //"H2.2 - Remove if implemented");
           Direction x= null;
           Direction y = null;
           Direction x1 = null;
           Direction x2 = null;

           int numberOfWay= 0;

           for (int i=0; i < 4; i++) {
               turnLeft();
               if (isFrontClear()) {
                   numberOfWay++;
                   if (x == null) {
                       x = getDirection();
                   } else if (y == null) {
                       y = getDirection();
                   } else if (x1 == null) {
                       x1 = getDirection();
                   } else
                       x2 = getDirection();
               }
           }
if (numberOfWay == 0) {
    return;
}

final int numberOfWays = Util.getRandomInteger(0, numberOfWay-1);
   Direction way= null;
    if(numberOfWays==0){
        way = x;
    } else if (numberOfWays==1) {
        way = y;
    } else if (numberOfWays==2) {
        way = x1;

    } else {
        way = x2;
    }
       while (getDirection() != way) {
           turnLeft();
       }
       move();
    }
    }


