package com.briup.gui.other;

//事件监听器 (相当于例子的男孩)
public interface EmotionListenner {
	
	void happy(EmotionEvent e);
	void sad(EmotionEvent e);
//	void sad1(EmotionEvent e);
//	void sad2(EmotionEvent e);
}
abstract class EmotionAdapter implements EmotionListenner{
	@Override
	public void happy(EmotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sad(EmotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void sad1(EmotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void sad2(EmotionEvent e) {
		// TODO Auto-generated method stub
		
	}
}