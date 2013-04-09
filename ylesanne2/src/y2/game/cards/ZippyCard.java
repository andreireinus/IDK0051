package y2.game.cards;

import y2.game.players.Player;

public class ZippyCard extends ActionCard {
	@Override
	public void onPickedUp(Player owner) throws Exception {
		owner.modifyMaxVitality(1);
	}
}
