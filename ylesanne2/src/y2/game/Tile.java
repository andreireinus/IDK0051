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
		
	private List<Player> players = new ArrayList<Player>();
	private List<Card> cards = new ArrayList<Card>();

	public Tile(String name) {
		this.name = name;
	}

	public void enter(Player p) {
		players.add(p);
		p.location = this;
	}
	
	public void leave(Player p) {
		players.remove(p);
		p.location = null;
	}	
	
	public Tile getPrevious() {
		return previous;
	}
	
	public Tile getNext() {
		return next;
	}

	public void setNext(Tile t) {
		this.next = t;
		t.previous = this;
	}
	
	public void setPrevious(Tile t) {
		this.previous = t;
		t.next = this;
	}
	
	public void setBoard(Board b) {
		board = b;
	}
	
	public Board getBoard() {
		return board;
	}
		
	public String toString() {
		return "(" + name + ":" + players + ")";
	}
	
	public boolean canEnter(Player player) {
		return true;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Card getFirstCard() {
		return cards.get(0);
	}

	public void removeCard(Card card) {
		cards.remove(card);
	}
	
}
