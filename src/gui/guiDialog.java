package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiDialog {
    public static void main(String[] args) {
        final JFrame jf = new JFrame("外部窗口");
        //设置大小
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);

        //创建按钮
        JButton button = new JButton("打开一个模态窗口");
        //设置大小位置
        button.setBounds(250, 80, 300, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个模态窗口
                final JDialog jd = new JDialog(jf);
                jd.setTitle("这是一个模态窗口");
                //设置大小
                jd.setSize(200,200);
//                jd.setLocation(300,200);
                jd.setLocationRelativeTo(jf);
                jd.setLayout(null);

                //设置模态
                jd.setModal(true);

                final JButton jdb = new JButton("锁定大小");
                jdb.setBounds(0,0,jd.getWidth(),jd.getHeight());

                jdb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean isVS = jd.isResizable();
                        if (isVS) {
                            jdb.setText("解锁大小");
                            jd.setResizable(false);
                        } else {
                            jdb.setText("锁定大小");
                            jd.setResizable(true);
                        }
                    }
                });
                jd.add(jdb);
                jd.setVisible(true);
            }
        });

        jf.add(button);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
