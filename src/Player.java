import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        int numAces = 0;
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                numAces++;
            } else {
                score += card.getRank().getValue();
            }
        }
        for (int i = 0; i < numAces; i++) {
            if (score + Rank.ACE.getValue() <= 21) {
                score += Rank.ACE.getValue();
            } else {
                score += 1;
            }
        }
        return score;
    }

    public boolean isBust() {
        return getScore() > 21;
    }

    public boolean wantsToHit() {
        return getScore() < 17;
    }

    public int getValue() {
        return getScore();
    }
}
