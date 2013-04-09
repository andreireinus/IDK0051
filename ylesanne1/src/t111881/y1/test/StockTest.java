package t111881.y1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import t111881.y1.pos.Order;
import t111881.y1.wms.Item;
import t111881.y1.wms.Stock;
import t111881.y1.wms.Transaction;

/**
 * Lao testimised
 * 
 * @author Andrei Reinus
 */
public class StockTest {

	/**
	 * Vigaste andmete loomiseks 
	 * @author Andrei Reinus
	 */
	private class BuggyStock extends Stock {
		public void createBuggy(Item sai, Item piim, Item juust)
				throws Exception {
			items.add(sai, 1);
		}

		public void createBuggy2(Item sai, Item piim, Item juust)
				throws Exception {
			
			Order order = new Order();
			order.add(sai, 1);
			
			items.add(sai, 1);
			transactions.add(new Transaction(sai, 1, order));
			transactions.add(new Transaction(piim, 1, order));
		}
	}

	Item piim = new Item("Piim", 1.00);
	Item sai = new Item("Sai", 1.00);
	Item juust = new Item("Juust", 1.00);

	
	
	@Test
	public void testTransactionsAndAvailable() throws Exception {
		Stock stock = new Stock();
		assertEquals(0, stock.getAvailable(piim));

		Order order = new Order();

		order.add(piim, 1);
		stock.receive(order);

		assertEquals(1, stock.getAvailable(piim));

		stock.dispatch(order);
		assertEquals(0, stock.getAvailable(piim));
	}

	@Test
	public void testGetItemTransactions() throws Exception {
		Stock stock = new Stock();

		assertEquals(0, stock.getItemTransactions(piim).size());

		Order order = new Order();
		order.add(piim, 1);
		stock.receive(order);

		assertEquals(1, stock.getItemTransactions(piim).size());

		stock.dispatch(order);
		assertEquals(2, stock.getItemTransactions(piim).size());
	}

	@Test
	public void testValidateIntegrity() throws Exception {
		Stock correctStock = new Stock();

		Order order = new Order();
		order.add(piim, 1);
		order.add(juust, 1);
		order.add(sai, 1);
		correctStock.receive(order);

		assertEquals(true, correctStock.validateIntegrity());
		assertEquals(true, correctStock.validateIntegrity(juust));

		correctStock.dispatch(order);

		assertEquals(true, correctStock.validateIntegrity());
		assertEquals(true, correctStock.validateIntegrity(sai));

		correctStock.receive(order);

		assertEquals(true, correctStock.validateIntegrity());
		assertEquals(true, correctStock.validateIntegrity(juust));

		BuggyStock buggyStock = new BuggyStock();
		buggyStock.createBuggy(sai, piim, juust);
		assertEquals(false, buggyStock.validateIntegrity());

		buggyStock = new BuggyStock();
		buggyStock.createBuggy2(sai, piim, juust);
		assertEquals(false, buggyStock.validateIntegrity());
	}

}
