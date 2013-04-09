package y2.game.cards;

import y2.game.players.Player;

public class HypnoticCard extends ActionCard {
	@Override
	public void onPickedUp(Player owner) throws Exception {
		owner.currentVitality = 0;
	}
}
