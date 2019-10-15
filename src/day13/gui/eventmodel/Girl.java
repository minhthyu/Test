package day13.gui.eventmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件源
 * */
public class Girl implements EmotionEventSource, EmotionListener{

    private String name;
    /**
     * 事件监听列表
     * */
    private List<EmotionListener> listeners=new ArrayList<>();

    public Girl(String name){
        this.name=name;
    }

    /**
     * 添加事件监听列表
     * */
    public void addEmotionListener(EmotionListener listener){
        listeners.add(listener);
    }

    /**
     * 移除事件监听列表
     * */
    public void removeEmotionListener(EmotionListener listener){
        listeners.remove(listener);
    }


    public void sad(EmotionEvent event) {
        if(event==null){
            event=new EmotionEvent("i'm sad!");
        }
        for(EmotionListener boy:listeners){
            boy.sad(event);
        }
    }

    public void happy(EmotionEvent event) {
        if(event!=null){
            event=new EmotionEvent("I'm happy!") ;
        }
        for(EmotionListener boy:listeners){
            boy.happy(event);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", listeners=" + listeners +
                '}';
    }

}
