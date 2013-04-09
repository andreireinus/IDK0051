package y2.game.players;

import java.util.ArrayList;
import java.util.List;

import y2.game.Tile;
import y2.game.cards.*;
/**
 * 
 * { type: "$y2.game.players.Player", value: {name: "Andrei", tile: {"}} }
 * 
 * @author Andrei
 *
 */
public class Player {
	private String name;
	private Tile tile;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	private int baseVitality = 3;
	private int usedVitality = 0;
	
	
	public Player (String name, Tile tile) {
		this.name = name;
		this.tile = tile;
	}
	
	public List<String> move(Tile tile) throws Exception {
		this.tile = tile;
		this.usedVitality++;
		
		return tile.enter(this);
		
	}
	
	public List<String> previous() throws Exception {
		return move(this.tile.getPrevious());
	}
	
	public List<String> next() throws Exception {
		return move(this.tile.getNext());
	}
	
	public void sleep() {
		this.usedVitality = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMaxVitality() {
		int vitality = baseVitality;

		for (Card card : cards) {
			if (card instanceof VitalityCard) {
				vitality++;
			}
		}
		
		return vitality;
	}
	
	public int getVitality() {
		return getMaxVitality() - usedVitality;
	}
	
	public void pickUp(Card card) {
		// TODO - kaartide hulk, mida võib käes olla
		cards.add(card);
	}
	
	public void drop(Card card) {
		tile.addCard(card);
		cards.remove(card);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public Card getCardByName(String name) throws Exception {
		for (Card card : cards) {
			if (card.getName().equals(name))
			{
				return card;
			}
		}
		
		throw new Exception("Kaarti ei leitud");
	}
	
	public String onInteract(Player interactee) {
		return "Tere " + interactee.getName();
	}
	public String interactWith(Player player) {
		return player.onInteract(this);
	}
	public String lookAt(Player player) throws Exception {
		return "";
	}
	
	
}
