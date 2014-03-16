package y2.game.tests;

import org.junit.Test;
import y2.game.Board;
import y2.game.Tile;

import static org.junit.Assert.*;

public class BoardTest {

	@Test
	public void testGetStart() {
		Board b = new Board();
		assertNull(b.getStart());
		
		b.append(new Tile("test"));
		assertNotNull(b.getStart());
	}

	@Test
	public void testAppend() {
		Board b = new Board();
		b.append(new Tile("1"));
		assertEquals(1, getBoardLength(b.getStart()));
		b.append(new Tile("2"));
		assertEquals(2, getBoardLength(b.getStart()));
		b.append(new Tile("3"));
		assertEquals(3, getBoardLength(b.getStart()));
		b.append(new Tile("4"));
		assertEquals(4, getBoardLength(b.getStart()));
	}
	
	
	private int getBoardLength(Tile tile) {
		int length = 1;
		
		while (tile.getNext() != null) {
			tile = tile.getNext();
			length++;
		}
		
		return length;
	}

}
