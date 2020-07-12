import java.util.ArrayList;

/**
 * Object-oriented design for a (generic) deck of cards.
 * 
 * @author Gillis Werrebrouck
 */

public class Deck_of_Cards {
    public static void main(final String args[]) {
        final CardDeck cardDeck = new CardDeck();
        cardDeck.setCardOfDeck(getAll52Cards());

        cardDeck.print();
    }

    public static ArrayList<Card> getAll52Cards() {
        final ArrayList<Suits> allSuits = new ArrayList<Suits>(4);
        allSuits.add(Suits.hearts);
        allSuits.add(Suits.diamonds);
        allSuits.add(Suits.clubs);
        allSuits.add(Suits.spades);

        final ArrayList<CardRepresentation> allRepresentations = new ArrayList<CardRepresentation>(13);
        allRepresentations.add(new NonNumericRepresentation(NonNumericCardRepresentations.ace));

        for (int i = 2; i <= 10; i++) {
            allRepresentations.add(new NumericRepresentation(i));
        }

        allRepresentations.add(new NonNumericRepresentation(NonNumericCardRepresentations.jack));
        allRepresentations.add(new NonNumericRepresentation(NonNumericCardRepresentations.queen));
        allRepresentations.add(new NonNumericRepresentation(NonNumericCardRepresentations.king));

        final ArrayList<Integer> allValues = new ArrayList<Integer>(13);
        for (int i = 1; i <= 13; i++) {
            allValues.add(i);
        }

        ArrayList<Card> cards = new ArrayList<Card>(52);
        for (final Suits suit : allSuits) {
            for (int i = 0; i < 13; i++) {
                Card card = new Card(suit, allRepresentations.get(i), allValues.get(i));
                cards.add(card);
            }
        }

        return cards;
    }
}

enum Suits {
    hearts,
    diamonds,
    clubs,
    spades,
}

enum NonNumericCardRepresentations {
    ace,
    jack,
    queen,
    king,
}

abstract class CardRepresentation {}

class NumericRepresentation extends CardRepresentation {
    int representation;

    public NumericRepresentation(final int representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return Integer.toString(this.representation);
    }
}

class  NonNumericRepresentation extends CardRepresentation {
    NonNumericCardRepresentations representation;

    public NonNumericRepresentation(final NonNumericCardRepresentations representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation.toString();
    }
}

class Card {
    private final Suits suit;
    private final CardRepresentation representation;
    private final int value;

    public Card(final Suits suit, final CardRepresentation representation, final int value) {
        this.suit = suit;
        this.representation = representation;
        this.value = value;
    }

    public Suits getSuit() {
        return suit;
    }

    public CardRepresentation getRepresentation() {
        return representation;
    }

    public int getValue() {
        return value;
    }

    public void print() {
        System.out.println(this.representation + " (" + Integer.toString(this.value) + ") of " + this.suit.toString());
    }
}

class CardDeck <T extends Card> {
    private ArrayList<T> cards = new ArrayList<T>(52); // all cards regardless of being dealt or not
    private int dealtIndex = 0; // marks the first undealt card in the deck;

    public void setCardOfDeck(ArrayList<T> deckOfCards) {
        this.cards = deckOfCards;
    }

    public void shuffle() {
        // TODO: add implementation
    }

    public void dealHand(int numberOfHands) {
        // TODO: add implementation
    }

    public void dealCard() {
        // TODO: add implementation
    }

    public void print() {
        for (int i = 0; i < this.cards.size(); i++) {
            cards.get(i).print();
        }
    }
}

class Hand <T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.getValue();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}

class BlackJackHand extends Hand<BlackJackCard> {
    // TODO: add implementation
}

class BlackJackCard extends Card {
    public BlackJackCard(Suits suit, CardRepresentation representation, int value) {
        super(suit, representation, value);
    }

    // TODO: add implementation
}
