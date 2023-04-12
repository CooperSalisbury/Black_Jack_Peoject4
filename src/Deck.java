import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private int currentIndex;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        currentIndex = 0;
    }

    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
    }

    public Card deal() {
        if (currentIndex >= cards.size()) {
            throw new IllegalStateException("Deck is empty!");
        }
        return cards.get(currentIndex++);
    }
}
