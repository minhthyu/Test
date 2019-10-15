package com.briup.gui.teach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMain {
    //定义属性
    private JFrame frame;
    private JPanel panel;
    //组件
    private JLabel label;
    private JTextField field;
    private JButton button;
    private JLabel label2;

    public GUIMain(){
        //对frame初始化
        frame=new JFrame();
        frame.setTitle("事件处理模型测试");
        frame.setLocation(200,200);
        frame.setSize(300,200);
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //对其他组件进行初始化
        init();
        //设置可见行
        frame.setVisible(true);
    }

    public void init(){
        //1.初始化Panel对象
        panel=new JPanel();
        label=new JLabel("名称");
        label2=new JLabel();
        field=new JTextField(20);
        button=new JButton("拷贝");
        //2.设置布局管理器
        frame.setLayout(new BorderLayout());
        //3.添加组件
//        frame.add(panel,BorderLayout.CENTER);
//        frame.add(button,BorderLayout.SOUTH);
        frame.add(panel);

        panel.add(label);
        panel.add(field);
        panel.add(button);
        panel.add(label2);

//        new MouseListener(){
//
//            @Override
//            public void mouseClicked(MouseEvent mouseEvent) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent mouseEvent) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent mouseEvent) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent mouseEvent) {
//                System.out.println("......");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent mouseEvent) {
//
//            }
//        };

//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent mouseEvent) {
//
//            }
//        });

        //4.添加事件监听
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //点击button按钮，触发那些操作
                //1.获取输入框中的值
                String value=field.getText();
                System.out.println("value="+value);
                //2.给label2赋值
                label2.setText(value);
                //返回事件源
//                actionEvent.getSource();
            }
        });
    }

    public static void main(String[] args) {
        new GUIMain();
    }
}
