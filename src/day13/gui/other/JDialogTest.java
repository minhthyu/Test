package com.briup.gui.other;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class JDialogTest {
	//顶级容器(窗口)
	private JFrame frame;
	//次级容器
	private Container container;
	//面板
	private JPanel north,center;
	//按钮
	private JButton btn,okBut;
	//文本域
	private JTextArea textArea;
	//滚动条
	private JScrollPane scroll;
	//对话框
	private JDialog dialog;
	//Label标签
	private JLabel label;
	//文本输入框
	private JTextField textField;
	
	public JDialogTest() {
		//初始化容器(相当于桌子)
		frame = new JFrame();
		//获得次级容器对象(相当于桌布)
		container = frame.getContentPane();
		//参数1和2是设置frame的位置,电脑屏幕左上角为(0,0)坐标
		//参数3和4指的是frame显示的大小(长宽)
		frame.setBounds(300, 100, 600, 500);
		//点击界面右上角红叉可以关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//相当于设置界面的标题在界面的上边界里面
		frame.setTitle("文件夹查看器");
		init();
		//设置界面可以显示,默认容器初始化完成之后是隐藏的
		frame.setVisible(true);
	}
	
	private void init(){
		//初始化组件
		north = new JPanel();
		center = new JPanel();
		
		btn = new JButton("转到");
		okBut = new JButton("确定");
		
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea); 
		//设置文本域不可编辑
		textArea.setEditable(false);
		//设置文本域内自动换行
		textArea.setLineWrap(true); 
		
		//参数1 对话框属于哪个窗口
		//参数2 对话框标题
		//参数3 弹框对话框后,是否阻止用户进行其他组件的操作
		dialog = new JDialog(frame, "提示信息", true);
		dialog.setBounds(400, 200, 350, 150);
		
		label = new JLabel();
		
		textField = new JTextField(20);
		
		
		//设置容器的布局管理器
		container.setLayout(new BorderLayout());
		north.setLayout(new FlowLayout());
		center.setLayout(new BorderLayout());
		dialog.setLayout(new FlowLayout());
		
		//把组件添加到容器当中
		dialog.add(label);
		dialog.add(okBut);
		
		north.add(textField);
		north.add(btn);
		center.add(scroll);
		
		
		container.add(north, BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		
		
		// 确定按钮监听器
        okBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        //文本框添加键盘事件的监听器
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            	//如果按下回车键
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                	showDir();
                }
            }

        });

        // 对话框监听器
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	//设置对话框不可见
            	dialog.setVisible(false);
            }

        });

        // 按钮事件监听器
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDir();
            }
        });
		
	}
	
    private void showDir(){
    	// 获取单行文本内
        String dirPath = textField.getText();
        File dir = new File(dirPath);

        // 如果文件存在，而且是个目录执行下列操作
        if (dir.exists() && dir.isDirectory()) {
        	//清空当前文本域内容
            textArea.setText(null);
            //获得文件目录列表
            String[] names = dir.list();
            File temp = null;
            for (String name : names) {
            	temp = new File(dirPath,name);
            	if(temp.isDirectory()){
            		name = "D "+name;
            	}else{
            		name = "F "+name;
            	}
            	//追加文本内容并换行
                textArea.append(name + "\n");
            }
        } else {
            String info = "输入的路径 " + dirPath + " 是错误的，请重新输入！";
            //显示文本错误提示信息
            label.setText(info);
            //设置对话框可见。
            dialog.setVisible(true);
        }
    }
	
	public static void main(String[] args) {
		new JDialogTest();
	}
	
	
}