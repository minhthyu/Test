package day03;

import java.util.*;

public class SendPlayingCarder{
    private int personNum;
    private ArrayList<PlayingCard> playingCards;
    public SendPlayingCarder() {
        System.out.println("====");
        this.personNum = 3;
        this.playingCards = new ArrayList<>();
        shuffleCards(playingCardConstructor());
        sendPlayingCard();
    }

    public SendPlayingCarder(int personNum) {
        this.personNum = personNum;
        this.playingCards = new ArrayList<>();
        shuffleCards(playingCardConstructor());
        sendPlayingCard();
    }

    /**
     * 卡组构造器
     * @return 卡组Map
     */
    public Map<Integer,PlayingCard> playingCardConstructor(){
        char[] cardColors = {9824, 9825, 9826, 9827};
        String[] cardNums = {"A", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K"};
        int i = 0;
        Map<Integer,PlayingCard> playingCards = new HashMap<>();
        for (char cardColor : cardColors) {
            for (String cardNum : cardNums) {
                playingCards.put(++i, new PlayingCard(cardColor, cardNum));
            }
        }
        playingCards.put(53, new PlayingCard('j', "oker"));
        playingCards.put(54, new PlayingCard('J', "oker"));
//        playingCards.forEach((key, value) -> {
//            System.out.println(key + ":" + value.getCardColor() + " " + value.getCardNum());
//        });
//        for (PlayingCard playingCard : playingCards) {
//            System.out.println(playingCard.getCardColor() + " " + playingCard.getCardNum());
//        }
        return playingCards;
    }

    /**
     * 卡组洗牌
     */
    public void shuffleCards(Map<Integer,PlayingCard> cardMap){
        List list = new ArrayList();
        for (int i = 1; i <= 54; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            playingCards.add(cardMap.get(list.get(i)));
        }
    }

    /**
     * 发牌
     */
    public void sendPlayingCard(){
        for (int i = 0; i < this.personNum; i++) {
            System.out.print("person" + i);
            System.out.print(": [");
            for (int i1 = 0; i1 < 54; i1++) {
                if ((i1+1) % this.personNum == i)
                    System.out.print(this.playingCards.get(i1).getCardColor() + playingCards.get(i1).getCardNum() + " ");
            }
            System.out.println("]");
        }
    }
}
