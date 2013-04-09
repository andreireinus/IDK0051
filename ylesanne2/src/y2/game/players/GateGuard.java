package y2.game.players;

import y2.game.Tile;

public class GateGuard extends Player {

	public GateGuard(String name, Tile tile) {
		super(name, tile);
	}
	
	@Override
	public String lookAt(Player p) throws Exception {
		if (p.getCardByName("keycard") == null) {
			p.previous();
		}
		return null;
	}

}
