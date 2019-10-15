package com.briup.gui.other;

public class EmotionTest {
	
	public static void main(String[] args) {
		//事件源---> 组件
		EmotionSource girl = new EmotionSource("lily");
		//组件添加事件监听
		girl.addActionListenner(new EmotionAdapter() {		
			@Override
			public void sad(EmotionEvent e) {
				EmotionSource girl = (EmotionSource) e.getSource();
				String name = girl.getName();
				System.out.println("I am the listenner-boy and I am so Sad too because "+name+" is Sad");
			}		
//			@Override
//			public void happy(EmotionEvent e) {
//				EmotionSource girl = (EmotionSource) e.getSource();
//				String name = girl.getName();
//				System.out.println("I am the listenner-boy and I am so Happy too because "+name+" is Happy");
//				
//			}
		});
		
		//模拟事件产生  //Happy事件
		girl.happy();
//		girl.sad();
	}
	
}
