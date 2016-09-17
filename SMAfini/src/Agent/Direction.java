package Agent;

import java.util.Random;

/**
 * Created by Maria on 15-Sep-16.
 */
public class Direction {
    public int pasX;
    public int pasY;
    public Direction() {
        Random rand = new Random();
        boolean directionCreated = false;
        while(!directionCreated) {
            pasX = rand.nextInt(3) - 1;
            pasY = rand.nextInt(3) - 1;
            if(pasX != 0 && pasY != 0) {
                break;
            }
        }
    }
}
