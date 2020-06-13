package code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Menu  extends JPanel {
    public Menu(){
        super();
        setBorder(new EmptyBorder(50, 10, 10, 10));
        setLayout(new GridBagLayout());


        setPreferredSize(new Dimension(700, 835));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon("src/images/background2.png");
        g.drawImage(ii.getImage(),0,0,this);
        ii =  new ImageIcon("src/images/spacekey.png");
        g.drawImage(ii.getImage(),235,20,this);
        String s = "Fire";
        Font small = new Font("Helvetica", Font.BOLD, 30);
        Color myColor = new Color(0, 118, 168);
        g.setColor(myColor);
        g.setFont(small);
        g.drawString(s,30,50);
        ii =  new ImageIcon("src/images/rightkey.png");
        g.drawImage(ii.getImage(),235,80,this);
        s = "Move right";
        g.drawString(s,30,110);
        ii =  new ImageIcon("src/images/leftkey.png");
        g.drawImage(ii.getImage(),235,140,this);
        s = "Move left";
        g.drawString(s,30,170);
        ii =  new ImageIcon("src/images/upkey.png");
        g.drawImage(ii.getImage(),235,200,this);
        s = "Move up";
        g.drawString(s,30,230);
        ii =  new ImageIcon("src/images/downkey.png");
        g.drawImage(ii.getImage(),235,260,this);
        s = "Move down";
        g.drawString(s,30,290);
        ii =  new ImageIcon("src/images/pkey.png");
        g.drawImage(ii.getImage(),235,570,this);
        s = "Pause";
        g.drawString(s,30,600);

        ii =  new ImageIcon("src/images/okey.png");
        g.drawImage(ii.getImage(),235,630,this);
        s = "Continue";
        g.drawString(s,30,660);



    }
}
