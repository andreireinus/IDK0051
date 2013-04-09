package y2.game.cards;

import y2.game.players.Player;

public class DistractCard extends Card {
	
	@Override
	public void onPickedUp(Player owner) throws Exception {
		for (Card card : owner.cards) {
			owner.drop(card);
			break;
		}
	}
}
