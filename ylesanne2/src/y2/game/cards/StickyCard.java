package y2.game.cards;

import y2.game.exceptions.GameException;
import y2.game.players.Player;

public class StickyCard extends ActionCard {
	@Override
	public void onDropped(Player owner) throws Exception {
		throw new GameException("I wont leave you, evar!");
	}
}
