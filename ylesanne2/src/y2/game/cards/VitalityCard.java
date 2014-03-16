package y2.game.cards;

import y2.game.players.Player;

public class VitalityCard extends ModifierCard {
	@Override
	public void onDropped(Player owner) {
		owner.modifyMaxVitality(-1);
	}
	
	@Override
	public void onPickedUp(Player owner) {
		owner.modifyMaxVitality(1);
	}
}
