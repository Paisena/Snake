
public class SnakeUnit {

    int x;
    int y;
    static int xDir = 20;
    static int yDir = 0;
    static int size = 1;

    SnakeUnit(int xPos,int yPos){
        x = xPos;
        y = yPos;
    }

    public void move(){
        x += xDir;
        y += yDir;
    }

    public static void changeXDir(int Vel){
        xDir = Vel;
        yDir = 0;
    }

    public static void changeYDir(int Vel){
        yDir = Vel;
        xDir = 0;
    }

    public boolean isOverApple(int appleX, int appleY){
        if(appleX == x && appleY == y){
            return true;
        }
        return false;
    }

    public void grow(){

    }

    public int getXDir(){
        return xDir;
    }

    public int getYDir(){
        return yDir;
    }
}
