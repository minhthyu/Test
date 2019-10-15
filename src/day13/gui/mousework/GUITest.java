package com.briup.gui.mousework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUITest extends JFrame implements ActionListener{
	private static final long serialVersionUID = -6704536050302148900L;
	
	private Container container;
	private JPanel north,center;
	private JTextField field;
	private JButton[] btns;
	private String[] strs = {
			"AC","+/-","%","/",
			"7","8","9","+",
			"4","5","6","-",
			"1","2","3","*",
			".","0","=","/"
	};
	private String old_btnStr;
	
	public GUITest() {
		
		setTitle("计算器");
		container = getContentPane();
		setBounds(200, 200, 400, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
		
	}
	
	private void init(){
		
		north = new JPanel();
		center = new JPanel();
		
		field = new JTextField(20);
		field.setEditable(false);
		
		
		btns = new JButton[20];
		
		container.setLayout(new BorderLayout());
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(4, 4));
		
		container.add(north, BorderLayout.NORTH);
		container.add(center);
		
		north.add(field);
		for(int i=0;i<btns.length;i++){
			btns[i] = new JButton(strs[i]);
			center.add(btns[i]);
			btns[i].addActionListener(this);
		}
		
	}
	
	//this 监听器
	//this 监听了16个按钮
	//实际操作中 点击了某一个按钮 btn
	//这个按钮 btn产生一个事件对象ActionEvent e
	//this发现了有事件发生,然后就获得了这个事件对象e 并且调用指定方法actionPerformed
	//所以在actionPerformed方法中
	//e.getSource()方法可以返回当前产生事件对象的事件源是哪一个按钮
	@Override
	public void actionPerformed(ActionEvent e) {
		//事件对象.getSource();
		//返回值表示:
		//当前这个事件对象是由哪一个事件源所产生
		JButton btn = (JButton)e.getSource();
		String fieldStr = field.getText();
		String btnStr = btn.getText();
		
		if("=".equals(old_btnStr)){
			fieldStr = "";
		}
		
		if("=".equals(btnStr)){
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("javascript");
			Object result = null;
			try {
				result = engine.eval("eval('"+fieldStr+"');");
			} catch (ScriptException e1) {
				e1.printStackTrace();
			}
			field.setText(result.toString());
		}else{
			field.setText(fieldStr+btnStr);
		}
		
		old_btnStr = btnStr;
	}
	public static void main(String[] args) {
		new GUITest();
	}
}
