package day13.gui.eventmodel;


/**
 * 事件模型测试类
 * */
public class EventModelTest {
    public static void main(String[] args) {
        //事件源
        Girl girl=new Girl("lily");
        Girl girl1=new Girl("lili");
        EmotionListener eventLi=new EmotionAdaptor(){
            @Override
            public void sad(EmotionEvent event) {
                //获取事件源
                Girl source=(Girl) event.getSource();
                String eventName=event.getName();
                System.out.println(source.getName()+"发朋友圈啦！:对于女孩"+eventName+"的朋友圈，评论说:安慰一番！");
            }
        };
        //添加事件监听
        girl.addEmotionListener(eventLi);
        girl1.addEmotionListener(eventLi);

        //事件对象
        EmotionEvent event = new EmotionEvent("happy!!!",girl);
        girl.happy(event);
        girl.sad(event);
        EmotionEvent event1 = new EmotionEvent("happy!!!",girl1);
        girl1.sad(event1);

    }
}
