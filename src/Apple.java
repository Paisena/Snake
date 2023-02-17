import java.util.Random;

public class Apple {
    int x;
    int y;
    boolean isSpawned = false;

    Random random = new Random();

    public void spawn(){
        int randX = random.nextInt(0, 120);
        int randY = random.nextInt(0, 120);

        randX *= 5;
        randY *= 5;

        x = randX;
        y = randY;

        isSpawned = true;
    }

    Apple(){
    
    }
}
