package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class gui3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("myTest3");
        f.setSize(500,400);
        f.setLocation(580,200);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("E:/img/007.png");
        l.setIcon(i);
        l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());

        JButton bt1 = new JButton("隐藏图片");
        bt1.setBounds(10,10,150,30);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(l.isVisible()){
                    bt1.setText("显示图片");
                    l.setVisible(false);
                }else{
                    bt1.setText("隐藏图片");
                    l.setVisible(true);
                }
            }
        });

        f.add(bt1);
        f.addKeyListener(new KeyListener() {
            @Override
            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {

            }

            @Override
            //键被按下
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            // 键被弹起
            public void keyReleased(KeyEvent e) {
                // 39代表按下了 “右键”
                if (e.getKeyCode() == 39){
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX()+10,l.getY());
                }else if(e.getKeyCode() == 38){
                    l.setLocation(l.getX(),l.getY()-10);
                }else if(e.getKeyCode() == 40){
                    l.setLocation(l.getX(),l.getY()+10);
                }else if(e.getKeyCode() == 37){
                    l.setLocation(l.getX()-10,l.getY());
                }
            }
        });

        /*f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            // 鼠标进入
            @Override
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());

                l.setLocation(x, y);
            }

            // 鼠标离开
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/

        // MouseAdapter 适配器，只需要重写用到的方法，没有用到的就不用写了
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());

                l.setLocation(x, y);
            }
        });

        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
