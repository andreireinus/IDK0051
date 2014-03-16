package t111881.y1.pos;

import java.util.Iterator;
import java.util.Map.Entry;

import t111881.y1.wms.Item;
import t111881.y1.wms.ItemsList;

/**
 * Ostukorv
 * 
 * @author Andrei Reinus
 */
public class Cart {
	private ItemsList items = new ItemsList();

	/**
	 * Tagastab ostukorvis olevad tooted ja nende kogused
	 * 
	 * @return
	 */
	public ItemsList getItems() {
		return items;
	}

	/**
	 * Lisab 1 toote ostukordi
	 * 
	 * @param item
	 * @throws Exception
	 */
	public void add(Item item) throws Exception {
		add(item, 1);
	}

	/**
	 * Lisab toote koguseliselt ostukorvi
	 * 
	 * @param item
	 * @param quantity
	 * @throws Exception
	 */
	public void add(Item item, int quantity) throws Exception {
		items.add(item, quantity);
	}

	/**
	 * Muudab ostukorvis toote kogust
	 * 
	 * @param item
	 * @param quantity
	 * @throws Exception
	 */
	public void change(Item item, int quantity) throws Exception {
		items.setQuantity(item, quantity);
	}

	/**
	 * Eemaldab toote ostukorvist
	 * 
	 * @param item
	 */
	public void remove(Item item) {
		items.remove(item);
	}

	/**
	 * Tühjendab ostukorvi 
	 * 
	 */
	public void clear() {
		items.clear();
	}

	/**
	 * Tagastab ostukorvi hinna
	 * 
	 * @return
	 */
	public double getTotal() {
		double result = 0;
		
		Iterator<Entry<Item, Integer>> iterator = items.getIterator();

		while (iterator.hasNext()) {
			Entry<Item, Integer> entry = iterator.next();

			result += entry.getKey().getPrice() * entry.getValue();
		}

		return result;
	}

	/**
	 * Teeb ostukorvist tellimuse
	 * 
	 * @return
	 * @throws Exception
	 */
	public Order checkOut() throws Exception {
		Order order = new Order();

		Iterator<Entry<Item, Integer>> iterator = items.getIterator();

		while (iterator.hasNext()) {
			Entry<Item, Integer> entry = iterator.next();

			order.add(entry.getKey(), entry.getValue());
		}
		
		return order;
	}

	@Override
	public String toString() {
		return "Cart, no of items (" + items.size() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		Cart other = (Cart) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
	
}