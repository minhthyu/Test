package day03;

public class PlayingCard {
    private char cardColor;
    private String cardNum;

    public PlayingCard(char cardColor, String cardNum) {
        this.cardColor = cardColor;
        this.cardNum = cardNum;
    }

    public char getCardColor() {
        return cardColor;
    }

    public void setCardColor(char cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return cardColor +
                "" + cardNum;
    }
}
