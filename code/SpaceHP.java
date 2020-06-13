    package code;

    public class SpaceHP extends Sprite {
        public SpaceHP(int x, int y){
            super(x,y);
            initHP();
        }
        public void initHP(){
            loadImage("src/images/HP.png");
            getImageDimensions();
        }
    }
