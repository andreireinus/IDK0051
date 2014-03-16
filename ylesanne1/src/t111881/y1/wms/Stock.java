package t111881.y1.wms;

import java.util.*;
import java.util.Map.Entry;

import t111881.y1.pos.Order;

/**
 * Laoobjekt
 * 
 * Hoiab meeles kõiki tehtud tehinguid ja hetke laoseisu
 * 
 * @author Andrei Reinus
 */
public class Stock {
	protected List<Transaction> transactions = new ArrayList<Transaction>();
	protected ItemsList items = new ItemsList();

	/**
	 * Lisab tellimuses olevad tooted lattu
	 * 
	 * @param order
	 *            Vastuvõetav tellimus
	 * @throws Exception 
	 */
	public void receive(Order order) throws Exception {
		updateStockWithOrder(order, 1);
	}

	/**
	 * Väljastab laost tellimusega seotud tooted ja vähendab laoseisu
	 * 
	 * @param order
	 *            Väljastatav tellimus
	 * @throws Exception
	 */
	public void dispatch(Order order) throws Exception {
		updateStockWithOrder(order, -1);
	}

	/**
	 * Abifunktsioon, mis muudab laoseisu vastavalt ette antud tellimusele.
	 * 
	 * @param order Tellimus, mis muudab laoseisu
	 * @param multiplier 1 kui lisatakse lattu, -1 kui väljastatakse laost
	 * @throws Exception
	 */
	private void updateStockWithOrder(Order order, Integer multiplier)
			throws Exception {
		Iterator<Entry<Item, Integer>> iterator = order.iterator();

		while (iterator.hasNext()) {
			Entry<Item, Integer> entry = iterator.next();

			Item item = entry.getKey();
			Integer quantity = entry.getValue();

			items.add(item, quantity * multiplier);
			transactions
					.add(new Transaction(item, quantity * multiplier, order));
		}
	}

	/**
	 * Tagastab toote laoseisu
	 * 
	 * @param item
	 * @return 
	 */
	public int getAvailable(Item item) {
		if (items.containsKey(item)) {
			return items.get(item);
		}

		return 0;
	}

	/**
	 * Tagastab tootega seotud lao liikumised
	 * 
	 * @param item
	 * @return
	 */
	public Collection<Transaction> getItemTransactions(Item item) {
		Collection<Transaction> list = new ArrayList<Transaction>();

		for (Transaction t : transactions) {
			if (item.equals(t.getItem())) {
				list.add(t);
			}
		}

		return list;
	}

	/**
	 * Kontrollib kõikide toodete laoseisu
	 * 
	 * @return tõene kui laoseis oli korras.
	 */
	public boolean validateIntegrity() {
		List<Item> checkedItems = new ArrayList<Item>();

		for (Transaction t : transactions) {
			if (checkedItems.contains(t.getItem())) {
				continue;
			}

			checkedItems.add(t.getItem());
			if (!validateIntegrity(t.getItem())) {
				return false;
			}
		}

		Iterator<Entry<Item, Integer>> iterator = items.getIterator();
		while (iterator.hasNext()) {
			Entry<Item, Integer> entry = iterator.next();

			if (checkedItems.contains(entry.getKey())) {
				continue;
			}

			if (!validateIntegrity(entry.getKey())) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Kontrollib toote laoseisu
	 * 
	 * @param item
	 * @return tõene kui laoseis oli korras.
	 */
	public boolean validateIntegrity(Item item) {
		Integer expectedQuantity = 0;
		for (Transaction t : transactions) {
			if (!t.getItem().equals(item)) {
				continue;
			}

			expectedQuantity += t.getQuantity();
		}

		if (items.containsKey(item)) {
			return items.get(item) == expectedQuantity;
		}

		return (expectedQuantity == 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((transactions == null) ? 0 : transactions.hashCode());
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
		Stock other = (Stock) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}

}
