package y2.game.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import y2.game.Board;
import y2.game.Tile;
import y2.game.cards.PrizeCard;
import y2.game.exceptions.NoVitalityException;
import y2.game.exceptions.TooManyCardsException;
import y2.game.players.Player;

public class GameScenarios {

	@Test
	public void scenario1() {
		Tile t1 = new Tile("start");

		t1.addCard(new PrizeCard());
		assertEquals(1, t1.getCards().size());
		t1.addCard(new PrizeCard());
		assertEquals(2, t1.getCards().size());

	}

	@Test(expected = TooManyCardsException.class)
	public void cardLimit() throws Exception {
		Tile t1 = new Tile("start");
		Player alice = new Player("Alice", t1);

		for (int i = 0; i < 6; i++) {
			t1.addCard(new PrizeCard());
			alice.pickUp(t1.getFirstCard());
		}
	}
	
	@Test(expected = NoVitalityException.class)
	public void vitalityTest() throws Exception {
		Board board = new Board();
		board.append(new Tile("start"));
		board.append(new Tile("next"));
		
		Player player = new Player("p", board.getStart());
		assertEquals(3, player.currentVitality);
		
		player.forward();
		assertEquals(3, player.currentVitality);
		player.previous();
		player.forward();
		
		assertEquals(0, player.currentVitality);
		// 
		player.previous();
		
	}

}
