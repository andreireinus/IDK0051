package t111881.y1.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import t111881.y1.pos.Cart;
import t111881.y1.pos.Order;
import t111881.y1.wms.Item;

public class CartTest {

	Item piim = new Item("Piim", 1.00);
	Item sai = new Item("Sai", 1.00);
	Item juust = new Item("Juust", 1.00);


	/**
	 * Põhitest, testitakse lisamist, muutmist, ära võtmist ja tühjendamist
	 * @throws Exception
	 */
	@Test
	public void testGetItems() throws Exception {
		Cart cart = new Cart();
		assertEquals(0, cart.getItems().size());
		
		cart.add(piim);
		assertEquals(1, cart.getItems().size());

		cart.add(piim);
		assertEquals(1, cart.getItems().size());
		
		cart.add(juust, 2);
		assertEquals(2, cart.getItems().size());
		
		cart.change(juust, 2);
		assertEquals(2, cart.getItems().size());
		
		cart.remove(juust);
		assertEquals(1, cart.getItems().size());
		
		cart.clear();
		assertEquals(0, cart.getItems().size());
	}

	@Test
	public void testGetTotal() throws Exception {
		Cart cart = new Cart();
		cart.add(juust);
		assertEquals(1, cart.getTotal(), 0);
		cart.add(juust);
		assertEquals(2, cart.getTotal(), 0);
	}

	@Test
	public void testCheckOut() throws Exception {
		Cart cart = new Cart();
		cart.add(juust);
		
		Order order = cart.checkOut();
		int count = 0;
		Iterator<Entry<Item, Integer>> iterator = order.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			count++;
		}
		assertEquals(1, count);
	}

}
