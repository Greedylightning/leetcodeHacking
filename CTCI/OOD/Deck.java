public Enum Suit{
    Club (0), Diamond (1), Heart (2), Spade (3);
    private int value;
    private Suit(int v){
        value = v;
    }
    public int getValue(){
        return value;
    }
    public static Suit getSuitFromValue(int value){}
}

public class Deck <T extends Card>{
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> setDeckOfCards){}

    public void shuffle(){}

    public int remainingCards(){
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number){}
    public T dealCard(){}
}

public abstract class Card{
    private boolean available = true;
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s){
        faceValue = c;
        suit = s;
    }

    public abstract int getValue(){return faceValue;}
    public Suit getSuit(){return suit;}

    public boolean isAvailable(){return available;}
    public void markAvailable(){available = true;}
    public void markUnavailable(){available = false;}
}

public class Hand<T extends Card>{
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score(){
        int score = 0;
        for(T card : cards){
            score = score + card.getValue();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }
}

public class BlackJackCard extends Card{
    public BlackJackCard(int c, int s){
        super(c,s);
    }

    public int value(){
        if(isAce()) return 1;
        else if(faceValue >= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }

    public boolean isAce(){
        return faceValue == 1;
    }

    public int minValue(){
        if(isAce()) return 1;
        else return value();
    }

    public int maxValue(){
        if(isAce()) return 11;
        else return value();
    }

    public boolean isFaceCard(){
        return faceValue >= 11 && faceValue <= 13;
    }
}

public class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for(int score : scores){
            if(score > 21 && score < MIN_VALUE) minOver = score;
            else if(score <= 21 && score > maxUnder) maxUnder = score;
        }

        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores(){}

    public boolean is21(){return score() == 21}
    public boolean isBlackJack(){}
}