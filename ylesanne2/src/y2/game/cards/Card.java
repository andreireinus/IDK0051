package y2.game.cards;

import y2.game.players.Player;

public abstract class Card {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void onPickedUp(Player owner) {
		
	}
}
