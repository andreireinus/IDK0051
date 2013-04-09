package y2.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import y2.game.cards.Card;
import y2.game.players.Player;

public class Tile {
	private String name;
	
	private Board board;
	private Tile previous;
	private Tile next;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Tile(String name) {
		this.name = name;
	}

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card getFirstCard() throws Exception {
		if (cards.isEmpty()) {
			throw new Exception("Pole kaarte");
		}
		
		Iterator<Card> i = cards.iterator();
		Card card = i.next();
		cards.remove(card);
		return card;
	}
	

	public List<String> enter(Player player) throws Exception {
		ArrayList<String> messages = new ArrayList<String>();
		
		players.add(player);
		
		for (Player p : players) {
			if (p.equals(player)) {
				continue;
			}
			
			String message = player.lookAt(p);
			if (message.length() > 0) {
				messages.add(message);
			}
		}
		
		return messages;
	}
	
	/// Getters -- Setters ///
	public String getName() {
		return name;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Tile getPrevious() {
		return previous;
	}

	public void setPrevious(Tile previous) {
		this.previous = previous;
	}

	public Tile getNext() {
		return next;
	}

	public void setNext(Tile next) {
		this.next = next;
	}

	
	
	
	
}
