import java.util.Random;

//The class which for the apple that will be spawned

public class Apple {

    int x;
    int y;
    boolean isSpawned = false;

    Random random = new Random();

    public void spawn(){
        int randX = random.nextInt(1, 29);
        int randY = random.nextInt(2, 29);

        randX *= 20;
        randY *= 20;

        x = randX;
        y = randY;

        isSpawned = true;
    }

    Apple(){
    
    }
}
