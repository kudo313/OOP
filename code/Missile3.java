package code;

public class Missile3 extends Sprite {
    private final int MISSILE_SPEED = 5;
    private int levelMiss = 1;
    public Missile3(int x, int y,int index)
    {
        super(x, y);
        initMissile(index);
    }

    private void initMissile(int i) {
        visible = false;
        if (i==1) {
            loadImage("src/images/missile3.png");
        }
        if (i==2){
            loadImage("src/images/missile3order1.png");
        }
        if (i==3)
        {
            loadImage("src/images/missile3order2.png");
        }
        getImageDimensions();
    }
    public void setLevelMiss(int i){
        levelMiss = i;
    }
    public int getLevelMiss(){
        return  levelMiss;
    }
    public void move()
    {
        if (levelMiss == 1)
        y += MISSILE_SPEED;
        if (levelMiss ==2 ){
            y+=MISSILE_SPEED;
            x-=(MISSILE_SPEED-2);
        }
        if (levelMiss == 3){
            y+=MISSILE_SPEED;
            x+= ( MISSILE_SPEED -2);
        }

        if (y > 835 || x < 0 || x>1500)
            visible = false;
    }
}
