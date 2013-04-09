package y2.game;

import y2.game.players.Player;

public class ExitWonderlandTile extends Tile {

	public ExitWonderlandTile(String name) {
		super(name);
	}

	@Override
	public boolean canEnter(Player player) {
		return (player.getCardByName("DispelCard") != null);
	}
}
