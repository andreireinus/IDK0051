package y2.game.cards;

import y2.game.Tile;
import y2.game.players.Player;

public class RewindCard extends ActionCard {
	@Override
	public void onPickedUp(Player owner) throws Exception {
		Tile tile = owner.location;
		
		while (tile.getPrevious() != null) {
			tile = tile.getPrevious();
		}
		owner.move(tile);
	}
}
