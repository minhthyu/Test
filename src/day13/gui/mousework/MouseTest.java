package com.briup.gui.mousework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MouseTest extends JFrame implements ActionListener{
	private static final long serialVersionUID = 348354160589559438L;
	
	private Container container;
	private JPanel northPanel,centerPanel;
	private JComboBox<String> box;
	private JLabel timeLable,timeValue,centLable,centValue;
	private JButton startBtn;
	private JButton[] btns;
	
	//定时器 负责时间的倒计时
	private Timer timer;
	//定时器 负责老鼠的出现
	private Timer mouseTimer;
	//老鼠出现频率
	private int level = 1000;
	//老鼠图片
	private ImageIcon image;
	//老鼠上一次出现的位置
	private int old_index;
	//false表示每有加过分 true反之
	private boolean flag;
	
	public MouseTest(String title) {
		setTitle(title);
		setBounds(200, 200, 400, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	
	private void init(){
		container = getContentPane();
		northPanel = new JPanel();
		centerPanel = new JPanel();
		
		box = new JComboBox<String>();
		box.addItem("初级");
		box.addItem("中级");
		box.addItem("高级");
		
		timeLable = new JLabel("time:");
		timeValue = new JLabel("10");
		centLable = new JLabel("cent:");
		centValue = new JLabel("0");
		
		startBtn = new JButton("开始");
		btns = new JButton[9];
		
		image = new ImageIcon("src/com/briup/gui/mousework/mouse.jpg");
		
		container.setLayout(new BorderLayout());
		northPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new GridLayout(3,3));
		
		northPanel.add(box);
		northPanel.add(timeLable);
		northPanel.add(timeValue);
		northPanel.add(centLable);
		northPanel.add(centValue);
		northPanel.add(startBtn);
		
		for(int i=0;i<btns.length;i++){
			btns[i] = new JButton();
			btns[i].addActionListener(this);
			btns[i].setEnabled(false);
			centerPanel.add(btns[i]);
		}
		
		container.add(northPanel, BorderLayout.NORTH);
		container.add(centerPanel);
		
		
		
		startBtn.addActionListener(this);
		timer = new Timer(1000,this);
		mouseTimer = new Timer(level,this);
		box.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//获得产生事件对象的事件源
		Object source = e.getSource();
		
		//事件源是不是开始按钮
		if(source == startBtn){
			timeValue.setText(10+"");
			centValue.setText(0+"");
			setBtnEnabled(true);
			startBtn.setEnabled(false);
			timer.start();
			mouseTimer.start();
		}
		//事件源是不是时间定时器
		else if(source == timer){
			int timeCount = timeCount();
			if(timeCount==0){
				timer.stop();
				mouseTimer.stop();
				setBtnEnabled(false);
				startBtn.setEnabled(true);
				//倒计时结束,把最后一次老鼠的位置清空
				btns[old_index].setIcon(null);
			}
		}
		//事件源是不是mouseTimer定时器
		else if(source == mouseTimer){
			//把上一次老鼠的位置清空
			btns[old_index].setIcon(null);
			int index = (int)(Math.random()*9);
			btns[index].setIcon(image);
			//最新出现的老鼠还没有点击加分过
			flag = false;
			old_index = index;
		}
		//事件源是不是下拉菜单
		else if(source == box){
			String str = (String)box.getSelectedItem();
			if("初级".equals(str)){
				level = 1000;
			}
			else if("中级".equals(str)){
				level = 500;
			}
			else{
				level = 100;
			}
			mouseTimer = new Timer(level, this);
		}
		else{
			for(int i=0;i<btns.length;i++){
				if(!flag&&source == btns[i]&&btns[i].getIcon()!=null){
					addCent();
					//加过分之后 flag设置为true 表示这个老鼠已经被点击加过分了
					flag = true;
					break;
				}
			}
		}
	}
	
	private void addCent(){
		int c = Integer.parseInt(centValue.getText());
		c++;
		centValue.setText(c+"");
	}
	
	private int timeCount(){
		int t =Integer.parseInt(timeValue.getText());
		t--;
		timeValue.setText(t+"");
		return t;
	}
	
	private void setBtnEnabled(boolean flag){
		for(int i=0;i<btns.length;i++){
			btns[i].setEnabled(flag);
		}
	}
	
	public static void main(String[] args) {
		new MouseTest("打地鼠");
	}
	
}
