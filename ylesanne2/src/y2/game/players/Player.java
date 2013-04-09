package y2.game.players;

import java.util.ArrayList;
import java.util.List;

import y2.game.Tile;
import y2.game.cards.Card;
import y2.game.cards.VitalityCard;
import y2.game.exceptions.GameException;

public class Player {
	public String name;
	public Tile location;
	
	private int maxVitality = 3;
	private int currentVitality = 3;
	
	private int maxCardsCount = 5;
	public List<Card> cards = new ArrayList<Card>();
	
	public Player(String name, Tile location) {
		this.name = name;
		location.enter(this);
	}
	
	public Player forward() throws Exception {
		return move(location.getNext());
	}
	
	public Player previous() throws Exception {
		return move(location.getPrevious());
	}	
	
	public Player move(Tile to) throws Exception {
		if (to != null) {
			if (currentVitality <= 0) {
				throw new GameException("I am too tired to move");
			}
			location.leave(this);
			to.enter(this);
			currentVitality--;
		}
		return this;
	}
	
	public void sleep() {
		currentVitality = maxVitality;
	}
	
	public String toString() {
		return name;
	}

	public void pickUp(Card card) throws Exception {
		if (cards.size() >= maxCardsCount) {
			throw new GameException("Liiga palju kaarte");
		}
		card.onPickedUp(this);
		
		location.removeCard(card);
		cards.add(card);
	}

	public Card getCardByName(String string) {
		for (Card card : cards) {
			if (card.equals(string)) {
				return card;
			}
		}
		return null;
	}
	
	public void drop(Card card) throws Exception {
		card.onDropped(this);
		cards.remove(card);
		location.addCard(card);
	}
	


	public String lookAt(Player player) throws Exception {
		return null;
	}

	public void modifyMaxVitality(int mod) {
		this.currentVitality = Math.max(0, currentVitality + mod);
		this.maxVitality = maxVitality + mod;
		
	}


	
}


