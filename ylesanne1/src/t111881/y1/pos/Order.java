package t111881.y1.pos;

import java.util.Iterator;
import java.util.Map.Entry;

import t111881.y1.wms.Item;
import t111881.y1.wms.ItemsList;

/**
 * Tellimus
 * 
 * @author Andrei Reinus
 */
public class Order {
	private ItemsList items = new ItemsList();
	private int number = 0;

	/**
	 * Konstruktor, annab tellimusele unikaalse numbri
	 */
	public Order() {
		number = getNextOrderNumber();
	}


	public int getNumber() {
		return number;
	}

	/**
	 * Lisab toote tellimusele
	 * 
	 * @param item
	 * @param quantity
	 * @throws Exception
	 */
	public void add(Item item, int quantity) throws Exception {
		items.add(item, quantity);
	}

	/**
	 * Tagastab toodete iteraatori
	 * @return
	 */
	public Iterator<Entry<Item, Integer>> iterator() {
		return items.getIterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + number;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (number != other.number)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order no " + number + ", " + items.size() + " items";
	}

	/// Static ///
	protected static int orderNumberSequence = 0;

	/**
	 * Annab uue tellimuse tellimuse numbri
	 * 
	 * @return
	 */
	private int getNextOrderNumber() {
		return ++orderNumberSequence;
	}
}
