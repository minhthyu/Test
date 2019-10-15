package com.briup.gui.teach;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FirstGUI {
	public static void main(String[] args) {
		//1.选择容器 Frame JFrame Diglog Panel
		//2.设置布局管理器
//			BorderLayout  5个区域
//			FlowLayout   n个组件
//			CardLayout  卡片布局
//			GridLayout  网格布局
		//3.添加组件
		//4.设置监听器
		Frame  f=new Frame("第一个窗口");
		f.setLayout(new BorderLayout());

		Button b=new Button("点击");
		b.setSize(70, 50);
		b.setBackground(Color.green);

		f.add(b);

		//实现关闭功能
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//退出程序
				System.exit(0);
			}
		});
		//设置大小
		f.setSize(200, 100);
		//使frame可见
		f.setVisible(true);
	}
}






