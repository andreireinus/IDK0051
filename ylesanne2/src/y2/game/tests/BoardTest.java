package y2.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import y2.game.Board;
import y2.game.Tile;

public class BoardTest {

	@Test
	public void testGetstart() {
		Board b = new Board();
		assertNull(b.getstart());
		
		b.append(new Tile("test"));
		assertNotNull(b.getstart());
	}

	@Test
	public void testAppend() {
		Board b = new Board();
		b.append(new Tile("1"));
		assertEquals(1, getBoardLength(b.getstart()));
		b.append(new Tile("2"));
		assertEquals(2, getBoardLength(b.getstart()));
		b.append(new Tile("3"));
		assertEquals(3, getBoardLength(b.getstart()));
		b.append(new Tile("4"));
		assertEquals(4, getBoardLength(b.getstart()));
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
