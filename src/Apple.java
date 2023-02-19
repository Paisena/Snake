import java.util.Random;

public class Apple {
    int x;
    int y;
    boolean isSpawned = false;

    Random random = new Random();

    public void spawn(){
        int randX = random.nextInt(0, 30);
        int randY = random.nextInt(1, 30);

        randX *= 20;
        randY *= 20;

        x = randX;
        y = randY;

        isSpawned = true;
    }

    Apple(){
    
    }
}
