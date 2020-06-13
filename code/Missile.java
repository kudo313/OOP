package code;

public class Missile extends Sprite
{

    private int index;
    private final int MISSILE_SPEED = 10;

    public Missile(int x, int y,int index)
    {

        super(x, y);
        initMissile(index);
        this.index = index;
    }

    private void initMissile(int i) {
        if (i==1)
        loadImage("src/images/missile.png");
        if (i==2)
            loadImage("src/images/missileorder1.png");
        if (i==3)
            loadImage("src/images/missileorder2.png");
        getImageDimensions();

    }

    public void move()
    {
        if (index == 1)
        y -= MISSILE_SPEED;
        else if (index ==  2){
            y-=MISSILE_SPEED;
            x+=MISSILE_SPEED-7;
        }
        else if (index == 3){
            y-=MISSILE_SPEED;
            x-=MISSILE_SPEED-7  ;
        }
        if (y <10)
            visible = false;
        if (x<0)
            visible = false;
    }
}
