
public class SnakeUnit {

    int x;
    int y;
    int xDir = 5;
    int yDir;
    int size = 1;

    SnakeUnit(int xPos,int yPos){
        x = xPos;
        y = yPos;
    }

    public void move(){
        x += xDir;
        y += yDir;
    }

    public void changeXDir(int Vel){
        xDir = Vel;
        yDir = 0;
    }

    public void changeYDir(int Vel){
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
}
