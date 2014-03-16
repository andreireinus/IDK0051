package y2.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import y2.game.Board;
import y2.game.Tile;

public class TileTest {

	@Test
	public void testChainPreviousNext() {
		Board b = new Board();
		
		Tile tFirst = new Tile("First");
		Tile tSecond = new Tile("Second");
		Tile tThird = new Tile("Third");
		
		b.append(tFirst);
		b.append(tSecond);
		b.append(tThird);
		
		assertNull(tFirst.getPrevious());
		assertEquals(tSecond, tFirst.getNext());
		
		assertEquals(tFirst, tSecond.getPrevious());
		assertEquals(tThird, tSecond.getNext());
		
		assertEquals(tSecond, tThird.getPrevious());
		assertNull(tThird.getNext());
	}

}
