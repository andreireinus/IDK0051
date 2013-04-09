package y2.game;

public class Board {
	private Tile firstTile;
	private Tile lastTile;
	
	public Tile getstart() {
		return firstTile;
	}
	
	public void append(Tile tile) {
		// First tile
		if (firstTile == null && lastTile == null) {
			firstTile = lastTile = tile;
			return;
		}
		
		lastTile.setNext(tile);
		tile.setPrevious(lastTile);
		lastTile = tile;
	}
}
