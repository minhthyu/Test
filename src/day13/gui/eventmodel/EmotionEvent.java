package day13.gui.eventmodel;

/**
 *情感事件
 * */
public class EmotionEvent {
    /**
     * 情感消息
     * */
    private String name;
    /**
     * 事件源
     * */
    private EmotionEventSource source;

    public EmotionEvent(String name){
        this.name=name;
    }

    public EmotionEvent(String name,EmotionEventSource source){
        this.name=name;
        this.source=source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmotionEventSource getSource() {
        return source;
    }

    public void setSource(EmotionEventSource source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "EmotionEvent{" +
                "name='" + name + '\'' +
                ", source=" + source +
                '}';
    }
}
