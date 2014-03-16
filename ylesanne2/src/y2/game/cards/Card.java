package y2.game.cards;

import y2.game.exceptions.GameException;
import y2.game.players.Player;

public abstract class Card {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public boolean equals(String name) {
		return getName().toLowerCase().equals(name.toLowerCase());
	}
	
	public boolean isStorable() {
		return true;
	}
	public void onPickedUp(Player owner) throws GameException, Exception {
		
	}
	
	public void onDropped(Player owner) throws GameException {
		
	}
}
