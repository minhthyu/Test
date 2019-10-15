package day13.gui.eventmodel;

/**
 * 情感事件监听器
 * */
public interface EmotionListener{
    void sad(EmotionEvent event);
    void happy(EmotionEvent event);
}
