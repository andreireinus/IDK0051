package t111881.y1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import t111881.y1.wms.Item;

/**
 * Toote testid
 * 
 * @author Andrei Reinus
 */
public class ItemTest {

	@Test
	public void gettersTest() {
		Item item = new Item("Piim", 1.00);
		assertEquals("Piim", item.getName());
		assertEquals(1.00, item.getPrice(), 0.00);
	}

	@Test
	public void toStringTest() {
		Item piim = new Item("Piim", 1.12);
		assertEquals("Piim (1.12)", piim.toString());
	}

	@Test
	public void hashCodeTest() {
		Item piim1 = new Item("Piim", 1.00);
		Item piim2 = new Item("Piim", 2.00);
		Item piim3 = new Item("Piim", 1.00);
		assertNotSame(piim1.hashCode(), piim2.hashCode());
		assertEquals(piim1.hashCode(), piim3.hashCode());
	}

	@Test
	public void equalsCodeTest() {
		Item piim1 = new Item("Piim", 1.00);
		Item piim2 = new Item("Piim", 1.00);
		assertTrue(piim1.equals(piim1));
		assertTrue(piim1.equals(piim2));
		
		// Code coverage
		assertEquals(false, piim1.equals(new Object()));
	}
}
