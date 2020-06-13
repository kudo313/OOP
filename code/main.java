package code;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main  extends JFrame
{
    public main() {

        initUI();
    }

    private void initUI() {
        Board b = new Board();
        add(b);
        Menu card1 = new Menu();

        Icon icon = new ImageIcon("src/images/easy.png");
        JButton button1 = new JButton(icon);

        Icon icon2 = new ImageIcon("src/images/normal.png");
        JButton button2 = new JButton(icon2);
        Icon icon1 = new ImageIcon("src/images/hard.png");
        JButton button3 = new JButton(icon1);
        Icon icon3 = new ImageIcon("src/images/exit.png");
        JButton button4 = new JButton(icon3);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;



        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(button1, gbc);
        gbc.weighty = 1;
        buttons.add(button2, gbc);
        buttons.add(button3, gbc);
        buttons.add(button4, gbc);

        gbc.weighty = 1;
        card1.add(buttons, gbc);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card1.setVisible(false);
                b.timeStart();
                b.initEasy();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card1.setVisible(false);
                b.timeStart();
                b.initNormal();

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card1.setVisible(false);
                b.timeStart();
                b.initHard();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        b.add(card1);
        setResizable(false);
        pack();

        setTitle("Space Invaders");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {

        EventQueue.invokeLater(() ->
        {
            main ex = new main();
            ex.setVisible(true);
        });
    }


}
