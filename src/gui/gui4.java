package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui4 {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
       /* // 设置布局器为null，即进行绝对定位，容器上的组件都需要指定位置和大小
        f.setLayout(null);
        JButton b1 = new JButton("英雄1");
        // 指定位置和大小
        b1.setBounds(50, 50, 80, 30);
        JButton b2 = new JButton("英雄2");
        b2.setBounds(150, 50, 80, 30);
        JButton b3 = new JButton("英雄3");
        b3.setBounds(250, 50, 80, 30);
        // 没有指定位置和大小，不会出现在容器上
        JButton b4 = new JButton("英雄3");*/

        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        f.setLayout(new FlowLayout());
        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");
        JButton b4 = new JButton("英雄4");
        b4.setPreferredSize(new Dimension(180,40));

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        // b4没有指定位置和大小，不会出现在容器上
        // f.add(b4);
/**
 * 容器2
 */
        JFrame f2 = new JFrame("LoL2");
        f2.setSize(600, 200);
        f2.setLocation(300, 200);
        // 设置布局器为BorderLayerout
        // 容器上的组件按照上北下南左西右东中的顺序摆放
        f2.setLayout(new BorderLayout());
        JButton b11 = new JButton("洪七");
        JButton b12 = new JButton("段智兴");
        JButton b13 = new JButton("欧阳锋");
        JButton b14 = new JButton("黄药师");
        JButton b15 = new JButton("周伯通");

        f2.add(b11,BorderLayout.NORTH);
        f2.add(b12,BorderLayout.SOUTH);
        f2.add(b13,BorderLayout.WEST);
        f2.add(b14,BorderLayout.EAST);
        f2.add(b15,BorderLayout.CENTER);

        /**
         * 容器3
         */
        JFrame f3 = new JFrame("LoL");
        f3.setSize(400, 300);
        f3.setLocation(400, 200);
        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是2行3列
        f3.setLayout(new GridLayout(2, 3));

        JButton b31 = new JButton("洪七");
        JButton b32 = new JButton("段智兴");
        JButton b33 = new JButton("欧阳锋");
        JButton b34 = new JButton("黄药师");
        JButton b35 = new JButton("周伯通");

        f3.add(b31);
        f3.add(b32);
        f3.add(b33);
        f3.add(b34);
        f3.add(b35);

        /**
         * 容器4
         */
        String[] texts ={
                "7","8","9","/","sq",
                "4","5","6","*","%",
                "1","2","3","-","1/x",
                "0","+/-",".","+","="
        };
        JFrame jsq = new JFrame("计算器");
        jsq.setSize(500,500);
        jsq.setLocation(400,400);
        GridLayout gl = new GridLayout(4,5);
        gl.setHgap(20);
        gl.setVgap(20);
        jsq.setLayout(gl);
        for (int i =0 ;i<texts.length;++i){
            jsq.add(new JButton(texts[i]));
        }
        jsq.setVisible(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(f2.isVisible());
                f2.setVisible(true);
                f2.setResizable(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f3.setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setVisible(true);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f2.setVisible(false);
        f3.setVisible(false);
    }
}
