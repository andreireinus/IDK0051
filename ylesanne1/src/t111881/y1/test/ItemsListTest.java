package t111881.y1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import t111881.y1.wms.Item;
import t111881.y1.wms.ItemsList;

/**
 * Toodete nimekirja struktuuri testid.
 * 
 * @author Andrei Reinus
 */
public class ItemsListTest {

	/**
	 * Testitakse lisamist
	 * - Loodud objektis oleks tühi list
	 * - Korduval lisamisel ei tekiks topeltkirjeid
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		ItemsList list = new ItemsList();
		
		assertEquals(0, list.size());
		list.add(new Item("Piim", 0.11), 1);
		assertEquals(1, list.size());
		list.add(new Item("Piim", 0.11), 1);
		assertEquals(1, list.size());
		list.add(new Item("Mahl", 0.11), 1);
		assertEquals(2, list.size());
	}

	/**
	 * Testitakse ära võtmist
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRemoveItem() throws Exception {
		ItemsList list = new ItemsList();
		
		list.add(new Item("Piim", 0.11), 1);
		assertEquals(1, list.size());
		list.remove(new Item("Piim", 0.11));
		assertEquals(0, list.size());
		list.add(new Item("Mahl", 0.11), 1);
		assertEquals(1, list.size());
		list.add(new Item("Piim", 0.11), 1);
		assertEquals(2, list.size());
		
		list.remove(new Item("Piim", 0.11));
		list.remove(new Item("Mahl", 0.11));
		assertEquals(0, list.size());
	}

	/**
	 * Toote koguste lisamist
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddQuantity() throws Exception {
		ItemsList list = new ItemsList();
		Item item = new Item("Piim", 0.11);
		
		list.add(item, 1);
		assertEquals(1, list.getQuantity(item));
		list.addQuantity(item, 1);
		assertEquals(2, list.getQuantity(item));
	}

	/**
	 * Toote koguse määramine
	 * @throws Exception
	 */
	@Test
	public void testSetQuantity() throws Exception {
		ItemsList list = new ItemsList();
		Item item = new Item("Piim", 0.11);
		
		list.add(item, 1);
		assertEquals(1, list.getQuantity(item));
		list.setQuantity(item, 1);
		assertEquals(1, list.getQuantity(item));
		list.setQuantity(item, 5);
		assertEquals(5, list.getQuantity(item));
	}

}
