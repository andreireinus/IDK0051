package t111881.y1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import t111881.y1.pos.Order;
import t111881.y1.wms.Item;

/**
 * Tellimuse testid  
 * @author Andrei Reinus
 */
public class OrderTest {
	
	/**
	 * Et saaks koguaeg alustada testimisel nullist
	 * 
	 * @author Andrei Reinus
	 */
	private static class ExtendedOrder extends Order {
		public static void resetOrderNumbering() {
			orderNumberSequence = 0;
		}
	}

	@Test
	public void testToString() throws Exception {
		ExtendedOrder.resetOrderNumbering();
		Order order = new Order();
		assertEquals("Order no 1, 0 items", order.toString());
		order.add(new Item("Piim", 1.00), 1);
		assertEquals("Order no 1, 1 items", order.toString());
	}

	@Test
	public void testGetNumber() {
		ExtendedOrder.resetOrderNumbering();
		Order order = new Order();
		assertEquals(1, order.getNumber());
	}

	@Test
	public void testResetOrderNumbering() {
		ExtendedOrder.resetOrderNumbering();
		Order order = new Order();
		assertEquals(1, order.getNumber());
		Order order2 = new Order();
		assertEquals(2, order2.getNumber());
		
		assertNotSame(order, order2);
		assertNotSame(order.hashCode(), order2.hashCode());
	}

}
