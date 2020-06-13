package code;

public class buffMissile extends Sprite {
    private int selectImg=1;
    private  String ImgName;
    public  buffMissile(int x, int y){
        super(x,y);
        initBuff();
    }
    public void initBuff(){
        loadImage("src/images/buffmissile1.png");
        getImageDimensions();
    }
    public void loadImage(){
        String ImgName = "src/images/buffmissile" + selectImg + ".png";
        loadImage(ImgName);
        getImageDimensions();
    }
    public void setSelectImg(int i){
        selectImg =  i;
    }
    public int getSelectImg(){
        return selectImg;
    }
    public void move(){
        y+=3;
        if (y>835){
            setVisible(false);
        }
    }

}
